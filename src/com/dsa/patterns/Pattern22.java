package com.dsa.patterns;

import java.util.Scanner;

public class Pattern22 {
    //  pattern 22
//     *	*	*	*	*	*	*	
// 	        *	*	*	*	*	
// 		        *	*	*	
// 			        *	
// 		        *		*	
// 	        *				*	
//      *	*	*	*	*	*	*	
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();


        int space = 0;
        int star = n;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= space; j++) {
                System.out.print("\t");
            }
            for (int k = 1; k <= star; k++) {
                if (i > n / 2 + 1 && i < n && k > 1 && k < star)
                    System.out.print("\t");
                else {
                    System.out.print("*\t");
                }
            }

            if (i <= n / 2) {
                space++;
                star -= 2;
            } else {
                space--;
                star += 2;
            }
            System.out.println();
        }
    }
}
