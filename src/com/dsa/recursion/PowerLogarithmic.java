package com.dsa.recursion;

import java.util.Scanner;

public class PowerLogarithmic {
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
        int pwnb2 = power(x,n/2);
        int pwn = pwnb2 * pwnb2;

        if(n%2==1){
            pwn = pwnb2 * pwnb2 * x;
        }
        return pwn;
    }
}
