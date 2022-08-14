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
public class HealthyHearts {
    public static void main(String[] args) {
        
        //variables
        int userAge;
        int maxHeartRate;
        int targetHeartRate_50;
        int targetHeartRate_85;
        
        Scanner userInput = new Scanner(System.in);
        
        //declare variables
        String stringUserAge = "";
        String stringMaxHeartRate = "";
        String stringTargetHeartRate = "";
        
        //get input from user
        System.out.println("What is your age?");
        stringUserAge = userInput.nextLine();
        
        //convert strings into numbers
        userAge = Integer.parseInt(stringUserAge);
        
        //calculations
        maxHeartRate = 220 - userAge;
        targetHeartRate_50 = (int) (maxHeartRate * 0.5);
        targetHeartRate_85 = (int) (maxHeartRate * 0.85);
        
        //display results
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR zone is " + targetHeartRate_50 + " - " + targetHeartRate_85 +" beats per minute.");
        
        
        
    }
}
