package com.dsa.striver30daysSheet.arrays2;

public class Inversions {
    public static void main(String[] args) {
        long[] arr = new long[]{2, 4, 1, 3, 5};

        System.out.println(countInversions(arr));

    }

    public static int countInversions1(long[] arr) {
        int c = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    c++;
                }
            }
        }

        return c;
    }

    /* this func merges two sorted arrays
     and returns inversion count in the array */
    static long merge(long[] a, long[] temp, int left, int mid, int right) {
        int i = left; /* i is  index for left subarray*/
        int j = mid;  /* j is  index for right subarray*/
        int k = left; /* k is index for resultant merged subarray*/
        long inv = 0;

        while ((i <= mid - 1) && (j <= right)) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                /* this is tricky -- see above
                 explanation/ diagram for merge() */
                inv += (mid - i);
            }
        }

        while (i <= mid - 1) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];

        for (i = left; i <= right; i++) a[i] = temp[i];

        return inv;
    }

    static long mergeSort(long[] a, long[] temp, int left, int right) {
        long inv = 0;
        if (left < right) {

            int mid = (left + right) / 2;

            inv += mergeSort(a, temp, left, mid);
            inv += mergeSort(a, temp, mid + 1, right);

            inv += merge(a, temp, left, mid + 1, right);
        }
        return inv;
    }

    static long countInversions(long[] arr) {
        // Your Code Here
        long N = arr.length;
        long[] temp = new long[(int) N];
        return mergeSort(arr, temp, 0, (int) N - 1);
    }
}
