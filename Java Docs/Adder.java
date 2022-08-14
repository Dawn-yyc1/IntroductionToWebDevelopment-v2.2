/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dawnc.adder;

/**
 *
 * @author pisce
 */
public class Adder {
    public static void main(String[] args){
    int sum = 0;
    int operand1 = 0;
    int operand2 = 0;

Scanner myScanner = new Scanner (System.in);

String stringOperand1 = "";
String stringOperand2 = "";
System.out.println("Please inter the first number to be added: ");
stringOperand1 = myScanner.nextLine();
System.out.println("Please enter the second number to be added: ");

sum = operand1 + operand2;

System.out.println("Sum is: " + sum);
}
}
