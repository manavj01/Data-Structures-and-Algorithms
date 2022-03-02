package com.dsa.twodarrays;

import java.util.Scanner;

public class Roate_90_Degree {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        // approach1
        // System.out.println("-------------");
        // int[][] transpose = new int[n][n];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // transpose[i][j] = arr[j][i];
        // }
        // }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }
        // System.out.println("------------");
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(transpose[i][j] + " ");
        // }
        // System.out.println();
        // }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int li = 0;
            int ri = arr[i].length - 1;

            while (li < ri) {
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;

                li++;
                ri--;

            }
        }
        display(arr);
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
