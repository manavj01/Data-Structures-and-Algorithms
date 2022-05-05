package com.dsa.timeAndSpaceComplexity;

import java.util.Arrays;
import java.util.Scanner;

public class TargetSumPair {
    public static void targetSumPair(int[] arr, int target) {
        Arrays.sort(arr);

        int li = 0;
        int ri = arr.length - 1;

        while (li <= ri) {
            if (arr[li] + arr[ri] == target) {
                System.out.println(arr[li] + ", " + arr[ri]);
                li++;
                ri--;
            } else if (arr[li] + arr[ri] > target) {
                ri--;
            } else {
                li++;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr, target);
    }
}
