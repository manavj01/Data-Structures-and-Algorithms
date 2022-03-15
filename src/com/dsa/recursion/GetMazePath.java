package com.dsa.recursion;
import java.util.*;
public class GetMazePath {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int sr = scn.nextInt();
        int sc= scn.nextInt();
        int dr = scn.nextInt();
        int dc = scn.nextInt();

        ArrayList<String> res = getMazePaths(sr,sc,dr,dc);
        System.out.println(res);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        return null;



    }
}
