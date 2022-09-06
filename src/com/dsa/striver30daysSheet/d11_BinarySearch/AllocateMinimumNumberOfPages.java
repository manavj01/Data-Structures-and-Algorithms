package com.dsa.striver30daysSheet.d11_BinarySearch;

import java.util.ArrayList;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(34);
        arr.add(67);
        arr.add(90);
        int B = 2;
        System.out.println(books(arr, B));
    }

    public static int books(ArrayList<Integer> A, int B) {
        if (B > A.size()) return -1;

        int low = A.get(0);
        int high = 0;
        for (int a : A) {
            high += a;
            low = Math.min(low, a);
        }
//        int res =-1;

        while (low <= high) {
            int mid = low + high >> 1;
            if (isPossible(A, mid, B)) {
//                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static boolean isPossible(ArrayList<Integer> A, int pages, int students) {
        int cnt = 0;
        int sumAllocated = 0;

        for (Integer a : A) {
            if (sumAllocated + a > pages) {
                cnt++;
                sumAllocated = a;
                if (sumAllocated > pages) return false;
            } else {
                sumAllocated += a;
            }
        }
        return cnt < students;
    }
}
