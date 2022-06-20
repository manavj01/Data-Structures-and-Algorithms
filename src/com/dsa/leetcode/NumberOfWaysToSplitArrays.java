package com.dsa.leetcode;

import java.util.Scanner;

public class NumberOfWaysToSplitArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        int ans = waysToSplitArray(nums);
        System.out.println(ans);
    }

    public static int waysToSplitArray(int[] nums) {
        int valid_splits = 0;

        int left_arr = nums[0];
        int arrsum = 0;
        for (int i = 1; i < nums.length; i++) {
            arrsum += nums[i];
        }

        if (left_arr > arrsum) {
            valid_splits++;
        }

        for (int pos = 1; pos < nums.length - 2; pos++) {
            int nums_left[] = new int[pos];
            int nums_right[] = new int[nums.length - pos];

            for (int i = 0; i < nums.length; i++) {
                if (i < pos) {
                    nums_left[i] = nums[i];
                } else {
                    nums_right[i - pos] = nums[i];
                }

            }

            int sum_left = 0;
            for (int j = 0; j < nums_left.length; j++) {
                sum_left += nums_left[j];
            }
            int sum_right = 0;
            for (int j = 0; j < nums_left.length; j++) {
                sum_right += nums_right[j];
            }

            if (sum_left > sum_right) {
                valid_splits++;
            }

        }

        return valid_splits;
    }
}
