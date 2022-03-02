package com.dsa.functionsandarray;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        scn.close();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
        // System.out.println(99454323%10);
    }

    public static int getDigitFrequency(int n, int d) {

        int count = 0;
        while (n > 0) {
            int mydig = n % 10;
            n = n / 10;
            if (mydig == d) {
                count++;
            }
        }

        return count;

    }
}
