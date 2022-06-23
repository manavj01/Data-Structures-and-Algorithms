package com.dsa.compititive.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AirHockey {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            int[] nums = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                nums[j] = Integer.parseInt(arr[j]);
            }

            System.out.println(7 - Math.max(nums[0], nums[1]));
        }
    }
}
