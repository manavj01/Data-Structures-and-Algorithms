package com.dsa.patterns;

import java.util.Scanner;

public class Pattern7 {
// pattern 7
    //   *	
	//     *	
    //       *	
    //         *	
    //           *	

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close(); 

        int space=0;

//  Approach 1
        for(int i =1; i<=n; i++){

            for(int j=1; j<=space; j++){
                System.out.print("\t");
            }
            System.out.print("*");

            space++;

            System.out.println();
        }
// Approach 2
            // for(int i =1; i<=n; i++){
            //     for(int j=1; j<=n; j++){
            //         if(i==j){
            //             System.out.print("*\t");
            //         }else{
            //             System.out.print("\t");

            //         }
            //     }
            //     System.out.println();
            // }

    }
}
