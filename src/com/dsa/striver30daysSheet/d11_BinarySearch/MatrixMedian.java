package com.dsa.striver30daysSheet.d11_BinarySearch;

import java.util.ArrayList;
import java.util.Collections;


public class MatrixMedian {
    public static void main(String[] args) {
        Integer[][] arr = new Integer[][]{
                {1, 3, 5}, {2, 6, 9}, {3, 6, 9}
        };
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < arr[0].length; j++) {
                matrix.get(i).add(arr[i][j]);
            }
        }
        System.out.println(findMedian(matrix));
    }

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low = 1;
        int high = (int) 1e9;
        int n = A.size();
        int m = A.get(0).size();

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += countSmallerThanAndEqualThanMid(A.get(i), mid);
            }
            if (cnt <= (n * m) / 2) {
                low = mid + 1;
            } else high = mid - 1;
        }

        return low;

    }

    public static int countSmallerThanAndEqualThanMid(ArrayList<Integer> a, int mid) {
        int l = 0;
        int h = a.size() - 1;
        while (l <= h) {
            int md = (l + h) / 2;
            if (a.get(md) <= mid) {
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return l;
    }

    public static int findMedian1(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (ArrayList<Integer> integers : A) {
            arr.addAll(integers);
        }
        Collections.sort(arr);
        int median = arr.size() / 2;
        return arr.get(median);
    }
}
