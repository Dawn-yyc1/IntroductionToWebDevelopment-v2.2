/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pisce
 */
public class GuessMeMore {
    public static void main(String[] args) {
        
               
        Scanner userInput = new Scanner(System.in);
        
        Random rng = new Random();
        
        int myNumber1 = rng.nextInt(201) -100;
        int myNumber2 = rng.nextInt(201) -100;
        int guess1;
        int guess2;
            
        String stringGuess1 = "";
        String stringGuess2 = "";
        String stringMyNumber1;
        String stringMyNumber2;
        
        System.out.println("I've choosen a number between -100 to 100. Betcha can't guess it!");
        System.out.println("Guess a number between -100-100: ");
                
        stringGuess1 = userInput.nextLine();
        
        
        guess1 = Integer.parseInt(stringGuess1);
        guess2 = Integer.parseInt(stringGuess1);
        
        if(guess1 > myNumber1) {
            System.out.println("Your guess of " + guess1 + " is too high! My number is " + myNumber1 +"!" );
        }
        if(guess1 < myNumber1) {
            System.out.println("Nice try, your guess of " + guess1 + " is too low! My number is " + myNumber1 + "!");
        }
        System.out.println("Guess again: ");
            stringGuess2 = userInput.nextLine();
            
        if(guess2 > myNumber2) {
            System.out.println("Your guess of " + guess2 + " is too high! My number is " + myNumber2 +"!" );
        }
        if(guess2 < myNumber2) {
            System.out.println("Nice try, your guess of " + guess2 + " is too low! My number is " + myNumber2 + "!");
        }
       }
    }
          
/* 
Aiya order is important. I forgot to put the stringGuess2 = userInput.nextLine(); 
in the correct spot and my program did something funny because I put 
these lines together: 
    stringGuess = userInput.nextLine();
    stringGuess2 = userInput.nextLine();

The program asked for my guess twice and then gave me the both guesses.
I moved the 2nd line underneath the 2nd guess prompt and it worked!

I did have trouble finding the correct formula for the range since 
-100 to 100....the difference is zero, which makes the method in 
the notes invalid. I did have to Google it and I found the solution
on Stack.

I thought about using a loop instead of writing if statements but I 
figure that it is part this exercise. 


*/

