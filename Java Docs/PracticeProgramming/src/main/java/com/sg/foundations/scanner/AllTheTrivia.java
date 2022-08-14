/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author pisce
 */
public class AllTheTrivia {
    public static void main(String[] args) {
        
        Scanner quizMe = new Scanner(System.in);
        
        //variables 
        String questionOne;
        String questionTwo;
        String questionThree;
        String questionFour;
        
        System.out.println("What type of tree is the largest?"); 
        questionOne = quizMe.nextLine();
        
        System.out.println("What is the chemical name for water?");
        questionTwo = quizMe.nextLine();
        
        System.out.println("How bones does an adult have?");
        questionThree = quizMe.nextLine();
        
        System.out.println("Which continent is it's own country?");
        questionFour = quizMe.nextLine();
        
        System.out.println("Geez," + questionThree + " meters is the height of the tallest tree!");
        System.out.println("It is pretty cool that " + questionFour + " must have a lot of water");
        System.out.println("Intereting, I did not know " + questionOne + " is also continent. That is pretty cool!");
        System.out.println("I guess " + questionTwo + " must make our bones strong!");
        
        
                        
    }
        
}
