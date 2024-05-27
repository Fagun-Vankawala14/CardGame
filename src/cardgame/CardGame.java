/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Kashvi Tewari
 * Student Number:991736180
 */
public class CardGame {
    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[] hand;

    public CardGame() {
        hand = new String[7];
        handRandomCards();
    }

    private void handRandomCards() {
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int suitIndex = random.nextInt(suits.length);
            int rankIndex = random.nextInt(ranks.length);
            hand[i] = ranks[rankIndex] + " of " + suits[suitIndex];
        }
    }

    public void printHand() {
        System.out.println("Your hand of cards:");
        for (String card : hand) {
            System.out.println(card);
        }
    }

    public boolean isCardInHand(String userCard) {
        for (String card : hand) {
            if (card.equalsIgnoreCase(userCard)) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        CardGame game = new CardGame();

        game.printHand();

        System.out.println("Pick a card :");
        String userCard = scanner.nextLine();

        if (game.isCardInHand(userCard)) {
            System.out.println("Congratulations! Your card is in the magic hand of random cards!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand of random cards.");
        }

        scanner.close();
    }
    
}
