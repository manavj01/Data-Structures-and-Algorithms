package com.dsa.striver30daysSheet.arrays3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UniquePaths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        System.out.println(uniquePaths(n, m));
    }

    static int c = 0;

    public static int uniquePaths1(int n, int m) {
        boolean[][] arr = new boolean[n][m];
        int sr = 0, sc = 0;
        getPaths(arr, sr, sc);
        return c;
    }

    public static void getPaths(boolean[][] arr, int sr, int sc) {
        if (sr==arr.length||sc == arr[0].length || arr[sr][sc]) {
            return;
        }

        if (sc == arr[0].length-1 && sr == arr.length-1) {
            c++;
            return;
        }

        arr[sr][sc] = true;
        getPaths(arr, sr, sc + 1);
        getPaths(arr, sr + 1, sc);
        arr[sr][sc] = false;
    }

    public static int uniquePaths(int n, int m){
        int i=0,j=0;
        int ans = countPaths(i,j,n,m);
        return ans;
    }
    public static int countPaths(int i,int j, int n , int m){
        if (i == (n-1) && j == (m-1)){
            return 1;
        }
        if (i>= n || j>= m){
            return 0;
        }else return countPaths(i+1,j,n,m)+countPaths(i,j+1,n,m);

    }

}
