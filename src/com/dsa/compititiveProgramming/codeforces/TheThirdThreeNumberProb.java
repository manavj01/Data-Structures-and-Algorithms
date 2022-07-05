package com.dsa.compititiveProgramming.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheThirdThreeNumberProb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ip = Integer.parseInt(br.readLine());

        while (ip > 0) {
            String[] n = br.readLine().split(" ");
            int a = Integer.parseInt(n[0]);
            int b = Integer.parseInt(n[1]);

            int[][] arr = new int[a][b];
            for (int[] ar : arr) Arrays.fill(ar, 1);
            int flag = 0;
            int c = 0;
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {

                }
            }


            ip--;
            for (int[] ar : arr) System.out.println(Arrays.toString(ar));
        }

    }
}
