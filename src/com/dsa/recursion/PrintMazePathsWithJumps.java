package com.dsa.recursion;

import java.util.Scanner;

public class PrintMazePathsWithJumps {
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

        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }

        //for horizontal path
        for (int ms = 1; ms <= dc - sc; ms++) {
            printMazePaths(sr, sc + ms, dr, dc, psf + "h" + ms);
        }
        //for vertical path
        for (int ms = 1; ms <= dr - sr; ms++) {
            printMazePaths(sr + ms, sc, dr, dc, psf + "v" + ms);
        }
        //for diagonal path

        for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            printMazePaths(sr + ms, sc + ms, dr, dc, psf + "d" + ms);
        }
    }

}
