package com.dsa.striver30daysSheet.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> ans = generate1(5);
        System.out.println(ans);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            Integer[] arr = new Integer[i + 1];
            int si = 0;
            int ei = arr.length - 1;
            arr[si] = 1;
            arr[ei] = 1;

            if (i >= 2) {
                int i1 = 0;
                int i2 = 1;
                for (int idx = si + 1; idx < ei; idx++) {
                    arr[idx] = res.get(i - 1).get(i1) + res.get(i - 1).get(i2);
                    i1++;
                    i2++;
                }
            }
            res.add(Arrays.asList(arr));
        }


        return res;
    }

    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;

        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<>();

            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
                pre = row;
                res.add(row);
            }
        }
        return res;
    }
}
