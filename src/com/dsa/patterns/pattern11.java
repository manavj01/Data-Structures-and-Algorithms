package com.dsa.patterns;

import java.util.Scanner;

public class pattern11 {
    
    //pattern 11
    // 1
    // 2 3
    // 4 5 6
    // 7 8 9 10
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        scn.close();

        int val =1;
        for(int i =1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(val+"\t");
                val+=1;
            }
            System.out.println();
        }
    }
}
