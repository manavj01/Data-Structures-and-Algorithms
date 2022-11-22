package com.dsa.striver30daysSheet.d15_String;

public class ExtractNumbersFromStringAndAdd {
    public static void main(String[] args) {
        String st = "abcd_12_defg_34_hjs_21";
        System.out.println(solve(st));
    }

    public static int solve(String st) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < st.length(); i++) {
            if (Character.isDigit(st.charAt(i))) {
                while (i != st.length() &&Character.isDigit(st.charAt(i)) ) {
                    sb.append(st.charAt(i));
                    i++;
                }
                sum += convertStringToInteger(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (!sb.isEmpty()) sum += convertStringToInteger(sb.toString());

        return sum;
    }
    public static int convertStringToInteger(String s){
        int num =0;
        for (int i=0; i<s.length(); i++){
            num = num*10 + s.charAt(i)-'0';
        }
        return num;
    }
}
