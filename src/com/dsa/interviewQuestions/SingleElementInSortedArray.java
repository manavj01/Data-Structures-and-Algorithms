package com.dsa.interviewQuestions;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] arr) {

        int i = 0;
        int j = arr.length - 2;

        while (i < j) {
            int mid = i + (j - i) / 2;

            if (mid % 2 == 0 && arr[mid] == arr[mid + 1]) {
                i = mid + 2;
            } else if (mid % 2 == 1 && arr[mid] == arr[mid - 1]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }


        return arr[i];
    }
}
