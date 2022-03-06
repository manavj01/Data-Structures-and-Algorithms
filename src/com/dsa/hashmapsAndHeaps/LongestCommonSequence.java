package com.dsa.hashmapsAndHeaps;

import java.util.HashMap;
import java.util.Scanner;

public class LongestCommonSequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int val :
                arr) {
            map.put(val, true);
        }

        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }
        int msp = 0;
        int ml = 0;
        for (int val : arr) {
            if (map.get(val)) {
                int tl = 1;
                int tsp = val;
                while (map.containsKey(tsp + tl)) {
                    tl++;
                }
                if (tl > ml) {
                    msp = tsp;
                    ml = tl;
                }
            }
        }
        for (int i = 0; i < ml; i++) {
            System.out.println(msp + i);
        }
    }
}
