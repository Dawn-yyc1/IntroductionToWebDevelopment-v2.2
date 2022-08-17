/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

/**
 *
 * @author pisce
 */
public class ForTimes {
    public static void main(String[] args) {
        
        Scanner timesTable = new Scanner(System.in);
        
        int userInput;
                
        String stringUserInput = "";
        
                            
        System.out.println("Which times table shall I recite? Choose a number between 1 to 9.");
        stringUserInput = timesTable.nextLine();
        System.out.println();
        
        userInput = Integer.parseInt(stringUserInput);
        
        for (int i = 1; i <= 15; i++) {
          
          System.out.println(i + " * " + userInput + " is: " + (i * userInput));
            }
           
            
        }
      
    }
    
    
/*
Couldn't make it print out the question. Nevermind, I figured it out!

*/