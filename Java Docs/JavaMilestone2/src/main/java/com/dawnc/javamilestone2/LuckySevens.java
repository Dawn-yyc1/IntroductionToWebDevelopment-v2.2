///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.dawnc.javamilestone2;
//
//import java.util.Random;
//import java.util.Scanner;
//
///**
// *
// * @author pisce
// */
//public class LuckySevens {
//    public static void main(String[] args) {
//        
//        //variables
//        int moneyUser;
//        int moneyWon= 0;
//        int moneyLose = 0;
//        String stringMoneyUser = "";
//        
//        
//        int maxRolls;
//        int minRolls;
//        
//        Scanner dc = new Scanner (System.in);
//        
//        //random number generator for dice to generate a number between 1-6
//        Random gen = new Random(); 
//        int dice1 = gen.nextInt(6) +1;
//        int dice2 = gen.nextInt(6) +1;
//        
//        stringMoneyUser = dc.nextLine();
//        
//        
//        System.out.println("How many dollars do you have?");
//        System.out.println("You are broke after" + maxRolls + " rolls." );
//        System.out.println("You should have quit after" + minRolls+ " rolls when you had " + moneyUser +".");
//        
//        for (int i = 1; i <= moneyUser; i++) {
//            
//               
//                if ((dice1 + dice2) == 7) {
//                    moneyWon+=4; 
//                    maxRolls++;
//                }
//                    else {
//                    moneyLose-=1;
//                    minRolls++;
//                            }
//                }
//            }
//  
//            
//        
//        }
//        
//        
//    