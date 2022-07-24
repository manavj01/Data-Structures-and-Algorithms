package com.dsa.leetcode;

public class NumberOfZeroFIlledSubarrays {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, 0, 0, 2, 0, 0, 4};
        int[] arr = new int[]{0, 0, 0, 2, 0, 0};
//        int[] arr = new int[]{2,10,2019};
        System.out.println(zeroFilledSubarray(arr));
    }

    public static long zeroFilledSubarray(int[] arr) {

        long pc = 0;
        long zc = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                pc++;
            } else if (arr[i] != 0) {
                if (pc > 0) {
                    pc = pc * (pc + 1) / 2;
                    zc += pc;
                    pc = 0;
                }
            }
        }

        if (pc > 0) {
            pc = pc * (pc + 1) / 2;
            zc += pc;

        }
        return zc;
    }
}
