package com.dsa.leetcode;

public class PalindromeNumber {
    public static void main(String[] args){
        PalindromeNumber pn = new PalindromeNumber();
        boolean b= pn.isPalindrome(100);
        System.out.println(b);
    }

    public  boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        if(sb.length()==1){
            return true;
        }
        if(x<0){
            return false;
        }
        int i=0;
        int j=sb.length()-1;
        while (i<j){
            if(sb.charAt(i)!=sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
