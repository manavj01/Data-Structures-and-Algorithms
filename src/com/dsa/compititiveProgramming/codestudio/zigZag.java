package com.dsa.compititiveProgramming.codestudio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class zigZag {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] line1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(line1[0]);
            int m = Integer.parseInt(line1[1]);
//            String[] line2 = br.readLine().trim().split(" ");
//            int[] arr = new int[size];
            String str = br.readLine();

//            for (int i = 0; i < line2.length; ++i) {
//                arr[i] = Integer.parseInt(line2[i]);
//            }
            System.out.println(zigZagString(str, n, m));
        }
    }

    public static String zigZagString(String str, int n, int m) {
        StringBuilder sb = new StringBuilder();
        int a = m;
        HashSet<Integer> set = new HashSet<>();

        if (n == a || a == 1) return str;
        for (int i = 0; i < a; i++) {
            if (m == 1) {
                for (int j = i; j < n; j += (a * 2) - 2) {
                    sb.append(str.charAt(j));
                }
            } else {
                for (int j = i; j < n; j += (m * 2) - 2) {
                    char ch = str.charAt(j);
                    if(set.add(j)){
                        sb.append(ch);
                    }
                }
            }
            m--;

        }

        return sb.toString();
    }
}

//1
//9 5
//THAATWCSV