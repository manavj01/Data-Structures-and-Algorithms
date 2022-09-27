package com.dsa.striver30daysSheet.d15_String;

public class RepeatedStringMatch {
    public static void main(String[] args) {
//        String a = "abcd";
       String a = "aaaaaaaaaaaaaaaaaaaaaab";
        String b = "ba";
//        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }

    public static int repeatedStringMatch(String a, String b) {
        StringBuilder str = new StringBuilder(a);
        int c = 1;
        int chck = -1;
        while (str.length() < b.length() * 100) {
            chck = str.indexOf(b);
            if (chck == -1) {
                c++;
                str.append(a);
            } else {
                break;
            }
        }

        return chck != -1 ? c : chck;
    }
}
