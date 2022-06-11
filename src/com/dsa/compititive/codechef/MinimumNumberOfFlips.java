package com.dsa.compititive.codechef;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfFlips {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(inp.readLine());

        for (int z = 0; z < n; z++) {

            int f = Integer.parseInt(inp.readLine());
            String[] lineItems = inp.readLine().split(" ");
            int[] arr = new int[f];
            for (int i = 0; i < f; i++) {
                arr[i] = Integer.parseInt(lineItems[i]);
            }
            int sum = 0;
            if (f % 2 == 1) {
                System.out.println("-1");
            } else {
                for (int i = 0; i < f; i++) {
                    sum += arr[i];
                }
                if (sum == 0) {
                    System.out.println("0");
                } else {
                    System.out.println(Math.abs(sum / 2));
                }
            }
        }
    }
}
