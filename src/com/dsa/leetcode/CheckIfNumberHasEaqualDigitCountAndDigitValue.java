package com.dsa.leetcode;

import java.util.Scanner;

public class CheckIfNumberHasEaqualDigitCountAndDigitValue {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.nextLine();
        boolean soln = digitCount(num);
        System.out.println(soln);
    }

    public static boolean digitCount(String num) {
        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            int dig = ch - '0';
            arr[i] = dig;
        }
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            int counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    counter++;
                }
            }
            if (counter != val) {
                return false;
            }
        }

        return true;
    }
}
