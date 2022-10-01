package com.dsa.striver30daysSheet.d11_BinarySearch;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 10, 12}, arr2 = {2, 3, 6, 15};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(arr1, arr2));
    }

    public double findMedianSortedArrays(int[] a, int[] b) {

        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }
        int lo = 0;
        int hi = a.length;
        int te = a.length + b.length;

        while (lo <= hi) {
            int aLeft = (lo + hi) / 2;
            int bLeft = (te + 1) / 2 - aLeft;

            int alm1 = (aLeft == 0) ? Integer.MIN_VALUE : a[aLeft - 1];
            int al = (aLeft == a.length) ? Integer.MAX_VALUE : a[aLeft];
            int blm1 = (bLeft == 0) ? Integer.MIN_VALUE : b[bLeft - 1];
            int bl = (bLeft == b.length) ? Integer.MAX_VALUE : b[bLeft];

            // valid segregation
            if (alm1 <= bl && blm1 <= al) {
                double median = 0.0;

                if (te % 2 == 0) {
                    int lmax = Math.max(alm1, blm1);
                    int rmin = Math.min(al, bl);
                    median = (lmax + rmin) / 2.0;
                } else {
                    int lmax = Math.max(alm1, blm1);
                    median = lmax;
                }
                return median;

            } else if (alm1 > bl) {
                // there are more elements to be picked in Left part 'b' array
                hi = aLeft - 1;
            } else if (blm1 > al) {
                // there are more elements to be picked in Left part 'a' array
                lo = aLeft + 1;
            }
        }

        return 0;
    }
}
