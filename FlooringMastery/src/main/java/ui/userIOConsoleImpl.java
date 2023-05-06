/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author pisce
 */
public class userIOConsoleImpl implements userIO  {

    Scanner sc = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int userInt;
        do {
            System.out.println(prompt + " Between " + min + " And " + max);
            userInt = Integer.parseInt(sc.nextLine());
        } while (userInt < min || userInt > max);

        return userInt;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(sc.nextLine());
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double userDouble;
        do{
            System.out.println(prompt + " Between " + min + " And " + max);
            userDouble = Double.parseDouble(sc.nextLine());
        } while (userDouble < min || userDouble > max);
        
        return userDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.parseFloat(sc.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float userFloat;
        do{
            System.out.println(prompt + " Between " + min + " And " + max);
            userFloat = Float.parseFloat(sc.nextLine());
        } while (userFloat < min || userFloat > max);
        
        return userFloat;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return Long.parseLong(sc.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long userLong;
        do{
            System.out.println(prompt + " Between " + min + " And " + max);
            userLong = Long.parseLong(sc.nextLine());
        } while (userLong < min || userLong > max);
        
        return userLong;
    }
    
   @Override
    public BigDecimal printBigDecimal(BigDecimal message) {
        System.out.println(message);
        return sc.nextBigDecimal(); 
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        BigDecimal bd = new BigDecimal(sc.nextLine());
        return bd.setScale(2, RoundingMode.HALF_UP);
    }
}

