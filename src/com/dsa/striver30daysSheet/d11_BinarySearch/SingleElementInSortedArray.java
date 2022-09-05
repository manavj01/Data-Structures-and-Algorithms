package com.dsa.striver30daysSheet.d11_BinarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate1(int[] arr) {

        int elem = 0;
        for (int num : arr) {
            elem = elem ^ num;
        }
        return elem;
    }

    public static int singleNonDuplicate(int[] arr) {

        int low = 0;
        int high = arr.length - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid % 2 == 0) {
                if (arr[mid] != arr[mid + 1]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] == arr[mid + 1]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }


        return arr[low];
    }
}
