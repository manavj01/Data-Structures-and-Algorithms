package com.dsa.stringstringbuilderarraylist;

import java.util.Scanner;

public class StringDeclare {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

//        String s2 = scn.next();
//        String s3 = scn.next();
//        String s4 = scn.nextLine();
//        System.out.println(s2 + s3);
//        scn.close();

//        for (int i = 0; i <= s1.length(); i++) {
//            for (int j = i; j <= s1.length(); j++) {
//                System.out.println(s1.substring(i,j));
//            }
//        }
        String s1 = "abcd";
        s1 += " ";
        s1 += 'w';
        s1 += 'o';
        s1 += 10;


        System.out.println(10 + 20 + s1);

        System.out.println(s1 + 10 + 20);


    }
}
