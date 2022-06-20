package com.dsa.leetcode;

import java.util.Scanner;

public class MinMaxGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = {1, 3, 5, 2, 4, 8, 2, 2};
        int ans = minMaxGame(arr);
        System.out.println(ans);
    }

    public static int minMaxGame(int[] nums) {
        int ret = 0;
        int[] newNums;
//        while (nums.length >= 1) {}
        while (nums.length != 1) {
            newNums = new int[nums.length / 2];
            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else if (i % 2 == 1) {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
            if (newNums.length == 1) {
                ret = newNums[0];
            }
        }

        return ret;
    }
}
