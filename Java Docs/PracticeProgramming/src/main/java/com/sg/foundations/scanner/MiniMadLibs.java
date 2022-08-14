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
public class MiniMadLibs {
    public static void main(String[] args) {
        
        //variables
        String noun1;
        String adjective1;
        String noun2;
        String number;
        String adjective2;
        String pluralNoun1;
        String pluralNoun2;
        String pluralNoun3;
        String verbPresent1;
        String verbPresent2;
        
        //declare variable
        Scanner madLib = new Scanner(System.in);
        
        
        
        //get input
        System.out.println("Let's play Mad Libs!");
        
        System.out.println("Give me a noun: ");
        noun1 = madLib.nextLine();
        
        System.out.println("Now an adjective: ");
        adjective1 = madLib.nextLine();
        
        System.out.println("Another noun: ");
        noun2 = madLib.nextLine();
        
        System.out.println("And a number: ");
        number = madLib.nextLine();
        
        System.out.println("Another Adjective: ");
        adjective2 = madLib.nextLine();
        
        System.out.println("A plural noun: ");
        pluralNoun1 = madLib.nextLine();
        
        System.out.println("Another plural noun: ");
        pluralNoun2 = madLib.nextLine();
        
        System.out.println("Last plural noun: ");
        pluralNoun3 = madLib.nextLine();
        
        System.out.println("A verb: ");
        verbPresent1 = madLib.nextLine();
        
        System.out.println("Same verb, past tense: ");
        verbPresent2 = madLib.nextLine();
       
        //display results
        System.out.println("*** NOW LETS GET MAD (libs) ***");
        
        System.out.println(noun1 +": the " + adjective1 + " frontier. These are the voyages of the starship " + noun2 + ".");
        System.out.print("Its " + number + " year mission: to explore strange " + adjective2 + " " + pluralNoun1 + ", ");
        System.out.print("to seek out " + adjective2 + " " + pluralNoun2);
        System.out.print(" and " + adjective2 + " " + pluralNoun3+ ", to boldly " + verbPresent1);
        System.out.print(" where no one has " + verbPresent2 + ".");
       
    
        
        
        
        
        
        
        
    }
}
