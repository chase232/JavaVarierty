package com.oreillyauto.w0602;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    public BlackJack() {
        
        String playerOption = printSetUp();
        
        switch(playerOption) {
            case "1":
                playBlackJack();
                break;
           default:
               break;
        }
    }
    
    private String printSetUp() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("Please Select One of the Following: ");
        try (Scanner scanner2 = new Scanner(System.in)) {
            System.out.println("To Play:\t Press 1");
            System.out.println("To Quit:\t Press 2");
            return scanner2.nextLine();
            }
    }
    
    private void playBlackJack() {
        System.out.println("Let's Play: ");

        Deck deck = new Deck();
        
        Hand dealerHand = new Hand();
        Hand playerHand = new Hand();
        
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        
        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        
        
    }
    
    public static void main(String[] args) {
          
        new BlackJack();
    }

}
