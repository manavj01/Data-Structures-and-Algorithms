package com.dsa.compititiveProgramming.codechef;

import java.util.Scanner;

public class AgeLimit {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][3];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int a = 0;
            int x = 0;
            int y = 0;
            for (int j = 2; j >= 0; j--) {
                a = arr[i][2];
                y = arr[i][1];
                x = arr[i][0];
            }
            if (a >= x && a < y) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
