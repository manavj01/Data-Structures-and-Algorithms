package com.dsa.compititiveProgramming.codechef;

import java.util.Scanner;

public class Joining {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int[] base;
            if (arr[i][0] % 5 == 0) {
                base = new int[arr[i][0] / 5];

                for (int j = 0; j < (arr[i][0] / 5); j++) {
                    base[j] = (j + 1) * 5;
                }

                joining(base, arr, i);


            } else {
                if (arr[i][0] <= 5) {
                    System.out.println(0);
                    continue;
                }
                base = new int[(arr[i][0] / 5) + 1];

                for (int j = 0; j < ((arr[i][0] / 5) + 1); j++) {
                    base[j] = (j + 1) * 5;
                }
                base[base.length - 1] = arr[i][0];

                joining(base, arr, i);
            }
        }
    }

    public static void joining(int[] base, int[][] arr, int i) {
        int c = base.length - 1;
        for (int k = 0; k < base.length; k++) {
            if (arr[i][1] <= base[k]) {
                System.out.println(c);
                break;
            } else {
                c--;
            }
        }
    }
}
