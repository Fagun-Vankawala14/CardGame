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
 * Jashanpreet Kaur Chahal
 * Student Number: 991733032
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Card[] hand = generateHand();
        printsHand(hand);

        try {
            String suit = JOptionPane.showInputDialog("Pick a card suit (HEARTS, CLUBS, SPADES, DIAMONDS):");
            if (suit == null) {
                JOptionPane.showMessageDialog(null, "Suit not entered.Program ends.");
                return;
            }
            suit = suit.toUpperCase().trim();

            String value = JOptionPane.showInputDialog("Pick a card value (ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING):");
            if (value == null) {
                JOptionPane.showMessageDialog(null, "Value not entered.Program ends.");
                return;
            }
            value = value.toUpperCase().trim();

            Card.Suit userSuit = Card.Suit.valueOf(suit);
            Card.Value userValue = Card.Value.valueOf(value);
            Card userCard = new Card(userValue, userSuit);

            boolean found = searchesHand(hand, userCard);
            if (found) {
                JOptionPane.showMessageDialog(null, "Your card is in the magic hand!");
            } else {
                JOptionPane.showMessageDialog(null, "Your card is not in the magic hand.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Invalid suit or value");
        }
    }

    private static Card[] generateHand() {
        Card[] hand = new Card[7];
        Random random = new Random();

        for (int i = 0; i < hand.length; i++) {
            Card.Suit suit = Card.Suit.values()[random.nextInt(Card.Suit.values().length)];
            Card.Value value = Card.Value.values()[random.nextInt(Card.Value.values().length)];
            hand[i] = new Card(value, suit);
        }

        return hand;
    }

    private static void printsHand(Card[] hand) {
        System.out.println("Magic hand is:");
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
    }

    private static boolean searchesHand(Card[] hand, Card userCard) {
        for (Card card : hand) {
            if (card.getSuit() == userCard.getSuit() && card.getValue() == userCard.getValue()) {
                return true;
            }
        }
        return false;
    }
}
