package com.dsa.striver30daysSheet;

import java.sql.Array;
import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortColors(int[] arr) {

        int red0 = 0;
        int white1 = 0;
        int blue2 = 0;

        for (int j : arr) {
            if (j == 0) {
                red0++;
            } else if (j == 1) {
                white1++;
            } else if (j == 2) {
                blue2++;
            }

        }
        int idx = 0;

        while (red0 != 0) {
            arr[idx++] = 0;
            red0--;
        }
        while (white1 != 0) {
            arr[idx++] = 1;
            white1--;
        }
        while (blue2 != 0) {
            arr[idx++] = 2;
            blue2--;
        }

    }


    public static void sortColors1(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }

    }

    public static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}

