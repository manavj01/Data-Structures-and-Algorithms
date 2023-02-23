package com.dsa.striver30daysSheet.d11_BinarySearch;

public class Nth_RootOfAnInteger {
    public static void main(String[] args) {
        System.out.println(mySqrt(27, 3));
    }

    public static int mySqrt(int number, int power) {
        double low = 1;
        double high = number;
        double eps = 1e-6;

        while ((high - low) > eps) {
            double mid = (low + high) / 2.0;
            if (multiply(mid, power) < number) {
                low = mid;
            } else high = mid;
        }

        return (int) high;
    }

    public static double multiply(double number, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans *= number;
        }
        return ans;
    }
}
