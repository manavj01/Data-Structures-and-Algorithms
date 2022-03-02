package com.dsa.basic;

import java.util.Scanner;

public class PrimeFactorOfNum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        for(int div = 2; div*div <= n; div++){
            while(n%div == 0){
                 n = n/div;
                 System.out.print(div + " ");
            }
        }
        if(n!=0){
            System.out.print(n);
        }
    }
}
