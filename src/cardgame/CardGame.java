/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import java.util.Random;

/**
 *
 * @author Aayush-991730544
 */
public class CardGame {

    private String[] suits = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
    private String[] values = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};
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

    public void printHand() {
        for (String card : this.hand) {
            System.out.println(card);
        }
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printHand();
    }
}