/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.practiceprogramming.variables;

/**
 *
 * @author pisce
 */
public class MenuOfChampions {
    public static void main(String[] args) {
        System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>\n" );
       
        System.out.println("          "+"Yummy Yummy Cafe");
        System.out.println("          "+"Today's Special\n");
        
        System.out.println("<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>:<:>\n" );
        
        //variables
        String specialOne;
        String specialTwo;
        String specialThree;
        
        specialOne = "  Ramen with miso soup";
        specialTwo = "  Char sui ramen";
        specialThree = "  Vegetarian broth with ramen";
             
        double priceOne;
        double priceTwo;
        double priceThree;
        
        priceOne = 13.99;
        priceTwo = 15.99;
        priceThree = 10.99;
        
        //display to console
        System.out.println("          "+"$" + priceOne + specialOne);
        System.out.println("          "+"$" + priceTwo + specialTwo);
        System.out.println("          "+"$" + priceThree + specialThree);
        
/* Just some thoughts about the centering in this activity
   -I could probably just put spaces into a variable and reuse
    it over and over
   -is there a special function that allows the program to 
    center items?
   -judging from the asterisks used between price and food item,
    I think spaces need to be printed out
*/        
    }
  }
