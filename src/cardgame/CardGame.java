/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import cardgame.Card.Suit;
import cardgame.Card.Value;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fagun
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       // Card[] hand = new Card[7];
        //Value[] cardValues = Value.values();
        //Suit[] cardSuits = Suit.values();
//        Random random = new Random();
//        for (int i = 0; i < hand.length; i++) {
//            Value value = Card.Value.values()[random.nextInt(13)];
//            Suit suit = Card.Suit.values()[random.nextInt(4)];
//           // Value value = Card.Value.values()[random.nextInt(cardValues.length)];
//           // Suit suit = Card.Suit.values()[random.nextInt(cardSuits.length)];
//
//            Card card = new Card(value, suit);
//            hand[i] = card;
//        }

        Card[] hand = CardHandGenerator.generateHand(7,Card.Value.values(),Card.Suit.values());
        //print each card so we can see what was generated
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        //ask user for Card
        System.out.println("Please choose a suit for your lucky card:");
        for (int i = 0; i < Card.Suit.values().length; i++) {
            System.out.println((i + 1) + ": " + Card.Suit.values()[i]);
        }

        int suit = input.nextInt() - 1;
        
        System.out.println("Enter a value");
         for (int i = 0; i < Card.Value.values().length; i++) {
            System.out.println((i + 1) + ": " + Card.Value.values()[i]);
        }
        int value = input.nextInt() - 1;
        //create new Card with the two values chosen
         Card userGuess = new Card(Card.Value.values()[value], Card.Suit.values()[suit]);
       // Card userGuess = new Card(cardValues[valuePosition], cardSuits[suitPosition]);

        //check if it matches
        boolean match = false;
        for (Card card : hand) {
            if (card.getValue() == userGuess.getValue()
                    && (card.getSuit()== userGuess.getSuit())) {
                match = true;
                break;
            }
        }

        String result = match ? "Right guess" : "No match";
        System.out.println("Did you guess it? " + result);
    }

}
