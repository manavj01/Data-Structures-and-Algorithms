package com.dsa.striver30daysSheet.d7_LinkedListAndArrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                // i++;
                nums[++i] = nums[j];
            }
        }
        return i + 1;

    }

    public static int removeDuplicates1(int[] nums) {

        if (nums.length == 1) return 1;

        int currentIndex = 0;
        int currentElement = nums[0];
        int index = 1;

        while (currentIndex < nums.length) {

            while (currentIndex < nums.length && nums[currentIndex] == currentElement) {
                currentIndex++;
            }

            if (currentIndex < nums.length) {
                nums[index] = nums[currentIndex];
                index++;
                currentElement = nums[currentIndex];
            }
        }

        return index;

    }

    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}
