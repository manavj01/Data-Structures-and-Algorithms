package com.dsa.striver30daysSheet.d14_StackAndQueues2;

import java.util.LinkedList;

public class RottingOranges {
    public static void main(String[] args) {

    }
    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int t = 0;

        LinkedList<Pair> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2 ) {
                    // System.out.println("i" +i);
                    //                     System.out.println("j" +j);

                    que.add(new Pair(i,j));
                }
            }
        }

        return solve(grid,que);
    }

    public int solve(int[][] grid,LinkedList<Pair> que) {


        int n = grid.length;
        int m = grid[0].length;

        int t = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            System.out.println(size);
            for (int s = 0; s < size; s++) {
                Pair p = que.removeFirst();
                int r = p.x;
                int c = p.y;
                // System.out.println();
                if (r + 1 < n && grid[r + 1][c] == 1) { // down
                    que.addLast(new Pair(r + 1, c));
                    System.out.println((r+1) + "down"+ c);
                    grid[r + 1][c] = 2;
                }
                if (c + 1 < m && grid[r][c + 1] == 1) { // right
                    que.add(new Pair(r, c + 1));
                    System.out.println(r + " right "+ (c+1));
                    grid[r][c + 1] = 2;

                }
                if (r - 1 >= 0 && grid[r - 1][c] == 1) { // up
                    que.add(new Pair(r - 1, c));
                    System.out.println((r-1) + " up "+ c);

                    grid[r - 1][c] = 2;
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) { // left
                    que.add(new Pair(r, c - 1));
                    System.out.println(r + " left "+ (c-1));
                    grid[r][c - 1] = 2;
                }
            }
            t++;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return Math.max(t - 1, 0);
    }
}
