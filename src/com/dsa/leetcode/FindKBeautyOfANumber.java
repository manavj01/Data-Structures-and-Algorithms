package com.dsa.leetcode;

import java.util.Scanner;

public class FindKBeautyOfANumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int k = scn.nextInt();

       int ans = divisorSubstrings(num, k);
        System.out.println(ans);

    }

    public static int divisorSubstrings(int num, int k) {
        int num_bfr = num;
        int beauty_count = 0;
        String str = Integer.toString(num_bfr);

        for (int i = 0, j = k; i < num_bfr && j<str.length()+1; i++,j++) {
            String s =str.substring(i, j);
            int convStr = Integer.parseInt(s);
//            System.out.println(convStr);
            if(convStr!=0){
                if(num % convStr ==0){
                    beauty_count++;
                }
            }
        }

        return beauty_count;
    }
}