package com.dsa.recursion;

import java.util.Scanner;

public class PrintIncreasing {

    public static void printInc(int n) {
        if (n == 0) {
            return;
        }

        printInc(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        printInc(n);
    }

}
