package com.dsa.patterns;

import java.util.Scanner;

public class Pattern8 {
    // Pattern 8
//          *	
//        *		
//      *			
//    *				
//  *
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        //approach1

        // int space= n-1;
        // for(int i=1; i<=n;i++){
        //     for(int j = 1; j<=space;j++){
        //         System.out.print("\t");
        //     }
        //     System.out.print("*");
        //     space--;
        //     System.out.println();
        // }

        //approach 2

        // for(int i =n; i>=1; i--){
        //     for(int j =1; j<=n;j++ ){

        //         if(i==j){
        //             System.out.print("*");
        //         }else{
        //             System.out.print("\t");
        //         }
        //     }
        //     System.out.println();
        // }

        //approach 3

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i + j == n + 1) {
                    System.out.print("*");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();

        }
    }
}
