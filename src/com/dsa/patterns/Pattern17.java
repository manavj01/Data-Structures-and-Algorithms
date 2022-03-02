package com.dsa.patterns;

import java.util.Scanner;

class Pattern17 {
    
    //pattern17
    //        *
    //        *  *
    //  *  *  *  *  *
    //        *  *
    //        *
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int space=n/2;
        int star=1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=space; j++){
                if(i== (n+1)/2){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");

                }
            }
            for(int k=1; k<=star; k++){
                System.out.print("*\t");
            }
            if(i<=n/2){
                
                star++;
            }else{
                star--;
            }
            
            
            System.out.println();
            
        }
        System.out.println(5/3);
    }
}
