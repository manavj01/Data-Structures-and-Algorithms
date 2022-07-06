package com.dsa.slidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumSumSubArrayOfSizeK {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int K = scn.nextInt();
        ArrayList<Integer> Arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Arr.add(scn.nextInt());
        }
        System.out.println(maximumSumSubArray(K, Arr, N));
    }

    public static long maximumSumSubArray(int K, ArrayList<Integer> Arr, int N) {
        long max = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            long sum = 0;
            for (int j = i; j <= i + K - 1; j++) {
                sum = sum + Arr.get(j);
                if (j - i + 1 == K) {
                    if (sum > max) max = sum;
                }
            }
        }
        return max;
    }

    public static long maximumSumSubArray1(int K, ArrayList<Integer> Arr, int N) {

        int i = 0, j = 0;
        long sum = 0, maxi = Long.MIN_VALUE;
        while (j < N) {
            sum += Arr.get(j);
            if (j - i == K - 1) {
                maxi = Math.max(sum, maxi);
                j++;
                sum -= Arr.get(i);
                i++;
            } else {
                j++;
            }
        }
        return maxi;
    }
}