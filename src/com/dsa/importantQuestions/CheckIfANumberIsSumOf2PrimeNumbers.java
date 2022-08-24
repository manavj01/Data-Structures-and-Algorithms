package com.dsa.importantQuestions;

public class CheckIfANumberIsSumOf2PrimeNumbers {
    public static void main(String[] args) {
        find(18);
    }

    public static void find(int num) {

        for (int i = 2; i <= num / 2; i++) {
            if (check_prime(i)) {
                if (check_prime(num - i)) {
                    System.out.println(num + " = " + (num - i) + " " + i);
                }
            }
        }
    }

    public static boolean check_prime(int n) {

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {

                return false;
            }
        }
        return true;

    }

}
