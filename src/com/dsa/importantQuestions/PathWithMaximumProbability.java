package com.dsa.importantQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{0, 2},
        };

        int start = 0;
        int end = 2;
        double[] succProb = {0.5, 0.5, 0.3};

        double ans = maxProbability(V, edges, succProb, start, end);
        System.out.println(ans);
    }

    static class Pair implements Comparator<Pair> {
        int vertex;
        double probab;

        Pair() {
        }

        Pair(int vertex, double probab) {
            this.vertex = vertex;
            this.probab = probab;
        }

        int getV() {
            return vertex;
        }

        double getP() {
            return probab;
        }

        public int compare(Pair p1, Pair p2) {
            if (p1.probab > p2.probab) {
                return -1;
            } else if (p1.probab < p2.probab) {
                return 1;
            } else return 0;
        }
    }

    public static double maxProbability(int V, int[][] edges, double[] succProb, int S, int end) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));

        }
        System.out.println(adj.get(0).get(0).getV() + " @ " + adj.get(0).get(0).getP() + " , " + adj.get(0).get(1).getV() + " @ " + adj.get(0).get(1).getP());
        System.out.println(adj.get(1).get(0).getV() + " @ " + adj.get(1).get(0).getP() + " , " + adj.get(1).get(1).getV() + " @ " + adj.get(1).get(1).getP());
        System.out.println(adj.get(2).get(0).getV() + " @ " + adj.get(2).get(0).getP() + " , " + adj.get(2).get(1).getV() + " @ " + adj.get(2).get(1).getP());

        HashSet<Integer> pst = new HashSet<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>(V, new Pair());

        pq.offer(new Pair(S, 1.0));

        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            int vtx = node.getV();
            double pb = node.getP();

            pst.add(vtx);

            if (vtx == end) return pb;

            if (adj.get(vtx) != null) {
                for (Pair it : adj.get(vtx)) {
                    if (pst.contains(it.getV()) == false) {
                        pq.add(new Pair(it.getV(), pb * it.getP()));
                    }
                }
            }
        }


        return 0d;
    }
}
