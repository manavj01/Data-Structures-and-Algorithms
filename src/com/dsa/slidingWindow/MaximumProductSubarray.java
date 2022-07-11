package com.dsa.slidingWindow;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] A = new int[]{2,3,-2,4};
//        int[] A = new int[]{-2,0,-1};
        int ans = maxProduct(A);
        System.out.println(ans);
    }

    public static int maxProduct(int[] A){
        int r = A[0];
        int n = A.length;
        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < n; i++) {
            // multiplied by a negative makes big number smaller, small number bigger,
            // so we redefine the extremes by swapping them
            if (A[i] < 0)
                imax += (imin-(imin=imax)); //(swapped imin & imax)

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }
}
