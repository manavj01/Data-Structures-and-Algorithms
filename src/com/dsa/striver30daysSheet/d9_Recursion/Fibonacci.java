package com.dsa.striver30daysSheet.d9_Recursion;

import com.dsa.hashmapsAndHeaps.MergeKSortedList;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }

    public static int fibonacci(int n) {
//        return solve(n , 0,1, 1); // approach 1
        if(n<=1) return 1;
        int first = fibonacci(n-1);
        int second = fibonacci(n-2);
        return first+second;
    }
    public static int solve(int n , int a , int b, int idx){
        if (idx == n){
            return b;
        }
       return solve(n,b,a+b,idx+1);
    }

}
