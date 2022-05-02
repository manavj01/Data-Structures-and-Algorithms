package com.dsa.recursion;

import java.util.Scanner;

public class PrintMazePaths {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        if (dc == sc && dr == sr) {
            System.out.println(psf);
            return;
        }
        //approach 1
//        if(sc<dc){
//            printMazePaths(sr,sc+1,dr,dc,psf+"h");
//        }
//        if(sr<dr){
//            printMazePaths(sr+1,sc,dr,dc,psf+"v");
//        }

        // approach 2

        if (sc > dc || sr > dr) {
            return;
        }
        printMazePaths(sr, sc + 1, dr, dc, psf + "h");
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");
    }
}
