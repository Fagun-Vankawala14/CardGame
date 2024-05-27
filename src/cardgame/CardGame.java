/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.util.Random;
import java.util.Scanner;

public class CardGame {
    
    public static void main(String[] args) {
        
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
      
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
       
        String[] hand = new String[7];
        
        Random rand = new Random();
        
        
        for (int i = 0; i < hand.length; i++) {
            String card = values[rand.nextInt(values.length)] + " of " + suits[rand.nextInt(suits.length)];
            hand[i] = card;
        }
        
        
        System.out.println("Hand of cards:");
        for (String card : hand) {
            System.out.println(card);
        }
        
     
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card (value and suit): ");
        String userCard = scanner.nextLine();
        
        
        boolean found = false;
        for (String card : hand) {
            if (card.equalsIgnoreCase(userCard)) {
                found = true;
                break;
            }
        }
        
       
        if (found) {
            System.out.println("Your card is in the hand!");
        } else {
            System.out.println("Your card is not in the hand.");
        }
        
        scanner.close();
    }
}