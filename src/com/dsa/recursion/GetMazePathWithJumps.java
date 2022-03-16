package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathWithJumps {

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if(sr==dr && sc==dc ){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> allPath = new ArrayList<>();
        //for horizontal path
        for (int ms=1; ms<=dc-sc; ms++){
            ArrayList<String> hpaths = getMazePaths(sr,sc+ms,dr,dc);
            for (String hpath: hpaths) {
                allPath.add("h"+ ms+ hpath);
            }
        }
        // for vertical path
        for (int ms=1; ms<=dr-sr; ms++){
            ArrayList<String> vpaths = getMazePaths(sr+ms,sc,dr,dc);
            for (String vpath: vpaths) {
                allPath.add("v"+ ms+ vpath);
            }
        }
        //for diagonal path
        for (int ms=1; ms<=dc-sc && ms<= dr-sr; ms++){
            ArrayList<String> dpaths = getMazePaths(sr+ms,sc+ms,dr,dc);
            for (String dpath: dpaths) {
                allPath.add("d"+ ms+ dpath);
            }
        }
        return allPath;

    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> res = getMazePaths(1,1,n,m);
        System.out.println(res);
    }
}
