package com.dsa.recursion;

import java.util.Scanner;

public class FirstIndex {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();

        int uu = firstIndex(arr,0,x);
        System.out.println(uu);

    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }
        // bad approach
//        int fiisa = firstIndex(arr,idx+1,x);
//        if(arr[idx] ==x){
//            return idx;
//        }else return fiisa;

        // good approach
        if(arr[idx]==x){
            return idx;
        }else{
            int fiisa = firstIndex(arr,idx+1,x);
            return fiisa;
        }

    }

}
