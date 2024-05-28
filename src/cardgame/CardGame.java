/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import java.util.Random;

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
    
    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printHand();
    }
    
}
