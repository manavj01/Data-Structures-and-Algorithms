package com.dsa.striver30daysSheet.d9_Recursion;

public class CheckIfAStringIsAPalindrome {
    public static void main(String[] args) {
        String str = new String("daaa");
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String str){
        return solve(str, 0,str.length()-1);
    }
    public static boolean solve(String str , int idx1, int idx2){
        if (idx1 > idx2)return true;

        if (str.charAt(idx1) != str.charAt(idx2)) {
            return false;
        }
        return solve(str,idx1+1, idx2-1);
    }
}
