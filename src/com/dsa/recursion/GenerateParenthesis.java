package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        solve(n, 0, res, "");

        return res;
    }
    public static void solve(int i, int j, List<String> res, String sb) {

        if (i == 0 && j == 0) {
            res.add(sb);
            return;
        }

        if (j > 0){
            solve(i, j - 1, res, sb + ')');
        }
        if (i > 0) {
            solve(i - 1, j+1, res, sb+'(');
        }
    }
}
