package com.dsa.compititive.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaitingTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (n > 0) {
            String[] arr = br.readLine().split(" ");
            int[] nums = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }

            int wToDays = nums[0] * 7;
            int days = nums[1];

            int daysLeft = wToDays - days;
            System.out.println(daysLeft);


            n--;
        }
    }
}
