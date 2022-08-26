package com.dsa.striver30daysSheet.d8_GreedyAlgo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int N = 3;
        int W = 50;
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        Item[] items = new Item[]{new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        System.out.println(fractionalKnapsack(W, items, N));
    }

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    public static class ItemComparator implements Comparator<Item> {
        public int compare(Item a, Item b) {
            return Double.compare((double) b.value / b.weight, (double) a.value / a.weight);
        }
    }

    public static double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, new ItemComparator());
        double val = 0;
        int weigh = 0;
        for (int i = 0; i < n; i++) {
            if (weigh + arr[i].weight <= W) {
                val += arr[i].value;
                weigh += arr[i].weight;
            } else {
                int remain = W - weigh;
                val += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }

        return val;
    }
}

//        for (int i = 0; i < n; i++) {
//        System.out.println(arr[i].value + "-" + arr[i].weight);
//        }