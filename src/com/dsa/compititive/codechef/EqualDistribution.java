package com.dsa.compititive.codechef;

import java.util.Scanner;

public class EqualDistribution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0 ; i < arr.length; i++){
            int b=0;
            int a=0;
            for (int j = 0; j<= 1; j++){
                a = arr[i][0];
                b = arr[i][1];
            }
            if ((a + b)% 2 == 0){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}
