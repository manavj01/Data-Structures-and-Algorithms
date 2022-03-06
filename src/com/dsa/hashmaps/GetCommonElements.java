package com.dsa.hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElements {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=scn.nextInt();
        }
        int m = scn.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i]=scn.nextInt();
        }

        HashMap<Integer,Integer> fmap = new HashMap<>();

        for (Integer val: arr1) {
            if(fmap.containsKey(val)){
                int of = fmap.get(val);
                int nf = of+1;
                fmap.put(val,nf);
            }else{
                fmap.put(val,1);
            }
        }
        for (int val:arr2) {
            if(fmap.containsKey(val)){
                System.out.println(val);
                fmap.remove(val);
            }
        }
    }


}