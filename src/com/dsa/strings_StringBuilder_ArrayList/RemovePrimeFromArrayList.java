package com.dsa.strings_StringBuilder_ArrayList;

import java.util.*;


public class RemovePrimeFromArrayList {

    public static Boolean isPrime(int val) {
        for (int div = 2; div * div <= val; div++) {
            if (val % div == 0) {
                return false;
            }
        }
        return true;
    }


    public static void solution(ArrayList<Integer> arrlist) {

        for (int i = arrlist.size() - 1; i >= 0; i--) {
            int val = arrlist.get(i);
            if (isPrime(val)) {
                arrlist.remove(i);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> arrlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrlist.add(scn.nextInt());
        }
        solution(arrlist);
        System.out.println(arrlist);
    }
}
