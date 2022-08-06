package com.dsa.striver30daysSheet.d3_Arrays3;

public class PowXOfN {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;

        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        double ans = 1.0;
        double nn = n;

        if (nn < 0) {
            nn = -1 * nn;
        }

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0) {
            ans = (double) (1.0) / (double) (ans);
        }
        return ans;

    }
}
