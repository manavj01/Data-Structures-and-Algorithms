package com.dsa.compititive.codechef;

import java.io.*;

public class DivisibleBy3 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(inp.readLine());
        String[] lineItems = inp.readLine().split(" ");
        for (int input = 0; input < n; input++) {
            int ops = 0;
            int A = Integer.parseInt(inp.readLine());
            int B = Integer.parseInt(inp.readLine());

            if (A == 0 && (B % 3) == 0) {
                System.out.println(ops);
            }
        }
    }
}
