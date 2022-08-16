/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

/**
 *
 * @author pisce
 */
public class GuessMe {
    public static void main(String[] args) {
        
        int myNumber = 2;
        int guess1;
        
        Scanner userInput = new Scanner(System.in);
            
        String stringGuess1 = "";
        String stringMyNumber;
        
        
        System.out.println("I've choosen a number between 1- 10. Betcha can't guess it!");
        System.out.println("Guess a number between 1-10: ");
        stringGuess1 = userInput.nextLine();
        
        guess1 = Integer.parseInt(stringGuess1);
        
        if(guess1 > myNumber) {
            System.out.println("Your guess of " + guess1 + " is too high! My number is " + myNumber +"!" );
        }
        if(guess1 < myNumber) {
            System.out.println("Nice try, your guess of " + guess1 + " is too low! My number is " + myNumber + "!");
        }
        
        if(guess1 == myNumber) {
            System.out.println("Wow, you're a psychic! That was my number!");
        }
    }
          
}
/*
I found this exercise quite challenging because I wasn't sure if I needed 
Scanner since I could write if() without using Scanner like in the Llamas 
exercise. Then I also had to convert the userInput from a string into a number 
so that it can be evaluated. 
Also, I was confused if myNumber needed to be converted into a number as well.
But I learned that numbers that are declared are interpreted as numbers 
therefore I did not have to parse it. 

Happy to say that my program works!! Yay!!!

*/