package com.dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AscendingBinarySort {
    public static void main(String[] args) {
        int n = 3;
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
//        List<Integer> res = ;
        System.out.println(solve(elements));
    }

    public static List<Integer> solve(List<Integer> elements) {
        int[] arr = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            arr[i] = elements.get(i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (getOneBits(arr[j]) < getOneBits(arr[j - 1]) || (getOneBits(arr[j]) == getOneBits(arr[j - 1]) && arr[j] < arr[j - 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int a : arr){
            res.add(a);
        }
        return res;
    }

    public static int getOneBits(int num) {
        int result = 0;
        for (int i = 0; i < 32; i++)
            if ((num & 1 << i) != 0)
                result++;
        return result;
    }

    public static int countOne(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') c++;
        }
        return c;
    }
}
//
//    List<Integer> ans = new ArrayList<>();
//    int[] bits = new int[elements.size()];
//
//        Collections.sort(elements);
//                for(int i = 0; i < elements.size(); i++){
//        int count = 0;
//        int n = elements.get(i);
//        while(n > 0){
//        if((n & 1) == 1){
//        count++;
//        }
//        n >>= 1;
//        }
//        bits[i] = count;
//        }
//        int l = 0;
//        for(int j = 0; j <= 14; j++){
//        int length = 0;
//        for(int k = 0; k < bits.length; k++){
//        if(j == bits[k]){
//        length++;
//        elements.set(l,elements.get(k));
//        l++;
//        }
//        }
//        }
//        return ans;