package com.dsa.twodarrays;

import java.util.Scanner;

public class RingRotate {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int s = scn.nextInt();
        int r = scn.nextInt();

        scn.close();

        rotateShell(arr, s, r);
        display(arr);
    }

    public static void rotateShell(int[][] arr, int s, int r) {
        int[] oned = fillOnedFromShell(arr, s);
        rotate(oned, r);
        fillShellFromOned(arr, s, oned);
    }

    public static int[] fillOnedFromShell(int[][] arr, int s) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;

        int sz = 2 * (maxr - minr + maxc - minc);
        int[] oned = new int[sz];
        int idx = 0;
        for(int i = minr,j = minc; i<=maxr; i++){
            oned[idx] = arr[i][j]; 
            idx++;
        }

        for (int i = maxr,j=minc+1; j <= maxc; j++) {
            oned[idx] = arr[i][j]; 
            idx++;
        }

        for(int i = maxr-1, j=maxc; i>=minr; i--){
            oned[idx] = arr[i][j]; 
            idx++;
        }

        for(int i=minr, j = maxc-1; j>=minc+1; j--){
            oned[idx] = arr[i][j]; 
            idx++;
        }

        return oned;

    }



    public static void fillShellFromOned(int[][] arr, int s, int[] oned) {
        int minr = s - 1;
        int minc = s - 1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;

        
        int idx = 0;
        for(int i = minr,j = minc; i<=maxr; i++){
            arr[i][j] = oned[idx]  ; 
            idx++;
        }

        for (int i = maxr,j=minc+1; j <= maxc; j++) {
            arr[i][j] = oned[idx]  ; 
            idx++;
        }

        for(int i = maxr-1, j=maxc; i>=minr; i--){
            arr[i][j] = oned[idx]  ; 
            idx++;
        }

        for(int i=minr, j = maxc-1; j>=minc+1; j--){
            arr[i][j] = oned[idx]  ; 
            idx++;
        }

        
    }

    public static void rotate(int[] oned, int r) {
        r = r % oned.length;
        if (r < 0) {
            r = r + oned.length;
        }
        int p1li = 0;
        int p1ri = oned.length - r - 1;
        int p2li = oned.length - r;
        int p2ri = oned.length - 1;
        rotatefun(oned, p1li, p1ri);
        rotatefun(oned, p2li, p2ri);
        rotatefun(oned, 0, p2ri);
    }

    public static void rotatefun(int[] arr, int li, int ri) {

        while (li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }

    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
