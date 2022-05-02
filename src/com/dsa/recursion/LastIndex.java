package com.dsa.recursion;

import java.io.*;
import java.util.*;

public class LastIndex {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();

        int uu = lastIndex(arr, n - 1, x);
        System.out.println(uu);


    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx < 0) return -1;

        if (arr[idx] == x) {
            return idx;
        } else {
            int liisa = lastIndex(arr, idx - 1, x);
            return liisa;
        }

    }
}
