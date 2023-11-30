package com.dsa.compititiveProgramming.codestudio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        while (n-- > 0) {
            String[] line1 = br.readLine().trim().split(" ");
            int size = Integer.parseInt(line1[0]);

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr = new int[size];

            for(int i = 0; i < line2.length; ++i) {
                arr[i] = Integer.parseInt(line2[i]);
            }

            int odd = 0;

            for (int i=0; i<size; i++){
                if (arr[i]%2 != 0){
                    odd++;
                }
            }
            if (odd%2 == 0){
                System.out.println("Yes");
            }else System.out.println("No");
        }
    }
}
