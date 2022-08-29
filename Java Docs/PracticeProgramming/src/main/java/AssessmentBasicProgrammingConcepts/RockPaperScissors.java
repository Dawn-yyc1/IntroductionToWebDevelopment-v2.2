/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssessmentBasicProgrammingConcepts;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pisce
 */
//bo
public class RockPaperScissors {
   public static void main(String[] args) {
        
        //declare and initialize variables
        
        //rounds
        String stringNumRounds; 
        int numRounds;
        
        //players
        String stringUserInput = "";
        int userInput;            
        int comp; 
        
        //score
        int scoreComp =0;
        int scoreUser = 0;
        int scoreTie = 0;
               
        Scanner playGame = new Scanner(System.in);
        Random rGen = new Random();
        
        //Ask user how many games they want to play. Game is in contained in a while true loop
        while(true){
            System.out.println("\nLet's play rock, paper, scissors.");
            System.out.println("How many rounds do you want play (1 to 10 rounds)? ");
                 stringNumRounds = playGame.nextLine();
                 numRounds = Integer.parseInt(stringNumRounds);
        //Game exits if range is incorrect
                 if(numRounds > 10 || numRounds ==0){
                     System.out.println("Invalid range choosen.");
                     break;                    
                 }
             
        //reiterrating through the # rounds user choose          
                for (int i = 1; i <= numRounds; i++) { 
                    System.out.println("\nRound #" + i );
                    System.out.println("1 = Rock");
                    System.out.println("2 = Paper");
                    System.out.println("3 = Scissors\n");
                   
                    stringUserInput = playGame.nextLine();
                    userInput = Integer.parseInt(stringUserInput);   

                        //User choice
                        if(userInput == 1){
                            System.out.println("\nYou choose rock.");
                        }
                        if(userInput == 2){
                            System.out.println("\nYou choose paper.");
                        }
                        if(userInput == 3){
                            System.out.println("\nYou choose scissors.");
                        }

                        //random generator for computer choice
                        comp = rGen.nextInt(3)+1;

                        if(comp == 1) {
                            System.out.println("Computer choose rock.");
                        }
                        if(comp == 2) {
                            System.out.println("Computer choose paper.");
                        }
                        if(comp == 3){
                            System.out.println("Computer choose scissors.");
                        }

                        //game outcomes

                        if(comp == 1 && userInput == 2){
                            scoreUser++;
                            System.out.println("You win!" + " Your score: "+ scoreUser + " Computer: " + scoreComp+ " Ties: " + scoreTie);
                        }
                        if(comp == 1 && userInput == 3){
                            scoreComp++;
                            System.out.println("Computer wins!" + " Your score: " + scoreUser + " Computer: " +scoreComp+ " Ties: " + scoreTie);
                        }
                        if(comp == 2 && userInput == 3){
                            scoreUser++;
                            System.out.println("You win!" + " Your score: "+ scoreUser + " Computer: " + scoreComp+ " Ties: " + scoreTie);
                        }
                        if(comp == 3 && userInput == 2){
                            scoreComp++;
                            System.out.println("Computer wins!" + " Your score: " + scoreUser + " Computer: " +scoreComp+ " Ties: " + scoreTie);                          
                        }
                        if(comp == 2 && userInput == 1){
                            scoreComp++;
                            System.out.println("Computer wins!" + " Your score: " + scoreUser + " Computer: " +scoreComp+ " Ties: " + scoreTie);
                           }
                        if(comp == 3 && userInput == 1){
                            scoreUser++;
                            System.out.println("You win!" + " Your score: "+ scoreUser + " Computer: " + scoreComp+ " Ties: " + scoreTie);
                        }
                        if(comp == 1 && userInput == 1){
                            scoreTie++;
                            System.out.println("Tie!!" + " Your score: " + scoreUser + " Computer: " + scoreComp + " Ties: " + scoreTie);
                        }
                        if(comp == 2 && userInput == 2){
                            scoreTie++;
                            System.out.println("Tie!!" + " Your score: " + scoreUser + " Computer: " + scoreComp + " Ties: " + scoreTie);
                        }    
                        if(comp == 3 && userInput == 3){
                            scoreTie++;
                            System.out.println("Tie!!" + " Your score: " + scoreUser + " Computer: " + scoreComp + " Ties: " + scoreTie);    
                        }    


                } //For loop ends. Display winner/loser
                System.out.println("************************************************");
                if (scoreComp  > scoreUser){
                    System.out.println("\nComputer wins: " + scoreComp + " Your score: " + scoreUser);           
                }  
                    else if(scoreComp < scoreUser){
                        System.out.println("\nCongratulations you win: " +scoreUser + " Computer score: " + scoreComp );
                    }
                    scoreComp = 0;
                    scoreUser = 0;
                    scoreTie = 0;
                
            //Ask user if they want to play again or exit game        
            System.out.println("\n************************************************");    
            System.out.println("Do you want to play again (y/n)?");               
            stringUserInput = playGame.nextLine();
            if(stringUserInput.equals("n")){ 
                System.out.println("\nThanks for playing!");
                 break;
                }
            else if(stringUserInput.equals("y"));
                
        }
              
}
    
       
   }