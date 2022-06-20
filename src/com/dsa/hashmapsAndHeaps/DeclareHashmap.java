package com.dsa.hashmapsAndHeaps;

import java.util.HashMap;
import java.util.Set;

public class DeclareHashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 135);
        hm.put("Pak", 5);
        hm.put("afgh", 13);
        hm.put("Bangla", 35);
        hm.put("china", 200);

        System.out.println(hm);

        hm.put("Nigeria", 30);
        hm.put("Pak", 20);
        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("utopia"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("utopia"));


        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String key : hm.keySet()) {
            Integer val = hm.get(key);
            System.out.println(key + " " + val);
        }

    }
}
