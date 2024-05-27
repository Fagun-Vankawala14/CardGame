/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

/**
 *
 * @author fagun
 */

import java.util.Random;
import java.util.Scanner;

public class CardGame {

    /**
     * @param args the command line arguments
     */
    
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int HAND_SIZE = 7;
    private String[][] hand;

    public CardGame() {
        hand = new String[HAND_SIZE][2];
        generateHand();
    }

    private void generateHand() {
        Random rand = new Random();
        for (int i = 0; i < HAND_SIZE; i++) {
            hand[i][0] = VALUES[rand.nextInt(VALUES.length)];
            hand[i][1] = SUITS[rand.nextInt(SUITS.length)];
        }
    }

    public void printHand() {
        System.out.println("Your hand of cards is:");
        for (int i = 0; i < HAND_SIZE; i++) {
            System.out.println(hand[i][0] + " of " + hand[i][1]);
        }
    }

    public boolean searchCard(String value, String suit) {
        for (int i = 0; i < HAND_SIZE; i++) {
            if (hand[i][0].equals(value) && hand[i][1].equals(suit)) {
                return true;
            }
        }
         return false;
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        CardGame cardGame = new CardGame();
        cardGame.printHand();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card value (e.g., 2, 3, ..., Ace): ");
        String value = scanner.nextLine();
        System.out.println("Pick a card suit (Hearts, Diamonds, Clubs, Spades): ");
        String suit = scanner.nextLine();

        if (cardGame.searchCard(value, suit)) {
            System.out.println("The card " + value + " of " + suit + " is in your hand!");
        } else {
            System.out.println("The card " + value + " of " + suit + " is not in your hand.");
        }

        scanner.close();

    }
    
}
