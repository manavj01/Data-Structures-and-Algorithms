package com.dsa.functionsandarray;

import java.util.Scanner;

public class BrokenEconomy {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();

        int[] a = new int[n1];

        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }

        int d = scn.nextInt();
        scn.close();

        int floor = 0;
        int ceil = a.length - 1;

        while (floor <= ceil) {
            int mid = (floor + ceil) / 2;

            if (a[mid] > d) {
                ceil = mid - 1;
            } else if (a[mid] < d) {
                floor = mid + 1;
            } else {
                System.out.println(a[mid]);
                return;
            }
        }
        System.out.println(floor);
        System.out.println(ceil);
    }
}
