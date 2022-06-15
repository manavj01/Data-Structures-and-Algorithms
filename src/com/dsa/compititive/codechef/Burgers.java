package com.dsa.compititive.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Burgers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while(n > 0) {
            String[] arr = reader.readLine().split(" ");
            int[] nums = new int[arr.length];
            for(int i = 0; i < arr.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            System.out.println(Math.min(nums[0], nums[1]));
            n--;
        }
        reader.close();
    }
}
