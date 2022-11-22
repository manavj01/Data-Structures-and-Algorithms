package com.dsa.interviewQuestions;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{12, 31, 25, 8, 32, 17, 40, 42};
        Practice(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1] ^ (arr[j + 1] = arr[j]); //swapping
                }

            }
        }
    }

    public static void Practice(int[] arr){

        for (int i= arr.length-1; i>=0 ; i--){
            for (int j=0; j< i; j++){
                if(arr[j] > arr[j+1]){
//                    arr[j] = arr[j] ^ arr[j+1] ^ (arr[j+1] = arr[j]);
                    arr[j] = arr[j] + arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
        }
    }


}
