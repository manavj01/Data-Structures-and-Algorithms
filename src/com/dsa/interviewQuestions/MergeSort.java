package com.dsa.interviewQuestions;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 31, 25, 8, 32, 17, 40, 42};
        int[] ans = mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        int mid = (lo + hi) / 2;
        int[] fsh = mergeSort(arr, lo, mid);
        int[] ssh = mergeSort(arr, mid + 1, hi);

        return mergeTwoSortedArrays(fsh, ssh);
    }

    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[idx++] = a[i++];
            } else res[idx++] = b[j++];
        }
        while (i < a.length) {
            res[idx++] = a[i++];
        }
        while (j < b.length) {
            res[idx++] = b[j++];
        }
        return res;
    }
}
