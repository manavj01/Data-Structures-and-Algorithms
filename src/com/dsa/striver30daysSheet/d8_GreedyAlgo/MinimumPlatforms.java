package com.dsa.striver30daysSheet.d8_GreedyAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumPlatforms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dep = new int[n];

        String[] str = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        str = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            dep[i] = Integer.parseInt(str[i]);
        }
        System.out.println(new MinimumPlatforms().findPlatform(arr, dep, n));

    }

    static class Platform {
        int arr;
        int dep;

        Platform(int arr, int dep) {
            this.arr = arr;
            this.dep = dep;
        }

    }

    public static class PlatformComparator implements Comparator<Platform> {

        @Override
        public int compare(Platform o1, Platform o2) {
            return o1.dep - o2.dep;
        }
    }

    public int findPlatform(int[] arr, int[] dep, int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
            if (plat_needed > result) {
                result = plat_needed;
            }
        }

        return result;
    }
}

//6
// 0900 0940 0950 1100 1500 1800
// 0910 1200 1120 1130 1900 2000