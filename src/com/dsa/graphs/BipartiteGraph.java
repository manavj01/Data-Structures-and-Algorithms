package com.dsa.graphs;

import java.io.IOException;

public class BipartiteGraph {

    public static void main(String[] args) throws IOException {
        int[][] graph = new int[][]{
                new int[]{1,2,3},
                new int[]{0,2},
                new int[]{0,1,3},
                new int[]{0,2},
        };

        boolean ans = isBipartite(graph);

    }

    public static boolean isBipartite(int[][] graph){


        return false;
    }
}
