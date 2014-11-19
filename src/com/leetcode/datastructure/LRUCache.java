package com.leetcode.datastructure;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int size;
    private int capacity;
    private Map<Integer, Integer> cache;
    private Node head;
    private Node tail;
    private Node[] nodeArr;
    private Map<Integer, Node> nodeCache;
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        System.out.println("--");
        cache.set(2, 1);
        System.out.println("--");
        System.out.println(cache.get(2));
        System.out.println("--");
        cache.set(3, 1);
        System.out.println("--");
        System.out.println(cache.get(2));
        System.out.println("--");
        System.out.println(cache.get(3));
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        nodeArr = new Node[capacity];
        nodeCache = new HashMap<>();
        
        /**
         * Using double-linked list to store status of every node in cache:
         * The more closer a node is to <i>tail</i>, the less recently used the <i>node.key</i> is in cache.
         */
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        /**
         * Initial all <i>capacity</i> Node. 
         * It improves efficiency when <i>capacity</i> is large and operation of get and set is frequently.
         */
        for (int i = 0; i < capacity; i++) {
            nodeArr[i] = new Node(-1);
        }
    }
    
    private class Node {
        int key;
        Node prev;
        Node next;
        
        public Node(int key) {
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }
    
    public int get(int key) {
        Integer value = cache.get(key);
        if (value == null) return -1;
        
        updateCache(key);
        
        return value;
    }
    
    public void set(int key, int value) {
        boolean firstInsert = false;
        Node n = nodeCache.get(key);
        if (n == null) {
            if (size < capacity) {
                n = nodeArr[size];
                firstInsert = true;
                size++;
            } else {
                n = tail.prev;
                cache.remove(n.key);
                nodeCache.remove(n.key);
            }
            n.key = key;
            nodeCache.put(key, n);
        }

        updateCache(n, firstInsert);
        
        cache.put(key, value);
    }
    
    private void updateCache(int key) {
        Node n = nodeCache.get(key);
        updateCache(n, false);
    }
    
    private void updateCache(Node n, boolean isFirstInsert) {
        if (!isFirstInsert) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        
        n.next = head.next;
        head.next.prev = n;
        n.prev = head;
        head.next = n;
    }
}
