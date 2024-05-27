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
 */
public class CardGame {

    private final Card[] hand;
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final int HAND_SIZE = 7;

    public CardGame() {
        hand = new Card[HAND_SIZE];
        Random random = new Random();

        for (int i = 0; i < HAND_SIZE; i++) {
            int value = random.nextInt(13) + 1; // Card values from 1 to 13
            String suit = SUITS[random.nextInt(SUITS.length)];
            hand[i] = new Card(value, suit);
        }
    }

    public void displayHand() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public boolean searchCard(int value, String suit) {
        for (Card card : hand) {
            if (card.getValue() == value && card.getSuit().equalsIgnoreCase(suit)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.displayHand();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card (value and suit): ");
        int value = scanner.nextInt();
        String suit = scanner.next();

        if (game.searchCard(value, suit)) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is NOT in the magic hand.");
        }
    }
}

