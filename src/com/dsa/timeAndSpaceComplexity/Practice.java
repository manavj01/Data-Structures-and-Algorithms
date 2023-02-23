package com.dsa.timeAndSpaceComplexity;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int num = arr[n - 1]; // 7

        for (int i = 0; i < n - 1; i++) {
            if (num == arr[i]) {
                System.out.println("True");
                break;
            }
            if (i == n - 2) {
                System.out.println("False");
            }

        }


    }
    // take n inputs from user . and check if nth input is present in n-1 or not.
    // [2, 4 , 5, 1 ,7]
}
