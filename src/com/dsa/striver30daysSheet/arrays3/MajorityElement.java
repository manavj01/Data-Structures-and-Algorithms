package com.dsa.striver30daysSheet.arrays3;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3};
//        int[] arr = new int[]{1, 13};

        System.out.println(majorityElement1(arr));
    }

    public static int majorityElement2(int[] nums) {
        int element = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                element = num;
            }
            if (element == num) {
                count++;
            } else {
                count--;

            }
        }
        return element;
    }

    public static int majorityElement1(int[] nums) {
        int maj = nums.length / 2;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }
        int max = Integer.MIN_VALUE;

        for (int a : freq.keySet()) {
            if (freq.get(a) > maj) {
                max = Math.max(max, a);
            }
        }
        return max;
    }

    static int majorityElement(int[] arr) {
        int n = arr.length;
        int res = 0, count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[res]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[res] == arr[i]) {
                count++;
            }
            if (count > (n / 2)) {
                return arr[res];
            }
        }
        if (count > (n / 2)) {
            return arr[res];
        }
        return -1;
    }

}
