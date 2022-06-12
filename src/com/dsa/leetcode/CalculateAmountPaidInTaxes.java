package com.dsa.leetcode;

import java.util.Scanner;

public class CalculateAmountPaidInTaxes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] brackets = {{3, 50}, {7, 10}, {12, 25}};
//                new int[n][2];
//        for (int i = 0 ; i < brackets.length; i++){
//            for (int j = 0 ; j< 2; j++){
//                brackets[i][j] = scn.nextInt();
//            }
//        }
        int income = 10; //scn.nextInt();
        double res = calculateTax(brackets, income);
        System.out.println(res);

    }

    public static double calculateTax(int[][] brackets, int income) {
        if (income == 0) return 0.0;
        double tax = 0.0;
        int prev =0;
        for(int[] bracket : brackets){
            int upper = bracket[0] ;
            int percent = bracket[1];
            if(income >= upper){
                tax += (upper-prev) * percent /100d;
                prev = upper;
            }else{
                tax += (income - prev) * percent /100d;
                return tax;
            }
        }

        return tax;
    }
}
