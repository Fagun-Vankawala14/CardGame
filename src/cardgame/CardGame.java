package cardgame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fagun
 * @author Patricia Gariando
 *
 */
// 2024MAY13 - Patricia - Modified
public class CardGame {

          /**
           * @param args the command line arguments
           */
          public static void main(String[] args) {
                    /* - - - - - PART 1 - - - - - */
                    Scanner scanner = new Scanner(System.in);
                    Random random = new Random();

                    /* store the enums in an array */
                    Card.Value[] values = Card.Value.values();
                    int valuesSize = values.length;
                    Card.Suit[] suits = Card.Suit.values();
                    int suitsSize = suits.length;

                    /* create an array to store 7 random cards */
                    Card[] cards = new Card[7];
                    for (int i = 0; i < cards.length; i++) {
                              cards[i] = new Card(values[random.nextInt(valuesSize)], suits[random.nextInt(suitsSize)]);
                    }

                    /* replace duplicates in the deck */
                    for (int i = 0; i < cards.length; i++) {
                              for (int j = 0; j < cards.length; j++) {
                                        // System.out.println(cards[i].getValue() + " " + cards[i].getSuit() + " " + cards[j].getValue() + " " + cards[j].getSuit());
                                        if (cards[i] == cards[j]) {
                                                  cards[i] = new Card(values[random.nextInt(valuesSize)], suits[random.nextInt(suitsSize)]);
                                        }
                              }
                    }

                    /* display user's magic hand */
                    System.out.println("User's magic hand: ");
                    for (int x = 0; x < cards.length; x++) {
                              System.out.println("   Card " + (x + 1) + ": " + cards[x].getValue() + " " + cards[x].getSuit());
                    }

                    System.out.println();

                    /* - - - - - PART 2 - - - - - */
 /* create a lucky card */
                    Card luckyCard = new Card(Card.Value.JACK, Card.Suit.DIAMONDS);
                    System.out.println("< Lucky Card has been C H O S E N >");
                    System.out.println();

                    /* check if card is in hand */
                    boolean cardInHand = false;
                    for (Card c : cards) {
                              if (c.getValue() == luckyCard.getValue() && c.getSuit() == luckyCard.getSuit()) {
                                        cardInHand = true;
                                        break;
                              } else {
                                        cardInHand = false;
                              }
                    }

                    if (cardInHand == true) {
                              System.out.println("Lucky Card is found in magic hand!");
                    } else {
                              System.out.println("Lucky Card is NOT found in magic hand!");
                    }

                    scanner.close();
          }
}
