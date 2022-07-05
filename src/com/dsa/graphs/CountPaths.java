package com.dsa.graphs;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class CountPaths {
    public static class Edge {

        int node;
        int dist;

        Edge() {
        }

        Edge(int nbr, int dist) {

            this.node = nbr;
            this.dist = dist;
        }

//        public int compare(Edge e1, Edge e2) {
//            return Integer.compare(e1.dist, e2.dist);
//        }

    }

    public static void main(String[] args) throws IOException {
        int[][] roads = new int[][]{
                new int[]{0, 6, 7},
                new int[]{0, 1, 2},
                new int[]{1, 2, 3},
                new int[]{1, 3, 3},
                new int[]{6, 3, 3},
                new int[]{3, 5, 1},
                new int[]{6, 5, 1},
                new int[]{2, 5, 1},
                new int[]{0, 4, 5},
                new int[]{4, 6, 2},
//                new int[]{1, 0, 10}
        };
        int V = 7;
        System.out.println(countPaths(V, roads));
    }


    public static int countPaths(int n, int[][] roads) {
        int mod = (int) Math.pow(10, 9) + 7;

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] it : roads) {
            int from = it[0];
            int to = it[1];
            int dis = it[2];

            adj.get(from).add(new Edge(to, dis));
            adj.get(to).add(new Edge(from, dis));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((aa, bb) -> aa.dist - bb.dist);
        pq.add(new Edge(0, 0));

        long[] ways = new long[n];
        ways[0] = 1;

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while (!pq.isEmpty()) {
            Edge p = pq.poll();
            int node = p.node;
            int dis = p.dist;

            for (Edge it : adj.get(node)) {
                if ((dis + it.dist) < distance[it.node]) {
                    ways[it.node] = ways[node];
                    distance[it.node] = dis + it.dist;
                    pq.add(new Edge(it.node, distance[it.node]));
                } else if ((dis + it.dist) == distance[it.node]) {
                    ways[it.node] = ways[it.node] + ways[node];
                    ways[it.node] = ways[it.node] % mod;
                }
            }
        }

        return (int) ways[n - 1];
    }

}
