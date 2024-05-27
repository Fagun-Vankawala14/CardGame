/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package cardgame;
import java.util.*;
/**
 *
 * @author fagun
 * 
 */
public class CardGame {
    private static final int CARDS = 52;
    private static final int HAND_SIZE = 7;
    private Card[] hand;

    public CardGame() {
        this.hand = new Card[HAND_SIZE];
        shuffleDeck();
        dealHand();
    }

    private void shuffleDeck() {
        Card[] deck = new Card[CARDS];
        for (int i = 0; i < CARDS; i++) {
            Card.Suit suit = Card.Suit.values()[i / 13];
            Card.Value value = Card.Value.values()[i % 13];
            deck[i] = new Card(value, suit);
        }
        Random rand = new Random();
        for (int i = CARDS - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        for (int i = 0; i < HAND_SIZE; i++) {
            hand[i] = deck[i];
        }
    }

    private void dealHand() {
        // implementation of dealing the hand to the player
    }

    public boolean isCardInHand(Card card) {
        for (Card c : hand) {
            if (c.getValue() == card.getValue() && c.getSuit() == card.getSuit()) {
                return true;
            }
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      CardGame game = new CardGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of the card (ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, JACL):");
        String valueInput = scanner.next().toUpperCase();
        System.out.println("Enter the suit of the card (HEARTS, CLUBS, SPADES, DIAMONDS):");
        String suitInput = scanner.next().toUpperCase();
        Card.Value value = Card.Value.valueOf(valueInput);
        Card.Suit suit = Card.Suit.valueOf(suitInput);
        Card userCard = new Card(value, suit);
        boolean isInHand = game.isCardInHand(userCard);
        if (isInHand) {
            System.out.println("Your card is in the magic hand of random cards!");
        } else {
            System.out.println("Your card is not in the magic hand of random cards.");
   }
 }
}
