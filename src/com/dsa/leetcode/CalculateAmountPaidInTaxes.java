package com.dsa.leetcode;

import java.util.Scanner;

public class CalculateAmountPaidInTaxes {
    public static void main(String[] args) {
        int[][] brackets = {{3, 50}, {7, 10}, {12, 25}};
        int income = 10;
        System.out.println(calculateTax(brackets, income));

    }

    public static double calculateTax(int[][] brackets, int income) {
        if (income == 0) return 0.0;
        double tax = 0.0;
        int prev = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];
            if (income >= upper) {
                tax += (upper - prev) * percent / 100d;
                prev = upper;
            } else {
                tax += (income - prev) * percent / 100d;
                return tax;
                
            }
        }

        return tax;
    }
}
