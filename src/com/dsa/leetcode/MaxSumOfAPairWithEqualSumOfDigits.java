package com.dsa.leetcode;

import java.util.HashMap;

public class MaxSumOfAPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        int[] nums = {18, 43, 36, 13, 7};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {
        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = sumOfDigits(nums[i]);
            if (!map.containsKey(sum)) {
                map.put(sum, nums[i]);
            } else {
                max = Math.max(max, nums[i] + map.get(sum));
                map.put(sum, Math.max(nums[i], map.get(sum)));
            }

        }
        System.out.println(map);
        return max;
    }

    public static int sumOfDigits(int num) {
        if (num < 10) return num;

        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }

        return sum;
    }
}
