package com.dsa.striver30daysSheet.d13_StacksAndQueues1;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 1};
        int[] nums = new int[]{3, 8, 4, 1, 2};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : A[stack.peek()];
            stack.push(i % n);
        }

        return res;
    }

    public static int[] nextGreaterElements1(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                res[stack.pop()] = A[i % n];
            stack.push(i % n);
        }
        return res;
    }

    public static int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (true) {
                if (j == n) {
                    j = 0;
                }
                if (j == i) {
                    ret[idx++] = -1;
                    break;
                } else if (nums[j] > nums[i]) {
                    ret[idx++] = nums[j];
                    break;
                }
                j++;
            }
        }

        return ret;
    }
}
