package com.dsa.recursion;

import java.util.*;

public class GetSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }
    // bc -> [--, -c, b-, bc]
    // abc -> [---,--c,-b-,-bc,a--,ab-,abc]
    public static ArrayList<String> gss(String str) {
        if(str.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0); //a
        String ros = str.substring(1); //bc
        ArrayList<String> rres = gss(ros); //[--,-c,b-,bc]

        ArrayList<String> mres = new ArrayList<>();
        for (String rstr : rres) {
          mres.add(""+rstr);
        }
        for (String rstr: rres) {
            mres.add(ch+rstr);
        }
        return mres;
    }
}
