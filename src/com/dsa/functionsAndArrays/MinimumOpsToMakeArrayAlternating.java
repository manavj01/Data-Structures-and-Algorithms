package com.dsa.functionsAndArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumOpsToMakeArrayAlternating {
    public static void main(String[] args) {
//        int[] arr = new int[]{3, 1, 3, 2, 4, 3};
        int[] arr = new int[]{69, 91, 47, 74, 75, 94, 22, 100, 43, 50, 82, 47, 40, 51, 90, 27, 98, 85, 47, 14, 55, 82, 52, 9, 65, 90, 86, 45, 52, 52, 95, 40, 85, 3, 46, 77, 16, 59, 32, 22, 41, 87, 89, 78, 59, 78, 34, 26, 71, 9, 82, 68, 80, 74, 100, 6, 10, 53, 84, 80, 7, 87, 3, 82, 26, 26, 14, 37, 26, 58, 96, 73, 41, 2, 79, 43, 56, 74, 30, 71, 6, 100, 72, 93, 83, 40, 28, 79, 24};
//        int[] arr = new int[]{1,2,2,2,2};
        System.out.println(minimumOperations(arr));
    }

    public static int minimumOperations(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }

        int[] evenMax = getHighestAndSecondHighestPair(even.toArray(new Integer[0]));
        int[] oddMax = getHighestAndSecondHighestPair(odd.toArray(new Integer[0]));

        if (evenMax[0] != oddMax[0]) {
            return nums.length - (evenMax[1] + oddMax[1]);
        } else {
            return nums.length - Math.max(evenMax[1] + oddMax[2], evenMax[2] + oddMax[1]);
        }
    }

    static int[] getHighestAndSecondHighestPair(Integer arr[]) {
        int first = 0, second = 0;
        int[] frequency = new int[1_00_005];
        for (int i = 0; i < arr.length; i++) {
            frequency[arr[i]] += 1;
            if (frequency[arr[i]] >= frequency[first]) {
                if (arr[i] != first) {
                    second = first;
                }
                first = arr[i];
            } else if (frequency[arr[i]] > frequency[second]) {
                second = arr[i];
            }
        }
        return new int[]{first, frequency[first], frequency[second]};
    }

}
