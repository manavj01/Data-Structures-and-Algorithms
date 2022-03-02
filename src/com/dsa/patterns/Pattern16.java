package com.dsa.patterns;

import java.util.Scanner;

public class Pattern16 {

    // pattern 16
    // 1             1
    // 1 2         2 1
    // 1 2 3     3 2 1
    // 1 2 3  4  3 2 1
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int star =1;
        int space = 2*n-3;
        for(int i=1;i<=n; i++){
            int val=1;
            for(int j=1; j<=star; j++){
                System.out.print( val+"\t");
               val++;
            }
            for(int k=1; k<=space; k++){
                System.out.print("\t");
            }

            if(i==n){
                star--;
                val--;
            }
            for(int j=1; j<=star; j++){
                val--;
                System.out.print(val +"\t");
               
            }
            space-=2;
            star++;
            
            System.out.println();
        }

        
    System.out.println();
    }

    }

