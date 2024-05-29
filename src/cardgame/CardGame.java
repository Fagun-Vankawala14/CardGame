import java.util.Random;

public class CardGame {
    private Card[] hand = new Card[7];
    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

    /**
     * CardGame class models a hand of seven cards.
     * Modifier: [Your Name], Student ID: [Your Student ID]
     * Date Modified: [Current Date]
     */
    public CardGame() {
        Random rand = new Random();
        for (int i = 0; i < hand.length; i++) {
            int number = rand.nextInt(13) + 1; // Card numbers 1-13
            String suit = suits[rand.nextInt(suits.length)];
            hand[i] = new Card(number, suit);
        }
    }

    public boolean searchCard(Card card) {
        for (Card c : hand) {
            if (c.equals(card)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();

        // Hard-coded lucky card
        Card luckyCard = new Card(7, "Hearts");
        System.out.println("The lucky card is: " + luckyCard);

        if (game.searchCard(luckyCard)) {
            System.out.println("You have the lucky card!");
        } else {
            System.out.println("You do not have the lucky card.");
        }

        // For testing: Print all cards in hand
        System.out.println("The cards in hand are:");
        for (Card card : game.hand) {
            System.out.println(card);
        }
    }
}


