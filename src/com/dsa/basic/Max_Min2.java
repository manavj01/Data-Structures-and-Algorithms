package com.dsa.basic;

import java.util.Scanner;

public class Max_Min2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int[] A = new int[n];
        for (int i = 0; i < A.length; i++) {
            int arrVal = scn.nextInt();
            A[i] = arrVal;
        }
        System.out.println();
        for (int i = 0; i < A.length; i++) {

            System.out.print(A[i] + " ");
        }
        int temp;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        // return A[n-2];
        System.out.println();

    }
}
