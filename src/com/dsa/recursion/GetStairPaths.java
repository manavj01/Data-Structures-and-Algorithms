package com.dsa.recursion;

import java.util.*;

public class GetStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> result = getStairPaths(n);
        System.out.println(result);
    }

    public static ArrayList<String> getStairPaths(int n) {

        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if (n < 0) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> path1 = getStairPaths(n - 1);
        ArrayList<String> path2 = getStairPaths(n - 2);
        ArrayList<String> path3 = getStairPaths(n - 3);

        ArrayList<String> res = new ArrayList<>();
        for (String s1 : path1) {
            res.add(1 + s1);
        }
        for (String s2 : path2) {
            res.add(2 + s2);
        }
        for (String s3 : path3) {
            res.add(3 + s3);
        }

        return res;

    }
}
