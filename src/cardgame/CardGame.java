/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.util.Scanner;
import java.util.Random;
import cardgame.Card.Value;

/**
 *
 * @author fagun
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        Card[] hand = new Card[7];
        
        
        
        System.out.println("Choose a suit for your lucky card: ");
        for(int i= 0; i<Card.Suit.values().length; i++)
        {
            System.out.println(i +" "+Card.Suit.values()[i]);
               
        
        }
        
        int suitPosition = input.nextInt()-1;
           System.out.println("Enter a value 1  to 13");
       int valuePosition = input.nextInt()-1;
        
        Card.Suit chosenSuit = Card.Suit.values()[suitPosition];
        Card.Value chosenValue = Card.Value.values()[valuePosition];
        Card userGuess = new Card(chosenValue, chosenSuit);
        
       
       
       
       boolean match = false;
       for(Card card: hand){
           if(card.getValue() == userGuess.getValue()
                 && card.getSuit() == userGuess.getSuit()){
               match = true;
               break;
           
           }
                   
       
       
       
    }
       
}
    
}



















