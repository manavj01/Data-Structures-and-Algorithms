package com.dsa.dynamicProgramming;

import java.util.Scanner;

public class BestTimeToBuyAndSellStocks5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
//    mpist = maximum profit if sold today
//    leastsf = least so for
//    dpl = maximum profit if you sell by today or before
        int mpist = 0;
        int leastsf = prices[0];
        int[] dpl = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < leastsf) {
                leastsf = prices[i];
            }
            mpist = prices[i] - leastsf;
            if (mpist > dpl[i - 1]) {
                dpl[i] = mpist;
            } else {
                dpl[i] = dpl[i - 1];
            }
        }
//        mpibt = maximum profit if bought today
//        maxat = max after today
//        dpr= maximum profit if you buy by today or later
        int mpibt = 0;
        int maxat = prices[prices.length - 1];
        int dpr[] = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > maxat) {
                maxat = prices[i];
            }
            mpibt = maxat - prices[i];
            if (mpibt > dpr[i + 1]) {
                dpr[i] = mpibt;
            } else {
                dpr[i] = dpr[i + 1];
            }
        }
        int op = 0;
        for (int i = 0; i < prices.length; i++) {
            if (dpl[i] + dpr[i] > op) {
                op = dpl[i] + dpr[i];
            }
        }

        return op;

    }
}
