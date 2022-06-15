package com.dsa.compititive.codechef;

import java.util.Scanner;

public class DNAStorage {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        while (n > 0) {
            int len = scn.nextInt();
            String bstr = scn.next();
            String ret="";
            String p="";
            int i=0;
            int j=2;
           while (j<=len){
               ret = bstr.substring(i,j);
               p = switch (ret) {
                   case "00" -> p.concat("A");
                   case "01" -> p.concat("T");
                   case "10" -> p.concat("C");
                   default -> p.concat("G");
               };
               i+=2;
               j+=2;
           }
            System.out.println(p);
            n--;
        }
    }
}
