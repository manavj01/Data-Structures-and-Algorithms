package com.dsa.striver30daysSheet.arrays4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubarrayWith0Sum {
    public static void main(String[] args) throws IOException {
//        int[] a = new int[]{-776, 794, 387, -648, 363, 691, 764, -539,
//                -171, -210, -566, 783, -861, 68, 930, -21, -68, 394, -10,
//                -228, 422, 785, 199, -314, -412, -90, -955, 863, -995, 306,
//                85, 337, 847, 314, 125, 583, 815, 435, -42, -86, -275, -787,
//                -402, 755, 933, -675, -738, -225, -93, 796, -433, -466, 98,
//                -316, -651, -300, -285, 866, 445, 441, 32, 98, 482, 710, 568,
//                -496, 587, 307, 220, -527, 733, 504, 271, -707, 341, 797, 619,
//                847, 922, 380, -763, -840, -192, -33};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(", ");
        int[] a = new int[n];
        int idx = n;
        for (String str : arr) {
            a[--idx] = Integer.parseInt(str);
        }
        System.out.println(maxLen(a, n));
    }

    static int maxLen1(int[] a, int n) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    static int maxLen(int[] a, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == 0) {
                maxLen = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    int idx = map.get(sum);
                    int len = i - idx;
                    maxLen = Math.max(maxLen, len);
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
