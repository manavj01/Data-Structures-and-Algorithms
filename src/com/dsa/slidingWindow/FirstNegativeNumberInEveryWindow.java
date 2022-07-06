package com.dsa.slidingWindow;

import java.util.*;

public class FirstNegativeNumberInEveryWindow {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) A[i] = scn.nextInt();

        int K = scn.nextInt();
        System.out.println(Arrays.toString(printFirstNegativeInteger(A, N, K)));
    }

    public static long[] printFirstNegativeInteger(long[] A, int N, int K) {
        int i = 0;
        int j = 0;
        int z = 0;
        ArrayList<Integer> list = new ArrayList<>();
        long[] res = new long[N - K + 1];

        while (j < N) {
            if (A[j] < 0) {
                list.add(j);
            }

            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                if (list.size() == 0) {
                    res[z++] = 0;
                } else if (list.size() > 0) {
                    res[z++] = A[list.get(0)];
                }
                i++;
                j++;
                if (list.size() > 0 && list.get(0) < i) {
                    list.remove(list.get(0));
                }
            }
        }

        return res;
    }
}

// input
//5
//-8 2 3 -6 10
//2

//8
//12 -1 -7 8 -15 30 16 28
//3
