package com.dsa.striver30daysSheet.d12_Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new KthLargestElementInAArray().findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int num : nums) {
            que.add(num);

            if (que.size() > k) {
                que.poll();
            }
        }
        return que.peek();


    }
}
