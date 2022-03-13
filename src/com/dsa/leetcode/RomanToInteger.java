package com.dsa.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        RomanToInteger rti = new RomanToInteger();
        int roman = rti.romanToInt(s);
        System.out.println(roman);
    }

    public int romanToInt(String s){
        Map<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V',5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C',100);
        roman.put('D', 500);
        roman.put('M',1000);

        int i=0,sum=0;
        int n = s.length();
        while(i<n){

            if(i==n-1){
                sum=sum+ roman.get(s.charAt(i));
                break;
            }
            if(roman.get(s.charAt(i))>= roman.get(s.charAt(i+1))){
                sum=sum+ roman.get(s.charAt(i));
                i++;
            } else{
                sum = sum+ roman.get(s.charAt(i+1))- roman.get(s.charAt(i));
                i=i+2;
            }
        }
        return sum;
    }
}
