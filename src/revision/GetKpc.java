package revision;

import java.io.*;
import java.util.*;

public class GetKpc {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> res = new ArrayList<String>();

        res = getKPC(str);
        System.out.println(res);

    }

    // 0 -> .; 1- abc 2 def 3 ghi 4 jkl 5 mno 6 pqrs 7 tu 8 vwx 9 yz
    public static ArrayList<String> getKPC(String str) {
        String[] kpad = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = getKPC(ros);
        ArrayList<String> mres = new ArrayList<>();

        String res = kpad[ch - '0'];

        for (int i = 0; i < res.length(); i++) {
            char chcode = res.charAt(i);
            for (String rrs : rres) {
                mres.add(chcode + rrs);
            }
        }
        return mres;
    }

}
