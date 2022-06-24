package com.dsa.functionsAndArrays;

import java.util.Scanner;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // approach 1

        // int n1 = scn.nextInt();
        // int[] arr1 = new int[n1];
        // for (int i = 0; i < arr1.length; i++) {
        // arr1[i] = scn.nextInt();
        // }
        // System.out.println("----------------");

        // int n2 = scn.nextInt();
        // int[] arr2 = new int[n2];

        // for (int i = 0; i < arr2.length; i++) {
        // arr2[i] = scn.nextInt();
        // }
        // System.out.println("----------------");
        // scn.close();

        // int[] sumArr = new int[n1];

        // for (int j = 0; j < arr1.length; j++) {
        // sumArr[j] = arr1[j] + arr2[j];
        // System.out.print(sumArr[j] + ", ");
        // }

        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scn.nextInt();
        }
        System.out.println("----------------");

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scn.nextInt();
        }
        System.out.println("----------------");
        scn.close();

        int[] sum = new int[n1 > n2 ? n1 : n2];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sum.length - 1;

        int carry = 0;
        while (k >= 0) {
            int d = carry;

            if (i >= 0) {
                d = d + arr1[i];
            }

            if (j >= 0) {
                d = d + arr2[j];
            }

            carry = d / 10;
            d = d % 10;
            sum[k] = d;
            i--;
            j--;
            k--;

        }

        if (carry != 0) {
            System.out.println(carry);
        }

        for (int val : sum) {
            System.out.println(val);
        }
    }
}
