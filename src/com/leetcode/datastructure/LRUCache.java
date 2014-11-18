package com.leetcode.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
    private int size;
    private int capacity;
    private Map<Integer, Integer> cache;
    private List<Integer> lruList;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        lruList = new ArrayList<>();
    }
    
    public int get(int key) {
        Integer value = cache.get(key);
        if (value == null) return -1;
        
        lruList.remove(new Integer(key));
        lruList.add(key);
        
        return value;
    }
    
    public void set(int key, int value) {
        if (cache.get(key) != null) {
            lruList.remove(new Integer(key));
        } else {
            if (size >= capacity) {
                cache.remove(lruList.get(0));
                lruList.remove(0);
            } else {
                size++;
            }
        }
        cache.put(key, value);
        lruList.add(key);
    }
}
