/*
 * Program:     BlackJack
 * Developer:   Chase Dickerson
 * Date:        11/10/2018
 * Purpose:     Creates a game of black jack
 */

package com.oreillyauto.w0602;

import java.util.Scanner;

public class BlackJack {

    String playerInput;
    Scanner scanner2 = new Scanner(System.in);
    boolean gameOver = false;
    
    public BlackJack() {
        
        newGame();
    }

    private String printSetUp() {
        System.out.println("\n\nWelcome to Blackjack!");
        System.out.println("Please Select One of the Following: ");
        System.out.println("To Play:\t Press 1");
        System.out.println("To Quit:\t Press 2");
        return scanner2.nextLine();
    }

    private void playBlackJack() {
        System.out.println("Let's Play: ");

        Deck deck = new Deck();

        Hand dealerHand = new Hand();
        Hand playerHand = new Hand();

        deck.shuffleDeck();

        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());

        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        
        while (true) {
            System.out.println("Your hand is currently: ");
            for (int i = 0; i < playerHand.cardCount(); i++) {
                System.out.println(playerHand.getCard(i).toString() + "\t");
            }
            System.out.println("You currently have: " + playerHand.getHandValue());
            System.out.println("Dealer showing: " + dealerHand.getCard(0));
            
            System.out.println("Enter in an 'H' for HIT or 'S' for STAND");
            playerInput = scanner2.nextLine();
            
            if (String.valueOf(playerInput).equals("S")) {
                break;
            } else if (String.valueOf(playerInput).equals("H")) {
                playerHand.addCard(deck.dealCard());
                System.out.println("-----NEW HAND-----");
                for (int i = 0; i < playerHand.cardCount(); i++) {
                    System.out.println(playerHand.getCard(i).toString() + "\t");
                }
                System.out.println("You currently have: " + playerHand.getHandValue());
                if (playerHand.getHandValue() > 21) {
                    System.out.println("***BUST***");
                    System.out.println("DEALER WINS");
                    newGame();
                } 
            }
        }
        
        if (gameOver == true) {
            newGame();
        } else {
            System.out.println("Dealer's Current hand");
            for (int i = 0; i < dealerHand.cardCount(); i++) {
                System.out.println(dealerHand.getCard(i).toString() + "\t");
            }
            while(dealerHand.getHandValue() < 17) {
                System.out.println("-----Dealer's New Hand-----");
                dealerHand.addCard(deck.dealCard());
                for (int i = 0; i < dealerHand.cardCount(); i++) {
                    System.out.println(dealerHand.getCard(i).toString() + "\t");
                }
                if(dealerHand.getHandValue() > 21) {
                    System.out.println("***DEALER BUST***");
                    System.out.println("PLAYER WINS");
                    newGame();
                }
            }
            
            System.out.println("Dealer hand value is: " + dealerHand.getHandValue());
            System.out.println("Player hand value is: " + playerHand.getHandValue());
            
            if (dealerHand.getHandValue() > playerHand.getHandValue()) {
                System.out.println("***Dealer wins!***");
                newGame();
            } else if (dealerHand.getHandValue() < playerHand.getHandValue()) {
                System.out.println("***Player wins!***");
                newGame();
            } else {
                System.out.println("***TIE***");
                newGame();
            }
        }
    }
    
    public void newGame() {
        
        String playerOption = printSetUp();

        switch (playerOption) {
            case "1":
                playBlackJack();
                break;
            case "2":
                System.out.println("Good bye!");
                System.exit(0);
            default:
                break;
        }
    }

    public static void main(String[] args) {

        new BlackJack();
    }

}
