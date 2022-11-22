package com.dsa.dailyLeetCodeQuest;

import java.util.HashMap;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,0,4,1,3};
        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
//        int c=1;
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, 0);
//        }
//        if (map.size()==2) return false;
//        for (int i = 0; i < nums.length - 1; i++) {
//            int val = nums[i];
//            c = 1;
//            int cc =1;
//            int spare = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] > val) {
//                    c++;
//                    val = nums[j];
//                }
//                if(nums[j] > spare && nums[j] != val ){
//                    cc++;
//                    spare = nums[j];
//                }
//            }
//            if (c >= 3) return true;
//            if (cc >=3) return true;
//        }
//
//        return false;

        // approach 2
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums){
            if(num <= first){
                first = num;
            } else if (num <= second) {
                second = num;
            }else return true;
        }
        return false;
    }
}
