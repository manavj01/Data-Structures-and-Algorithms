package com.dsa.patterns;

import java.util.Scanner;

public class Pattern14 {
    //pattern 14 - print a table for num n
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        scn.close();
        // write ur code here
        int n = scn.nextInt();
        for (int i = 1; i <= 10; i++) {

            int mult = n * i;
            System.out.print(n + " * " + i + " = " + mult);

            System.out.println();
        }
    }
}
