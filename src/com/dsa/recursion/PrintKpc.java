package com.dsa.recursion;

import java.util.Scanner;

public class PrintKpc {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printKPC(str, "");
    }

    public static void printKPC(String str, String asf) {
        String[] codes ={".;" ,"abc","def","ghi","jkl","mno", "pqrs", "tu","vwx","yz" };

        if (str.length()==0){
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        String chofCodes = codes[ch-'0'];

        for (int i=0; i<chofCodes.length();i++){
            char cho = chofCodes.charAt(i);
            printKPC(ros,asf+cho);
        }

    }
}
