package com.dsa.importantQuestions;

import java.util.Scanner;

public class MaximumSumNonAdjacentElements {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        long inc = arr[0];
        long exc = 0;

        for (int i = 1; i < arr.length; i++) {
            long ninc = exc + arr[i];
            long nexc = Math.max(inc, exc);

            inc = ninc;
            exc = nexc;
        }
        System.out.println(Math.max(inc, exc));
    }
}
