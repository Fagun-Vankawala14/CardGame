package cardgame;

import java.util.Random;
import java.util.Scanner;

/**
 * A simple card game that generates a "magic hand" of cards and allows the user to guess a card.
 * Author: Muskandeep
 * Student ID: 991726879
 */
public class CardGame {

    public static void main(String[] args) {
        Card[] hand = new Card[7];
        fillHandWithRandomCards(hand);
        
        System.out.println("Magic Hand of Cards:");
        for (Card card : hand) {
            System.out.println(card);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card (value and suit).");
        System.out.print("Enter card value (e.g., ACE, TWO, KING): ");
        String valueInput = scanner.next().toUpperCase();
        System.out.print("Enter card suit (HEARTS, CLUBS, SPADES, DIAMONDS): ");
        String suitInput = scanner.next().toUpperCase();

        try {
            Card.Value userValue = Card.Value.valueOf(valueInput);
            Card.Suit userSuit = Card.Suit.valueOf(suitInput);

            boolean found = searchHandForCard(hand, userValue, userSuit);
            if (found) {
                System.out.println("Your card is in the magic hand!");
            } else {
                System.out.println("Your card is NOT in the magic hand.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid card value or suit. Please try again.");
        }
    }

    private static void fillHandWithRandomCards(Card[] hand) {
        Random rand = new Random();
        for (int i = 0; i < hand.length; i++) {
            Card.Value value = Card.Value.values()[rand.nextInt(Card.Value.values().length)];
            Card.Suit suit = Card.Suit.values()[rand.nextInt(Card.Suit.values().length)];
            hand[i] = new Card(value, suit);
        }
    }

    private static boolean searchHandForCard(Card[] hand, Card.Value value, Card.Suit suit) {
        for (Card card : hand) {
            if (card.getValue() == value && card.getSuit() == suit) {
                return true;
            }
        }
        return false;
    }
}        