package cardgame;

import cardgame.Card.Suit;
import cardgame.Card.Value;
import java.util.Random;

public class CardHandGenerator {

    public static Card[] generateHand(int numCards, Value[] cardValues, Suit[] cardSuits) {
        // TODO - implement CardHandGenerator.generateHand
        Random random = new Random();
        
        Card[] hand = new Card[numCards];
        for (int i = 0; i < hand.length; i++) {
            Card.Value value = Card.Value.values()[random.nextInt(13)];
            Card.Suit suit = Card.Suit.values()[random.nextInt(4)];
            // Value value = Card.Value.values()[random.nextInt(cardValues.length)];
            // Suit suit = Card.Suit.values()[random.nextInt(cardSuits.length)];

            Card card = new Card(value, suit);
            hand[i] = card;
        }
         return hand;
    }

}
