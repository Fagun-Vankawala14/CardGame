/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author fagun
 */
/**
 * CardGame class models a hand of seven cards.
 * ROMY ROMY
 * Student Number: 991725977
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Card[] hand = generateRandomHand();
        printHand(hand);

        try {
            String suitInput = JOptionPane.showInputDialog("Pick a card suit (HEARTS, CLUBS, SPADES, DIAMONDS):");
            if (suitInput == null) {
                JOptionPane.showMessageDialog(null, "No suit entered. Exiting program.");
                return;
            }
            suitInput = suitInput.toUpperCase().trim();

            String valueInput = JOptionPane.showInputDialog("Pick a card value (ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING):");
            if (valueInput == null) {
                JOptionPane.showMessageDialog(null, "No value entered. Exiting program.");
                return;
            }
            valueInput = valueInput.toUpperCase().trim();

            Card.Suit userSuit = Card.Suit.valueOf(suitInput);
            Card.Value userValue = Card.Value.valueOf(valueInput);
            Card userCard = new Card(userValue, userSuit);

            boolean cardFound = searchHand(hand, userCard);
            if (cardFound) {
                JOptionPane.showMessageDialog(null, "Your card is in the magic hand!");
            } else {
                JOptionPane.showMessageDialog(null, "Your card is not in the magic hand.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Invalid suit or value. Please run the program again and enter valid card details.");
        }
    }

    private static Card[] generateRandomHand() {
        Card[] hand = new Card[7];
        Random random = new Random();

        for (int i = 0; i < hand.length; i++) {
            Card.Suit suit = Card.Suit.values()[random.nextInt(Card.Suit.values().length)];
            Card.Value value = Card.Value.values()[random.nextInt(Card.Value.values().length)];
            hand[i] = new Card(value, suit);
        }

        return hand;
    }

    private static void printHand(Card[] hand) {
        System.out.println("Magic hand:");
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
    }

    private static boolean searchHand(Card[] hand, Card userCard) {
        for (Card card : hand) {
            if (card.getSuit() == userCard.getSuit() && card.getValue() == userCard.getValue()) {
                return true;
            }
        }
        return false;
    }
}

