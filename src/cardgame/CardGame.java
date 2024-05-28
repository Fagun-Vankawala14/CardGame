package Cardgame;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * CardGame class models a hand of seven cards.
 * Muskandeep
 * Student Number: 991726879
 */
public class CardGame {

    public static void main(String[] args) {
        Card[] hand = generateRandomHand();
        printHand(hand);

        Card userCard = getUserCardInput();
        if (userCard == null) {
            JOptionPane.showMessageDialog(null, "Exiting program.");
            return;
        }

        boolean cardFound = searchHand(hand, userCard);
        if (cardFound) {
            JOptionPane.showMessageDialog(null, "Your card is in the magic hand!");
        } else {
            JOptionPane.showMessageDialog(null, "Your card is not in the magic hand.");
        }
    }

    /**
     * Generates a random hand of seven cards.
     * @return an array of 7 Card objects
     */
    private static Card[] generateRandomHand() {
        Card[] hand = new Card[7];
        Random random = new Random();

        for (int i = 0; i < hand.length; i++) {
            Suit suit = Suit.values()[random.nextInt(Suit.values().length)];
            Value value = Value.values()[random.nextInt(Value.values().length)];
            hand[i] = new Card(value, suit);
        }

        return hand;
    }

    /**
     * Prints the hand of cards to the console.
     * @param hand an array of Card objects
     */
    private static void printHand(Card[] hand) {
        System.out.println("Magic hand:");
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
    }

    /**
     * Prompts the user to input a card suit and value.
     * @return the Card object representing the user's choice, or null if invalid input is provided
     */
    private static Card getUserCardInput() {
        try {
            String suitInput = JOptionPane.showInputDialog("Pick a card suit (HEARTS, CLUBS, SPADES, DIAMONDS):");
            if (suitInput == null || suitInput.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No suit entered.");
                return null;
            }
            suitInput = suitInput.toUpperCase().trim();

            String valueInput = JOptionPane.showInputDialog("Pick a card value (ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING):");
            if (valueInput == null || valueInput.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No value entered.");
                return null;
            }
            valueInput = valueInput.toUpperCase().trim();

            Suit userSuit = Suit.valueOf(suitInput);
            Value userValue = Value.valueOf(valueInput);
            return new Card(userValue, userSuit);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Invalid suit or value. Please run the program again and enter valid card details.");
            return null;
        }
    }

    /**
     * Searches for a specific card in the hand.
     * @param hand an array of Card objects
     * @param userCard the Card object to search for
     * @return true if the card is found, false otherwise
     */
    private static boolean searchHand(Card[] hand, Card userCard) {
        for (Card card : hand) {
            if (card.equals(userCard)) {
                return true;
            }
        }
        return false;
    }
}

class Card {
    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card card = (Card) obj;
        return value == card.value && suit == card.suit;
    }
}

enum Suit {
    HEARTS, CLUBS, SPADES, DIAMONDS
}

enum Value {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}