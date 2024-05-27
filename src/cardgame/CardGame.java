/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.util.Random;
import java.util.Scanner;

public class CardGame {
    // Ritika Ritika
    // 991729259
    
    
    private static final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int size = 7;
    private String[][] hand;

    public CardGame() {
        hand = new String[size][2];
        generateHand();
    }

    private void generateHand() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            hand[i][0] = values[rand.nextInt(values.length)];
            hand[i][1] = suits[rand.nextInt(suits.length)];
        }
    }

    public void printHand() {
        System.out.println("Your hand of cards is:");
        for (int i = 0; i < size; i++) {
            System.out.println(hand[i][0] + " of " + hand[i][1]);
        }
    }

    public boolean searchCard(String value, String suit) {
        for (int i = 0; i < size; i++) {
            if (hand[i][0].equals(value) && hand[i][1].equals(suit)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.printHand();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card value from 2, 3, ..., Ace: ");
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


   


