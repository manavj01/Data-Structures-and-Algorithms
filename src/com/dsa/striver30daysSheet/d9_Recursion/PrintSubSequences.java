package com.dsa.striver30daysSheet.d9_Recursion;

import java.util.ArrayList;

public class PrintSubSequences {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        System.out.println(subsets1(nums1));
        int[] nums2 = new int[]{1, 2, 2};
        System.out.println(subsets2(nums2));
    }

    public static ArrayList<ArrayList<Integer>> subsets1(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        subsets1Helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public static void subsets1Helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int[] nums, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[idx]);
        subsets1Helper(res, arr, nums, idx + 1);
        arr.remove(arr.size() - 1);
        subsets1Helper(res, arr, nums, idx + 1);
    }

    public static ArrayList<ArrayList<Integer>> subsets2(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        subsets2Helper(res, new ArrayList<>(), nums, 0, false);
        return res;
    }

    public static void subsets2Helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int[] nums, int idx, boolean takePre) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[idx]);
        subsets2Helper(res, arr, nums, idx + 1, true);
        arr.remove(arr.size() - 1);
        if (idx >= 1 && nums[idx] == nums[idx - 1] && takePre) return;
        subsets2Helper(res, arr, nums, idx + 1, false);

    }
    // 2nd approach
//    public static void subsets2Helper(List<List<Integer>> res, ArrayList<Integer> arr, int[] nums, int idx, boolean takePre) {
//        if (idx == nums.length) {
//            res.add(new ArrayList<>(arr));
//            return;
//        }
//
//        subsets2Helper(res, arr, nums, idx + 1, false);
//        if (idx >= 1 && nums[idx] == nums[idx - 1] && !takePre) return;
//        arr.add(nums[idx]);
//        subsets2Helper(res, arr, nums, idx + 1, true);
//        arr.remove(arr.size() - 1);
//    }
}
