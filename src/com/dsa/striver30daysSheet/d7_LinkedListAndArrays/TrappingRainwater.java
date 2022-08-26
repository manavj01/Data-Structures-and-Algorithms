package com.dsa.striver30daysSheet.d7_LinkedListAndArrays;

import java.util.Arrays;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }

    public static int trap1(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        int max = height[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            prefixMax[i] = max;
        }
        max = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            suffixMax[i] = max;
        }
        int area = 0;
        for (int i = 0; i < n; i++) {
            area += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return area;
    }
}
