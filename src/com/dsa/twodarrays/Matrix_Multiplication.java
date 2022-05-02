package com.dsa.twodarrays;

import java.util.Scanner;

public class Matrix_Multiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter size of array1");
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        System.out.println("Enter size of array1");

        int n2 = scn.nextInt();
        int m2 = scn.nextInt();
        System.out.println("-----------------");
        int[][] arr1 = new int[n1][m1];
        int[][] arr2 = new int[n2][m2];
        System.out.println("Enter elements of arr1");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                arr1[i][j] = scn.nextInt();
            }
        }
        System.out.println("Enter elements of arr2");

        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                arr2[i][j] = scn.nextInt();
            }
        }
        System.out.println("-------------------");
        scn.close();
        if (m1 != n2) {
            System.out.println("Invalid input");
            return;
        }
        int[][] prdt = new int[n1][m2];

        for (int i = 0; i < prdt.length; i++) {
            for (int j = 0; j < prdt[0].length; j++) {
                for (int k = 0; k < m1; k++) {
                    prdt[i][j] = prdt[i][j] + arr1[i][k] * arr2[k][j];
                }
            }
        }

        for (int i = 0; i < prdt.length; i++) {
            for (int j = 0; j < prdt[0].length; j++) {
                System.out.print(prdt[i][j] + " ");
            }
            System.out.println();
        }
    }
}
