package com.dsa.striver30daysSheet.d4_Arrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountNumberOfSubarraysHavingAGivenXor {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 2, 2, 6, 4};
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(arr));
        System.out.println(solve(al, 6));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int c = 0;
        int xorr = 0;
        int n = A.size();
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ A.get(i);

            if (freq.get(xorr ^ B) != null) {
                c += freq.get(xorr ^ B);
            }
            if (xorr == B) {
                c++;
            }
            if (freq.get(xorr) != null) {
                freq.put(xorr, freq.get(xorr) + 1);
            } else freq.put(xorr, 1);
        }
        return c;
    }

    public static int solve1(ArrayList<Integer> A, int B) {
        int c = 0;
        for (int i = 0; i < A.size(); i++) {
            int curr_xor = 0;
            for (int j = i; j < A.size(); j++) {
                curr_xor ^= A.get(j);
                if (curr_xor == B) {
                    c++;
                }
            }
        }
        return c;
    }
}
