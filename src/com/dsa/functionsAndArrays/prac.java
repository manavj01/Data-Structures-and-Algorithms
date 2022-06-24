package com.dsa.functionsAndArrays;

public class prac {
    public static void main(String[] args) {
        int n1 = 101;
        int n2 = 50;

        int carry = 10;
        int larger = n1 > n2 ? n1 : n2;
        int i = 1;
        int ans = 0;
        boolean usedCarry = false;
        while (larger > 0) {
            int d1 = n1 % (int) Math.pow(10, i) - (usedCarry ? 1 : 0);
            if (usedCarry) {
                usedCarry = false;
            }
            int d2 = n2 % (int) Math.pow(10, i);

            int diff;

            if (d1 > d2) {
                diff = d1 - d2;
            } else {
                diff = (d1 + carry) - d2;
                usedCarry = true;
            }
            System.out.println(diff);
            ans = ans + diff + (int) Math.pow(10, i - 1);
            i++;
            larger = larger / 10;
            n1 = n1 / 10;
            n2 = n2 / 10;
        }
        System.out.println(ans);
    }
}
