package com.dsa.recursion;

import java.util.Scanner;

public class Factorial {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = n;
        int fnm1 = factorial(n - 1);
        fact = fact * fnm1;
        return fact;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        System.out.println(factorial(n));

    }
}
