package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class GetKpc {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> result = getKPC(str);
        System.out.println(result);
    }
    static String[] codes ={".,","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str){

        if(str.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        //678
        char ch=str.charAt(0); //6
        String ros = str.substring(1); //78

        ArrayList<String> rres = getKPC(ros); // 6 words of 78

        ArrayList<String> mres = new ArrayList<>();

        String chOfCodes = codes[ch-'0'];

        for (int i=0; i<chOfCodes.length();i++){
            char chcode= chOfCodes.charAt(i);
            for (String rstr: rres) {
                mres.add(chcode+rstr);
            }
        }

        return mres;

    }
}
