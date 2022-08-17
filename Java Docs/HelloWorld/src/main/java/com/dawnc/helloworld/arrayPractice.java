/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.helloworld;

/**
 *
 * @author pisce
 */
public class arrayPractice {
    public static void main(String[] args) {
        
    
    int[] numbers = {1, 2, 3, 4, 5, 6};

    for (int i = 0; i < numbers.length - 2; i += 3) {
        System.out.println("Pair: (" + numbers[i] + ", " + numbers[i + 1] + ")");
    }
    }
}
