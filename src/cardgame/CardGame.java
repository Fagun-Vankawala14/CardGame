/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;


/* Snehdeep Kaur
 * Student Number: 991724584
 */

import java.util.Random;
import java.util.Scanner;

public class CardGame {
    private Card[] hand;
    private static final int HAND_SIZE = 7;
    private static final Card.Suit[] suits = Card.Suit.values();

    public CardGame() {
        hand = new Card[HAND_SIZE];
        generateHand();
    }

    private void generateHand() {
        Random random = new Random();
        for (int i = 0; i < HAND_SIZE; i++) {
            Card.Suit suit = suits[random.nextInt(suits.length)];
            Card.Value value = getRandomValue(random);
            hand[i] = new Card(value, suit);
        }
    }

    private Card.Value getRandomValue(Random random) {
        return Card.Value.values()[random.nextInt(Card.Value.values().length - 1)];
    }

    public void printHand() {
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
    }

    public boolean containsCard(Card card) {
        for (Card c : hand) {
            if (c.getValue() == card.getValue() && c.getSuit() == card.getSuit()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printHand();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of your card (e.g., ACE, KING, QUEEN): ");
        String valueInput = scanner.nextLine().toUpperCase();
        System.out.print("Enter the suit of your card (e.g., HEARTS, DIAMONDS, CLUBS, SPADES): ");
        String suitInput = scanner.nextLine().toUpperCase();

        Card.Value value = Card.Value.valueOf(valueInput);
        Card.Suit suit = Card.Suit.valueOf(suitInput);
        Card userCard = new Card(value, suit);

        if (game.containsCard(userCard)) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }
    }
}