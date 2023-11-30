package com.dsa.utility;

import java.util.*;
import java.io.*;


public class Interview {
    public static void main(String[] args){
        int[] arr = {-5,-3,2,3,4,4};
        int[] res = new int[arr.length];
        int pivot =-1;
        for(int i=0; i<arr.length;i++){
            if(arr[i] < 0){
                pivot = i;
            }

            arr[i] = arr[i]*arr[i];
        }
        if(pivot < 0){
            System.out.println(Arrays.toString(arr));
        }else{
            // { 25,9,4,9,16,16}
//            i  j
            int i=pivot+1;
            int j =pivot;
            int idx = 0;
            while(i<arr.length && j>-1){
                if(arr[i] >arr[j]){
                    res[idx++] = arr[j];
                    j--;
                }else{
                    res[idx++] = arr[i] ;
                    i++;
                }
            }

            if(j!= -1){
                int x = j;
                for(int k = idx; k < arr.length-x; k++){
                    res[k] = arr[j--];
                }
            }
            if(i != arr.length){
                for(int k = i; k<arr.length; k++){
                    res[idx++] = arr[k];
                }
            }

        }
        System.out.println(Arrays.toString(res));


    }

}