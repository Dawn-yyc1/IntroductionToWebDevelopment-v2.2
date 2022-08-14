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
public class PassingTheTuringTest {
    public static void main(String[] args) {
        
        Scanner inputUser = new Scanner(System.in);
        
        String userName;
        String userFavColor;
        String userFavFruit;
        String userFavNum;
        
        System.out.println("Hello there!");
        System.out.println("What's your name?");
        userName = inputUser.nextLine();
        
        System.out.println("Hi, " + userName + "!");
        System.out.print("I'm Buzz. ");
        
        System.out.println("What's your favorite color?");
        userFavColor = inputUser.nextLine();
        System.out.println(userFavColor +", eh? ");
        System.out.print("Mine's plum, like the color of a mangosteen. ");
        
        System.out.println("Mangosteen also happens to be my favorite fruit too!");
        System.out.println("What's your favorite fruit " + userName +"?");
        userFavFruit = inputUser.nextLine();
        
        System.out.println("Yum! I like " + userFavFruit+ " too! They are delicious!");
        System.out.println("Speaking of favorites, what's your favorite number?");
        userFavNum = inputUser.nextLine();
        System.out.println(userFavNum + " is a cool number.");
        
        System.out.println("Mine is 8. It brings me good luck.");
        
        
        System.out.println("Nice chatting with you, " + userName + "." + " Ttyl.");
        
        
        
    }
        
}
