package com.dsa.leetcode;

import java.util.Scanner;

public class StrongPasswordChecker2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String password = scn.next();
        boolean ans = strongPasswordCheckerII(password);
        System.out.println(ans);
    }

    public static boolean strongPasswordCheckerII(String password) {
//        boolean flag = false;
        String pass =" "+password;
        boolean lc = false;
        boolean uc = false;
        boolean od = false;
        boolean spch = false;
        String spc = "!@#$%^&*()-+";
        if (pass.length()>= 8) {
            for (int i = 1; i < pass.length(); i++) {
                if (pass.charAt(i) == pass.charAt(i - 1)) {
                    return false;
                } else if (pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z') {
                    lc = true;
                } else if (pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z') {
                    uc = true;
                } else if (pass.charAt(i) >= '0' && pass.charAt(i) <= '9') {
                    od = true;
                }else {
                    for (int j = 0 ; j<spc.length();j++){
                        if (spc.charAt(j) == pass.charAt(i)){
                            spch = true;
                            break;
                        }
                    }
                }
            }
        } else {
            return false;
        }


        if (lc && uc && od && spch) {
            return true;
        } else {
            return false;
        }

    }
}
