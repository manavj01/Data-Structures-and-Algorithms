package com.dsa.interviewQuestions;

public class FindElementInInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int n = findPos(arr, 200);
        System.out.println(n);
    }

    public static int findPos(int[] arr, int ans) {
        int i = 0;
        int j = 1;

        while (j < arr.length - 1) {
            if (arr[j] < ans) {
                i = j;
                j = j * 2;
            }
        }
        if (j > arr.length - 1) {
            return -1;
        } else return binarySearch(arr, i, j, ans);
    }

    public static int binarySearch(int[] arr, int s, int e, int ans) {


        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == ans) {
                return mid;
            }
            if (ans > arr[mid]) {
                s = mid + 1;
            } else e = mid - 1;
        }

        return -1;
    }
}
