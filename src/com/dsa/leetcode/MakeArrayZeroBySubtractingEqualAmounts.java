package com.dsa.leetcode;

import java.util.Arrays;

public class MakeArrayZeroBySubtractingEqualAmounts {
    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3, 5};

        System.out.println(minimumOperations(nums));
    }


    public static int minimumOperations(int[] nums) {
        int c = 0;
        while (prefixSum(nums) != 0) {
            int min = findMin(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] = nums[i] - min;
                }
            }
            c++;
        }
        return c;
    }

    public static int prefixSum(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }

    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min && num != 0) min = num;
        }
        return min;
    }
}
