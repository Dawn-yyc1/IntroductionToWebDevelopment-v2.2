package com.sg.foundations.flowcontrol.fors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pisce
 */
public class ForAndTwentyBlackbirds {
    public static void main(String[] args) {
        int birdsInPie =0;
        for(int i =1; i<=24; i++){
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }
        
        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
    }
    
}

/*
I changed i to start from 1 instead of 0 so that the program will 
start counting from 1.
I also updated the comparison operator to <= so that the program 
will count 24.


*/