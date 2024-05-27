/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import java.util.Random;

/**
 *
 * @author fagun
 */
public class CardGame {

    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String[] hand;

    public CardGame() {
        this.hand = new String[7];
        this.dealHand();
    }

    private void dealHand() {
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            String value = values[random.nextInt(values.length)];
            String suit = suits[random.nextInt(suits.length)];
            this.hand[i] = value + " of " + suit;
        }
    }

    public void PrintHand() {
        for (String card : this.hand) {
            System.out.println(card);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.PrintHand();
    }
}
