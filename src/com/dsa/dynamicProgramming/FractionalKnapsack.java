package com.dsa.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = scn.nextInt();
        }

        int[] wts = new int[n];
        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }
        float[] valbywts = new float[n];
        for (int i = 0 ; i < n; i++){
            valbywts[i] = (float) vals[i]/wts[i];
        }
        Arrays.sort(valbywts);
        System.out.println(Arrays.toString(valbywts));
    }
}
//10 33 14 50 9 8 11 6 40 2 15 7 2 5 9 3 2 1 10 3 3
