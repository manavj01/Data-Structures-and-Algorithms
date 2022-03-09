package com.dsa.recursion;
import java.util.*;

public class PrintDecreasingIncreasing {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        pDI(n);

    }

    public static void pDI(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        pDI(n-1);
        System.out.println(n);


    }

}
