/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Avleen Kaur 
 * Student id: 991730891
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                Card[] hand = new Card[7];
        fillHandWithRandomCards(hand);
        
        System.out.println("Magic Hand of Cards:");
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card (value and suit).");
        System.out.print("Enter card value (e.g., ACE, TWO, KING): ");
        String valueInput = scanner.next().toUpperCase();
        System.out.print("Enter card suit (HEARTS, CLUBS, SPADES, DIAMONDS): ");
        String suitInput = scanner.next().toUpperCase();

        Card.Value userValue = Card.Value.valueOf(valueInput);
        Card.Suit userSuit = Card.Suit.valueOf(suitInput);

        boolean found = searchHandForCard(hand, userValue, userSuit);
        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is NOT in the magic hand.");
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
