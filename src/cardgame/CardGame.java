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
                    String newCardValue;
                    String newCardSuit;

                    /* prompt the user for a card, make sure it is a valid input */
                    System.out.println("Pick a card, any card: ");
                    System.out.print("   Select value: ");
                    newCardValue = scanner.next().toUpperCase();
                    /* if incorrect card value, produces an error = need a try/catch */
                    try {
                              Card.Value cv = Card.Value.valueOf(newCardValue);
                    } catch (IllegalArgumentException e) {
                              System.out.print("   Invalid input! Select value from ACE, TWO to TEN, JACK, QUEEN or KING: ");
                              newCardValue = scanner.next().toUpperCase();
                    }

                    System.out.print("   Select suit: ");
                    newCardSuit = scanner.next().toUpperCase();
                    /* if incorrect card suit, produces an error = need a try/catch */
                    try {
                              Card.Suit cs = Card.Suit.valueOf(newCardSuit);
                    } catch (IllegalArgumentException e) {
                              System.out.print("   Invalid input! Select suit from HEARTS, CLUBS, SPADES or DIAMONDS: ");
                              newCardSuit = scanner.next().toUpperCase();
                    }

                    Card newCard = new Card(Card.Value.valueOf(newCardValue), Card.Suit.valueOf(newCardSuit));
                    // System.out.print(newCard.getValue() + " " + newCard.getSuit());
                    System.out.println();

                    /* check if card is in hand */
                    boolean cardInHand = false;
                    for (Card c : cards) {
                              if (c.getValue() == newCard.getValue() && c.getSuit() == newCard.getSuit()) {
                                        cardInHand = true;
                                        break;
                              } else {
                                        cardInHand = false;
                              }
                    }

                    if (cardInHand == true) {
                              System.out.println("User's card found in magic hand!");
                    } else {
                              System.out.println("User's card NOT found in magic hand!");
                    }

                    scanner.close();
          }
}
