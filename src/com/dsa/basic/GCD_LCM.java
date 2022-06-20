package com.dsa.basic;

import java.util.Scanner;

public class GCD_LCM {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        scn.close();

        int O_num1 = num1;
        int O_num2 = num2;
        while (num1 % num2 != 0) {
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;

        }

        int gcd = num2;

        int lcm = (O_num1 * O_num2) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);


    }
}
