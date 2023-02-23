package com.dsa.striver30daysSheet.d14_StackAndQueues2;

import java.util.*;

public class LRU_Cache {
    public static class DLL {
        int data;
        DLL prev;
        DLL next;

        DLL(int data, DLL prev, DLL next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        DLL() {

        }

        DLL(int data) {
            this.data = data;
        }
    }

    HashMap<Integer, DLL> map;
    int cap;
    DLL head;
    DLL tail;

    public LRU_Cache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new DLL(-1);
        tail = new DLL(-1);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.get(key) == null) return -1;

        int val = map.get(key).data;
        DLL keyNode = map.get(key);
        putNodeInPlace(keyNode);
        return val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
//            DLL node = new DLL(value);
            if (map.size() == cap) {
                // delete node before tail;
                DLL nodePrev = tail.prev.prev;
                DLL nodeNext = tail;
                nodePrev.next = nodeNext;
                nodeNext.prev = nodePrev;

            }
            // add node after head;
            DLL headNext = head.next;
            DLL tba = new DLL(value);
            tba.next = head.next;
            headNext.prev = tba;
            tba.prev = head;
            head.next = tba;
            map.put(key,tba);

        } else {
            DLL node = map.get(key);

            // delete node
            DLL nodePrev = node.prev;
            DLL nodeNext = node.next;
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;

            // add node
            DLL headNext = head.next;
            DLL tba = new DLL(value);
            tba.next = head.next;
            headNext.prev = tba;
            tba.prev = head;
            head.next = tba;
            map.put(key,tba);
        }

    }

    public void putNodeInPlace(DLL node) {
        // removing the node
        DLL nodePrev = node.prev;
        DLL nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
        // put after head
        DLL headNext = head.next;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;

    }
}
