/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgamedemo;

//import cardgamedemo.Card.Suit;
//import cardgamedemo.Card.Value;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fagun
 */
public class CardGameDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //With Enum
        //Value[] cardValues = Value.values();
        //Suit[] cardSuits = Suit.values();
        Card[] hand = new Card[7];
        Random random = new Random();
        for (int i = 0; i < hand.length; i++) {

            int value = random.nextInt(13) + 1;
            String suit = Card.SUITS[random.nextInt(4)];

            //With Enum
            //Value value = cardValues[random.nextInt(cardValues.length)];
            //Suit suit = cardSuits[random.nextInt(cardSuits.length)];
            Card card = new Card(value, suit);
            hand[i] = card;
        }
        
        //After CardHandGenerator.java
        //Card[] hand = CardHandGenerator.generateHand(7);
        
        //print each card so we can see what was generated
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        //ask user for Card
        System.out.println("Please choose a suit for your lucky card:");
        for (int i = 0; i < Card.SUITS.length; i++) {
            System.out.println((i + 1) + ": " + Card.SUITS[i]);
        }

        //With Enum
        /*for (int i = 0; i < cardSuits.length; i++) {
            System.out.println((i + 1) + ": " + Card.Suit.values()[i]);
        }*/
        int suitPosition = input.nextInt() - 1;
        System.out.println("Enter a value (1 to 13)");
        int valuePosition = input.nextInt() - 1;
        //create new Card with the two values chosen
        Card userGuess = new Card(valuePosition, Card.SUITS[suitPosition - 1]);

        //With Enum
        //Card userGuess = new Card(cardValues[valuePosition], cardSuits[suitPosition - 1]);
        //check if it matches
        boolean match = false;
        for (Card card : hand) {
            if (card.getValue() == userGuess.getValue()
                    && (card.getSuit().equals(userGuess.getSuit()))) {
                match = true;
                break;
            }
        }
        String result = match ? "Rigth Guess" : "NO match";
        System.out.println("Did you guess it? " + result);
    }

}
