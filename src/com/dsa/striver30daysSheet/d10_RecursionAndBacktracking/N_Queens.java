package com.dsa.striver30daysSheet.d10_RecursionAndBacktracking;

import java.util.*;


public class N_Queens {

    public static void main(String[] args) {
        System.out.println(new N_Queens().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] a : board) Arrays.fill(a, '.');
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    public void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;

                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens1(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] c : board) Arrays.fill(c, '.');
        solve1(res, board, 0, n);
        return res;
    }

    public void solve1(List<List<String>> res, char[][] board, int col, int n) {
        if (col == n) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isQueenSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                solve1(res, board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }

    public boolean isQueenSafe(int row, int col, int n, char[][] board) {

        int dRow = row;
        int dCol = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dRow;
        col = dCol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;

            col--;
        }
//        row = dRow;
        col = dCol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] c : board) {
            String s = new String(c);
            res.add(s);
        }
        return res;
    }
}
