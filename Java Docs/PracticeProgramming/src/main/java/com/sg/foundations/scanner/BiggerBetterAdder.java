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
public class BiggerBetterAdder {
    public static void main(String[] args) {
        
         //variables
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int sum = 0;
        
        Scanner userInput = new Scanner (System.in);
        
        String stringNum1 = "";
        String stringNum2 = "";
        String stringNum3 = "";
                                    
        System.out.println("Choose a first number: ");
        stringNum1 = userInput.nextLine();
        
        System.out.println("Choose a second number: ");
        stringNum2 = userInput.nextLine();
        
        System.out.println("Choose a third number: ");
        stringNum3 = userInput.nextLine();
        
        num1 = Integer.parseInt(stringNum1);
        num2 = Integer.parseInt(stringNum2);
        num3 = Integer.parseInt(stringNum3);
        sum = num1 + num2 + num3;
        
        /* 
        Order of variables and assignment of variables is important!
        I thought that order did not matter at first and I randomly 
        wrote my variables -- the program built the program correctly 
        but it would not execute. So I went back to my Adder Version 2
        (in the Collecting console input - scanner chapter)
        the notes to check my code and the difference was the order.
        */
        
        System.out.print(stringNum1 + " + " + stringNum2 +" + " + stringNum3 + " = ");
        System.out.print(sum);
        
               
    }
    
}
