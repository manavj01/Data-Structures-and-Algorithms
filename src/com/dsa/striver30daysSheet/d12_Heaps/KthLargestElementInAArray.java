package com.dsa.striver30daysSheet.d12_Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new KthLargestElementInAArray().findKthLargest(nums, k));
    }

    // priority Queue
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int num : nums) {
            que.add(num);

            if (que.size() > k) {
                que.poll();
            }
        }
        return que.peek();
    }

    // Quick select algorithm
    public int findKthLargest(int[] nums, int k) {

        return quickSelect(nums, 0, nums.length - 1, nums.length-k );
    }

    public int quickSelect(int[] nums, int lo, int hi, int k) {
        int pivot = nums[hi];
        int pi = partition(nums,pivot, lo,hi);
        if(k>pi){
            return quickSelect(nums,pi+1,hi,k);
        }else if (k<pi){
            return quickSelect(nums,lo,pi-1,k);
        }else {
            return nums[pi];
        }
    }

    public int partition(int[] arr, int pivot, int lo, int hi) {
        int i=lo,j=lo;
        while (i <= hi){
            if (arr[i] <=pivot){
                swap(arr,i,j);
                i++;
                j++;
            }else {
                i++;
            }
        }
        return j-1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
