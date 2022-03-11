package com.dsa.recursion;

import java.util.Scanner;

public class DisplayArray {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        //my approach
       // displayArr(arr,n);

        //other approach
        displayArr(arr,0);
    }

    public static void displayArr(int[] arr, int idx) {

        // my approach
//        if(idx==0){
//            return;
//        }
//        displayArr(arr,idx-1);
//        System.out.println(arr[idx-1]);
        if (idx == arr.length) return;

        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }

}
