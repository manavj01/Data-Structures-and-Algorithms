package com.dsa.patterns;

import java.util.Scanner;

public class Pattern19 {
    
//pattern 19 - swastika
//      *   *   *       *
//              *       *
//      *   *   *   *   *
//      *       *
//      *       *   *   *

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        // approach1

        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<= n; j++){
        //         if(i==1 && j<=(n+1)/2  || j==(n+1)/2 || i==(n+1)/2 ||(i==n & j>=(n+1)/2)||((i>=(n+1)/2)&&(j==1)) ||((i<=(n+1)/2)&&(j==n)) ){

        //             System.out.print("*\t");
        //         }else{
        //             System.out.print("\t");
        //         }
        //     }
        //    System.out.println();
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){

                if (i==1) {
                    if(j<=n/2+1 ||  j==n){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                } 
                else if( i<=n/2) {
                    if(j==n/2+1 || j==n){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                } 
                else if(i==n/2+1){
                    System.out.print("*\t");
                } 
                else if(i<n){
                    if(j==1 || j==(n+1)/2){
                    System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                } 
                else{
                    if(j==1 || j>= n/2+1){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
        
        
        }
    }


    

