package com.dsa.leetcode;

import java.util.HashMap;
import java.util.Scanner;


public class DivideArrayInEqualParts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[2*n];
        for (int i =0; i< arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        DivideArrayInEqualParts obj = new DivideArrayInEqualParts();
        System.out.println(obj.divideArray( arr));
    }

    public boolean divideArray(int[] nums) {
       boolean flag=true;
        HashMap<Integer,Integer> freq = new HashMap<>();

        for (Integer val: nums) {
            if(freq.containsKey(val)){
                int of = freq.get(val);
                int nf = of+1;
                freq.put(val,nf);
            }else{
                freq.put(val,1);
            }
        }


        for (Integer val : nums){
            int abc =freq.get(val);
            if(abc%2==0){
                flag=true;
            }else {
                flag=false;
                break;
            }
        }
        return flag;



    }
}
