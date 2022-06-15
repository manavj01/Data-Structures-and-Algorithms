package com.dsa.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.dsa.tree.GenericTree.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        GenericTree.Node root = construct(arr);
//        int sz = size(root);
//        int m = max(root);
//        int h = height(root);
//         display(root);
//        System.out.println(h);
//        traversals(root);
//        levelOrder(root);
//        levelOrderLinewise(root);
//        levelOrderLinewise2(root);
//        levelOrderLinewise3(root);
//        levelOrderLinewise4(root);
//        levelOrderLinewiseZZ(root);
//        display(root);
//        mirror(root);
//        removeLeaves(root);
        linearize(root);
        display(root);
    }

}
