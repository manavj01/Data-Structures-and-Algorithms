package com.dsa.compititiveProgramming.atCoder;

import java.util.Scanner;

public class LastTwoDigsOfN {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int rem = n % 100;
        String str = Integer.toString(rem);
        if (str.length() == 1) {
            System.out.println("0" + str);
        } else {
            System.out.println(str);
        }
//        System.out.println(rem);
    }
}
