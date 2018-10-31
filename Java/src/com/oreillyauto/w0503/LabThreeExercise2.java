/*
 * Program:   LabThreeExercise2
 * Developer: Chase Dickerson
 * Date:      10/31/2018
 * Purpose:   Creates a game of rock paper scissors  
 */

package com.oreillyauto.w0503;

import java.util.Scanner;
import java.util.Random;
public class LabThreeExercise2 {

    // Global variables
    static String playerName = "";
    static String playerChoice = "";
    static String keepPlaying = "";
    
    // Main
    public static void main(String[] args) {
        
        // Gets all input
        try(Scanner input = new Scanner(System.in)) {
            System.out.println("Please enter player name: ");
            playerName = input.nextLine();
            while (!keepPlaying.equals("N")) {
                System.out.println("Enter in either Rock, Paper, or Scissors.");
                playerChoice = input.nextLine();
                play();
                System.out.println("Select N to stop playing, select any other button to continue");
                keepPlaying = input.nextLine();
            }
            System.out.println("Done!");
        }   
    }
    
    // Does the bulk of the playing logic
    public static void  play() {
        Random computerGo = new Random();
        int computerChoice = computerGo.nextInt(3) + 1;
        RockPaperScissors computer = checkComputerChoice(computerChoice);
        
        RockPaperScissors player = checkPlayersChoice(playerChoice);
        
        int playerTurn = player.getNumber();
        int computerTurn = computer.getNumber();
        
        findWinner(playerTurn, computerTurn);
    }
    
    // Gets the players choice 
    public static RockPaperScissors checkPlayersChoice(String pc) {
        
        if (pc.equals("Rock") || pc.equals("rock")) {
            RockPaperScissors rock = RockPaperScissors.ROCK;
            System.out.println(playerName + " chose rock");
            return rock;
        } else if (pc.equals("Paper") || pc.equals("paper")) {
            RockPaperScissors paper = RockPaperScissors.PAPER;
            System.out.println(playerName + " chose paper");
            return paper;
        } else if (pc.equals("Scissors") || pc.equals("scissors")) {
            RockPaperScissors scissors = RockPaperScissors.SCISSORS;
            System.out.println(playerName + " chose scissors");
            return scissors;
        } else {
            System.out.println("Invalid input!");
            return null;
        }
    }
    
    // Sees computers choice
    public static RockPaperScissors checkComputerChoice(int i) {
         switch (i) {
             case 1:
                 RockPaperScissors rock = RockPaperScissors.ROCK;
                 System.out.println("Computer chose rock");
                 return rock; 
             case 2:
                 RockPaperScissors paper = RockPaperScissors.PAPER;
                 System.out.println("Computer chose paper");
                 return paper;
             case 3:
                 RockPaperScissors scissors = RockPaperScissors.SCISSORS;
                 System.out.println("Computer chose scissors");
                 return scissors;
             default:
                 return null;
         }
    }
    
    // Determines the winner
    public static void findWinner(int player, int computer) {
       
       if (player == computer) {
           System.out.println("Tie");
       }
       if ((player == 1 && computer == 2) || (player == 2 && computer == 3) || player == 3 && computer == 1) {
           System.out.println("Computer wins!");
       } else {
           System.out.println(playerName + " wins!");
       }
    }
}





