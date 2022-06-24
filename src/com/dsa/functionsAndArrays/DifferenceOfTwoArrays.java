package com.dsa.functionsAndArrays;

import java.util.Scanner;

public class DifferenceOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

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

        int[] diff = new int[n2];
        int carry = 0;

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diff.length - 1;

        while (k >= 0) {
            int d = 0;
            int a1val = i >= 0 ? arr1[i] : 0;
            if (arr2[j] + carry >= a1val) {
                d = arr2[j] + carry - a1val;
                carry = 0;
            } else {
                d = arr2[j] + carry + 10 - a1val;
                carry = -1;
            }
            diff[k] = d;

            i--;
            j--;
            k--;
        }

        int idx = 0;

        while (idx < diff.length) {
            if (diff[idx] == 0) {
                idx++;
            } else {
                break;
            }
        }
        while (idx < diff.length) {
            System.out.println(diff[idx]);
            idx++;
        }

    }
}
