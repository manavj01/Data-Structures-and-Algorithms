package com.dsa.patterns;

import java.util.Scanner;

public class Pattern6 {

    // pattern 6
    //     * * *  * * *
    //     * *      * *
    //     *          *
    //     * *      * *
    //     * * *  * * *
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();


        int spcae = 1;
        int star = n / 2 + 1;


        for (int i = 1; i <= n; i++) {
             for (int j = star; j >= 1; j--) {
                System.out.print("*\t");
            }
        
            for (int j = spcae; j >= 1; j--) {
                System.out.print("\t");
            }
            for(int j = star; j>=1; j--){
                System.out.print("*\t");
            }

            if(i<=n/2){
                spcae+=2;
                star--;
            }else{
                spcae-=2;
                star++;
            }
            System.out.println();
        }

    }
}
