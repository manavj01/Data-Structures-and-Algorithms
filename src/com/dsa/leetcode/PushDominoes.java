package com.dsa.leetcode;

public class PushDominoes {
    public static void main(String[] args) {
        System.out.println(pushDominoes(".L.R...LR..L.."));
        System.out.println("LL.RR.LLRRLL..");
    }

    public static String pushDominoes(String dominoes) {
        final int N = dominoes.length();
        if (N <= 1) return dominoes;
        char[] res = dominoes.toCharArray();
        int i = 0;
        while (i < N) {
            if (res[i] == '.') {
                i++;
            } else if (res[i] == 'L') {  // push left
                int j = i - 1;
                while (j >= 0 && res[j] == '.') {
                    res[j--] = 'L';
                }
                i++;
            } else if (res[i] == 'R') { // res[i] == 'R'
                int j = i + 1;
                while (j < N && res[j] == '.') { // try to find 'R' or 'L' on the right side
                    j++;
                }
                if (j < N && res[j] == 'L') { // if found 'L', push left and right
                    for (int l = i + 1, r = j - 1; l < r; l++, r--) {
                        res[l] = 'R';
                        res[r] = 'L';
                    }
                    i = j + 1;
                } else {  // if no 'L', push right
                    while (i < j) {
                        res[i++] = 'R';
                    }
                }
            }
        }
        return String.valueOf(res);
    }
}
