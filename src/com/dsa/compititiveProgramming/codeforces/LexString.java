package com.dsa.compititiveProgramming.codeforces;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LexString {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // "45" -> 45


        while(n>0){
            int arrsize = scn.nextInt();
            int k = scn.nextInt();
            int[] arr = new int[arrsize];
            for (int i=0; i<arrsize; i++){
                arr[i] = scn.nextInt();
            }

            Arrays.sort(arr);

            int max = 1;
            if(arrsize <= 1){
                System.out.println(0);
                break;
            }
            int i=0;
            int j= 1;

            while (j<arrsize){
                int sum = 1;
                if (Math.abs(arr[i]-arr[j]) <= k){
                    sum++;
                }else {
                    sum = 1;
                }
                max = Math.max(sum+1,max);
                i++;
                j++;
            }
            System.out.println(arrsize-max);

            n--;
        }
    }
}