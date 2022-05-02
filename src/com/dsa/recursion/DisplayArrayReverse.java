package com.dsa.recursion;

import java.io.*;
import java.util.*;

public class DisplayArrayReverse {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        //a1
        // displayArrReverse(arr,n);
        //a2
        displayArrReverse(arr, 0);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        //a1
//        if(idx==0){
//            return;
//        }
//
//        System.out.println(arr[idx-1]);
//        displayArrReverse(arr,idx-1);

        //a2
        if (idx == arr.length) return;
        displayArrReverse(arr, idx + 1);
        System.out.println(arr[idx]);

    }
}
