package com.dsa.leetcode;

import com.dsa.utility.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountHillAndValleys {

    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int[] arr = new int[n];
//        for (int i=0; i<arr.length; i++){
//            arr[i] = scn.nextInt();
//        }
        CountHillAndValleys chv = new CountHillAndValleys();
        int ans = chv.countHillValley2(new int[]{2, 4, 1, 1, 6, 5});
        System.out.println(ans);
    }

    public int[] removeDuplicates(int[] nums) {
        // only remove local duplicates
        // 5,4,4,6 => 5,4,6
        // 5,6,5 => 5,6,5
        int lastElement = nums[0];
        ArrayList<Integer> al = new ArrayList<>();
        al.add(lastElement);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastElement) continue;
            al.add(nums[i]);
            lastElement = nums[i];
        }
        return al.stream().mapToInt(i -> i).toArray();
    }

    public int countHillValley2(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int hills = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] == nums[i] && i > 1) {
                nums[i - 1] = nums[i - 2];
            }
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                hills++;
            } else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                hills++;
            }
        }
        return hills;
    }

    public int countHillValley(int[] arr) {
        int[] nums = removeDuplicates(arr);
        int counthillvalley = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            // nums[i] > nums[i-1] and nums[i] < nums[i+1]
            if (nums[i] < nums[i + 1] && nums[i] > nums[i - 1]) {
                counthillvalley++;
            } else if (nums[i] > nums[i + 1] && nums[i] < nums[i - 1]) {
                counthillvalley++;
            } else {
                System.out.println("ELSE");
            }

        }

        return counthillvalley;
    }
}
