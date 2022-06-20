package com.dsa.utility;

import java.util.Scanner;

public class Util {
    public static int[][] getInputInTwoDArr(Scanner scn) {
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        return arr;
    }

    public static void printTwoDArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(ints[j]);
            }
        }
    }

    public static void printOneDArr(int[] arr) {
        for (int ints : arr) {
            System.out.println(ints);
        }
    }
}
