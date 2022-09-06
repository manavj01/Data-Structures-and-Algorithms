package com.dsa.striver30daysSheet.d7_LinkedListAndArrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxC = 0;
        int c = 0;
        for (int num : nums) {

            if (num == 1) {
                c++;
                maxC = Math.max(c, maxC);
            } else c = 0;
        }

        return maxC;
    }
}
