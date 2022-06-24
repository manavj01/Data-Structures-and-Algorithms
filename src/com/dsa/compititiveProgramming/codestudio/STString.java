package com.dsa.compititiveProgramming.codestudio;

import java.util.Scanner;

public class STString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//        String str = scn.next();
//        int ans = isSTString(str);
        int n = scn.nextInt();
        int[] arr = {3, 2, 1};
        int ans = samePlace(n, arr);
        System.out.println(ans);

    }

    public static int samePlace(int n, int[] arr) {
        int[] narr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = 0;
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        int c = 0;
        for (int i = 0; i < narr.length; i++) {
            if (narr[i] == arr[i]) {
                c++;
            }
        }

        return c;
    }

    static int isSTString(String a) {
        String str = a;
        boolean flag = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != 'S' && ch != 't') {

            }
        }
        return 1;
    }
}
