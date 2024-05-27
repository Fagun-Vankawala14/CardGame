/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author fagun
 * 
 * Name:Freny Vahanka
 * StudentID:- 991735491
 * 
 */
public class CardGame {

    /**
    * @param args the command line arguments
    */
    

    private static final int TOTAL_CARDS = 52;
    private static final int HAND_SIZE = 7;
    private final Card[] playerHand;
    private final Card[] deck;

    public CardGame() {
        deck = initializeDeck();
        playerHand = new Card[HAND_SIZE];
        shuffleDeck();
    }

    private Card[] initializeDeck() {
        Card[] deck = new Card[TOTAL_CARDS];
        for (int i = 0; i < TOTAL_CARDS; i++) {
            deck[i] = new Card(Card.Value.values()[i % 13], Card.Suit.values()[i / 13]);
        }
        return deck;
    }

    private void shuffleDeck() {
        Random rand = new Random();
        for (int i = TOTAL_CARDS - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        System.arraycopy(deck, 0, playerHand, 0, HAND_SIZE);
    }

    public boolean isCardInHand(Card card) {
        for (Card cardInHand : playerHand) {
            if (cardInHand.equals(card)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        Scanner scanner = new Scanner(System.in);
        
        Card.Value value = null;
        while (value == null) {
            try {
                System.out.println("Choose the value of card (ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING):");
                String valueInput = scanner.next().toUpperCase();
                value = Card.Value.valueOf(valueInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid value. Please try again.");
            }
        }
        
        Card.Suit suit = null;
        while (suit == null) {
            try {
                System.out.println("Choose the suit of the card (HEARTS, CLUBS, SPADES, DIAMONDS):");
                String suitInput = scanner.next().toUpperCase();
                suit = Card.Suit.valueOf(suitInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid suit. Please try again.");
            }
        }

        Card userCard = new Card(value, suit);
        boolean isInHand = game.isCardInHand(userCard);
        if (isInHand) {
            System.out.println("Your card is in the magic hand of random cards!");
        } else {
            System.out.println("Your card is not in the magic hand of random cards.");
        }

        scanner.close();
    }
}
