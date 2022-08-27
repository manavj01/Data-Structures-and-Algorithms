package com.dsa.striver30daysSheet.d7_LinkedListAndArrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    public static int removeDuplicates1(int[] nums) {

        int cNum = nums[0];
        int nc = 0;

        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int num : nums) {
            if (cNum == num) {
                nc++;
            } else {
                cNum = num;
                nc = 1;
            }
            if (nc < 3) {
                que.add(num);
            }
        }
        System.out.println(que);
        int size = que.size();
        for (int j = 0; j < size; j++) {
            nums[j] = que.remove();
        }
        return size;
    }
}
