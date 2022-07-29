package com.dsa.striver30daysSheet.arrays4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
//        int[] nums = new int[]{-491, -489, -470, -428, -416, -413, -394, -390, -377, -373, -362, -357, -349, -328, -282, -270, -266, -247, -175
//                , -156, -133, -122, -116, -102, -91, -57, -44, -42, -37, -24, -2, 20, 42, 55, 58, 71, 123, 136, 139, 151, 155, 164, 165, 193, 212,
//                223, 294, 299, 309, 313, 318, 327, 341, 357, 374, 375, 390, 392, 413, 427, 453, 457, 459, 466, 497, 499};
//        int target = -3742;
        int target = -294967296;
        System.out.println(fourSum(nums, target));

    }

    public static List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        if (num == null || num.length == 0)
            return res;

        int n = num.length;

        Arrays.sort(num);

        for (int i = 0; i < n; i++) {

            long target_3 = target - num[i];

            for (int j = i + 1; j < n; j++) {

                long target_2 = target_3 - num[j];

                int front = j + 1;
                int back = n - 1;

                while (front < back) {

                    int two_sum = num[front] + num[back];

                    if (two_sum < target_2) front++;

                    else if (two_sum > target_2) back--;

                    else {

                        List<Integer> quad = new ArrayList<>();
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[front]);
                        quad.add(num[back]);
                        res.add(quad);

                        // Processing the duplicates of number 3
                        while (front < back && num[front] == quad.get(2)) ++front;

                        // Processing the duplicates of number 4
                        while (front < back && num[back] == quad.get(3)) --back;

                    }
                }

                // Processing the duplicates of number 2
                while (j + 1 < n && num[j + 1] == num[j]) ++j;
            }

            // Processing the duplicates of number 1
            while (i + 1 < n && num[i + 1] == num[i]) ++i;

        }


        return res;
    }

    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    List<Integer> list = new ArrayList<>();
                    long sch = (long) nums[i] + (long) nums[j] + (long) nums[k];
                    long x = target - sch;
                    if (binarySearch(nums, x, k + 1, n - 1)) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(target - (int) sch);
                        if (!lists.contains(list)) {
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;

    }

    public static boolean binarySearch(int[] nums, long target, int si, int ei) {
        int n = nums.length;
        for (int i = si; i < n; i++) {
            int mid = si + (ei - si) / 2;
            if (nums[i] == target) {
                return true;
            }
            if (nums[i] > target) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return false;
    }
}
