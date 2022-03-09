package com.dsa.recursion;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x= scn.nextInt();
        int n= scn.nextInt();
        scn.close();
        System.out.println(power(x,n));

    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
       int powm1 = power(x,n-1);
       int pow = powm1*x;
       return pow;
    }

}
