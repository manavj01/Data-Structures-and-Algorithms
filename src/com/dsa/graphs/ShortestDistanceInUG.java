package com.dsa.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShortestDistanceInUG {

    static class Pair {
        int edge;
        int nbr;
        int wt;

        Pair(int edge, int nbr, int wt) {
            this.edge = edge;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] parts = br.readLine().split(" ");
            int edge = Integer.parseInt(parts[0]);
            int nbr = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            Pair u = new Pair(edge, nbr, wt);
            Pair v = new Pair(nbr, edge, wt);

            adj.get(edge).add(u);
            adj.get(nbr).add(v);

        }


        System.out.println(adj.get(0).get(0).edge + "-" + adj.get(0).get(0).nbr + " @ " + adj.get(0).get(0).wt);
        System.out.println(adj.get(0).get(1).edge + "-" + adj.get(0).get(1).nbr + " @ " + adj.get(0).get(1).wt);
        System.out.println(adj.get(1).get(0).edge + "-" + adj.get(1).get(0).nbr + " @ " + adj.get(1).get(0).wt);
        System.out.println(adj.get(1).get(1).edge + "-" + adj.get(1).get(1).nbr + " @ " + adj.get(1).get(1).wt);
        System.out.println(adj.get(2).get(0).edge + "-" + adj.get(2).get(0).nbr + " @ " + adj.get(2).get(0).wt);
        System.out.println(adj.get(2).get(1).edge + "-" + adj.get(2).get(1).nbr + " @ " + adj.get(2).get(1).wt);
        System.out.println(adj);
    }
//    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
//    {
//
//    }
}
