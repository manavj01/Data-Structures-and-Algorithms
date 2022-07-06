package com.dsa.slidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class FirstNegativeNumberInEveryWindow {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) A[i] = scn.nextInt();

        int K = scn.nextInt();
        System.out.println(Arrays.toString(printFirstNegativeInteger(A, N, K)));
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K) {

        return new long[0];
    }
}
