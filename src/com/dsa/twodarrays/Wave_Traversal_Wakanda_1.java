package com.dsa.twodarrays;

import java.util.Scanner;

public class Wave_Traversal_Wakanda_1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        System.out.println("----------");
        for (int j = 0; j < arr[0].length; j++) {

            if (j % 2 == 0) {
                for (int[] ints : arr) {
                    System.out.println(ints[j]);
                }
            } else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.println(arr[i][j]);
                }
            }

        }
    }
}
