package com.dsa.patterns;

import java.util.Scanner;

public class Pattern21 {
    
     //pattern 21
    // *                       *
    // *   *               *   *
    // *       *       *       *
    // *           *           *
    // *                       *
    // *                       *
    // *                       *
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(j==1 || j==n){
                    System.out.print("*\t");
                }else if((i<=n/2+1) && (i==j || i+j==n+1)){
                    System.out.print("*\t");
                } else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
