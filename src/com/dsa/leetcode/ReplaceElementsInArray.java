package com.dsa.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReplaceElementsInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
        int[] nums = {1, 2, 4, 6};
        int[][] ops = {{1, 3}, {4, 7}, {6, 1}};
        int ans[] = arrayChange(nums,ops);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> valididxmap = new HashMap<>();

        for (int i = 0 ; i < nums.length; i++){
            valididxmap.put(nums[i],i );
        }

        for (int[] operation : operations){
            int idx = valididxmap.get(operation[0]);
            nums[idx] = operation[1];
            valididxmap.remove(operation[0]);
            valididxmap.put(operation[1],idx );
        }
        return nums;
    }
}



