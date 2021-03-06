package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        List<ListNode> testCase = getTestCase();
        
        long start = System.currentTimeMillis();
        
        for (ListNode tc : testCase) {
            tc.printList();
            ListNode ln = solution.sortList(tc);
            ln.printList();
        }
        
        long end = System.currentTimeMillis();
        
        System.out.printf("time cost: %dms", end - start);
    }
    
    public static List getTestCase() {
        List<ListNode> testCase = new ArrayList<>();
        int[] node1 = {3, 4, 6, 5, 1, 2},
                node2 = {4,19,14,5,-3,1,8,5,11,15},
                node3 = {1,3,3,1,3,2,2,1,1,1,3},
                node4 = {1,3,3,1,3,1,3,3,2,3,2,2,1,1,1,3,2,2,1,1,2,2,2,3,3,1,1,2,2,2,1,2,1,1,2,3,3,2,2,3,2,3,2,2,2,1,1,3,2,3,3,1,1,1,2,2,1,2,2,2,2,3,1,3,1,1,1,2,1,2,2,2,1,3,2,2,2,3,3,2,3,3,1,1,2,2,1,2,1,3,2,1,3,3,1,2,1,1,1,1,1,2,1,2,2,2,2,3,3,3,1,1,3,2,1,1,2,1,3,3,2,2,1,3,1,3,1,3,2,2,3,2,3,2,2,1,2,3,1,3,1,2,3,3,2,3,3,3,1,1,2,3,1,2,3,2,1,1,2,3,1,1,3,1,2,2,3,2,1,3,1,2,1,3,2,1,1,2,2,2,1,3,1,3,2,3,3,1,1,3,1,2,1,2,3,1,2,1,1,3,1,3,3,1,1,1,2,2,1,3,1,2,2,3,2,1,3,2,1,3,2,2,3,3,2,2,1,3,2,2,2,2,2,3,2,2,3,1,3,2,1,3,2,1,2,3,3,3,1,2,2,3,1,1,2,2,3,2,1,1,1,1,1,3,2,2,2,1,3,2,1,2,3,2,1,1,2,1,3,3,1,3,1,2,2,1,2,3,2,3,3,1,2,3,2,2,3,3,2,1,3,2,2,2,3,3,3,1,1,2,1,1,2,3,3,3,1,3,2,2,1,2,2,1,2,3,1,3,2,2,3,3,3,1,2,3,2,1,3,1,1,2,2,1,1,1,2,2,3,1,3,1,2,3,3,3,2,2,3,1,1,1,3,2,1,1,3,1,2,3,3,3,2,1,2,3,2,3,2,1,3,2,2,2,2,1,1,3,1,1,1,3,2,2,2,1,2,3,2,3,2,2,1,2,3,2,1,1,3,1,3,3,1,1,1,1,1,2,3,3,3,1,3,2,2,3,1,1,3,1,1,1,3,1,1,2,2,2,1,1,1,1,2,1,3,3,3,1,2,2,2,2,3,3,1,2,2,3,1,3,1,2,1,2,2,3,3,1,3,3,2,1,3,1,1,3,1,2,3,3,3,3,1,1,3,3,3,3,2,2,2,1,1,3,2,2,2,3,1,3,3,3,1,1,3,1,3,2,3,1,2,3,2,2,3,3,3,1,2,1,2,1,2,3,1,2,2,2,1,1,1,2,2,1,2,1,1,1,3,2,1,2,3,2,2,2,1,2,3,2,2,1,3,3,3,1,2,3,3,1,1,3,3,1,1,2,1,2,3,1,2,3,2,2,3,2,1,3,1,3,1,2,2,2,2,1,2,3,3,2,2,2,3,2,2,1,2,2,3,1,3,1,1,1,2,3,3,2,2,3,3,2,3,1,1,2,2,2,3,2,2,1,1,3,2,2,3,3,3,3,1,2,3,3,1,3,3,1,2,2,1,3,2,3,3,2,3,2,1,2,1,2,2,3,3,2,3,3,1,1,2,1,3,2,2,3,1,2,1,3,1,1,3,3,3,3,2,3,3,3,1,3,2,2,2,3,3,1,2,1,2,3,2,2,2,2,3,3,1,1,3,3,2,1,3,2,2,3,2,3,2,2,2,3,1,2,1,3,2,2,1,2,2,3,2,2,2,2,2,1,1,2,1,3,3,2,2,2,1,3,3,3,3,2,3,3,2,3,3,1,3,3,1,3,2,2,2,2,2,1,2,2,3,3,3,1,2,3,1,3,2,2,2,2,3,1,1,1,3,2,3,3,2,3,1,2,1,2,2,1,2,2,3,3,1,2,3,2,2,3,3,1,1,1,2,1,2,3,3,2,2,2,2,3,1,1,1,3,3,1,1,1,3,3,3,2,3,3,1,1,1,2,3,2,2,2,2,1,2,2,3,1,3,1,2,3,1,3,3,1,2,3,2,2,3,3,1,1,2,1,2,3,3,3,2,1,2,1,2,3,1,2,2,1,2,2,2,1,2,3,3,3,3,1,2,1,3,1,1,2,1,3,1,3,2,3,2,3,3,1,2,2,2,3,3,2,1,1,3,1,2,1,3,1,2,1,2,2,2,1,3,1,1,2,2,1,2,1,2,3,3,1,1,3,1,1,1,2,2,3,1,3,3,3,3,2,2,1,3,2,3,2,2,1,3,3,2,1,2,1,2,2,3,1,2,2,1,2,2,3,1,3,3,2,3,1,1,1,3,3,3,3,3,3,1,1,1,3,3,2,2,1,1,3,2,2,2,3,3,3,1,2,2,1,1,3,3,3,2,2,2,2,3,1,2,1,2,2,3,3,3,2,2,2,1,1,1,3,1,1,1,1,1,1,1,2,3,1,3,1,1,3,1,2,1,3,2,2,3,1,2,3,3,2,3,1,1,2,2,3,3,2,2,1,2,2,1,2,2,1,2,1,3,2,1,2,3,1,1,2,3,2,2,2,3,2,3,3,1,1,1,3,3,1,1,2,1,1,1,2,3,3,2,3,3,3,1,2,3,2,2,2,2,2,2,2,1,1,2,2,1,3,1,1,2,3,1,2,3,2,1,2,2,1,3,3,2,2,1,2,1,3,1,3,2,1,1,3,2,3,1,1,2,3,1,1,1,3,2,2,3,2,3,1,2,2,3,1,3,2,1,1,3,2,2,1,3,2,1,2,3,3,1,3,3,3,1,1,2,1,1,2,3,3,2,2,3,2,1,1,2,3,1,1,3,2,3,2,1,2,3,2,1,1,1,1,3,2,3,2,3,1,3,2,1,3,1,3,3,2,2,3,2,3,1,3,2,1,2,2,2,3,3,2,1,2,3,1,1,3,1,2,2,2,3,2,3,1,1,2,1,1,3,1,3,2,1,1,1,3,1,1,3,3,3,3,1,2,3,2,3,2,1,2,1,3,1,3,1,2,2,3,2,3,2,3,3,3,3,1,1,2,2,3,1,1,3,2,1,1,2,1,2,1,1,1,1,1,1,2,3,3,3,3,2,3,1,2,3,3,1,1,3,1,1,1,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1,3,3,1,2,2,1,2,1,1,1,1,2,2,3,2,2,2,3,1,3,1,2,2,2,3,3,3,2,1,2,1,1,3,3,2,3,1,2,1,2,2,3,2,3,3,3,3,1,1,1,1,1,1,2,3,1,1,3,1,3,2,3,1,1,1,2,1,1,2,2,2,3,2,2,2,1,3,1,1,1,1,2,3,2,3,2,2,1,3,1,2,1,2,1,2,2,3,1,2,3,3,2,1,1,3,2,3,1,3,1,1,1,2,3,2,1,3,3,1,3,3,3,3,2,2,3,3,1,3,2,2,3,3,2,3,3,3,1,1,2,2,2,2,1,3,3,1,3,2,2,3,1,2,1,1,3,1,1,2,1,1,3,1,1,3,2,2,2,2,2,3,2,1,3,3,2,1,1,2,2,3,2,1,2,1,2,1,2,1,1,1,3,2,2,2,1,3,3,2,3,2,1,1,3,3,1,3,1,3,3,3,3,3,3,3,3,3,2,3,2,2,2,2,2,2,1,1,1,2,3,1,2,2,2,3,1,2,2,1,2,2,1,1,2,3,1,2,2,2,3,3,1,1,3,2,3,2,2,3,1,2,1,1,1,2,3,3,1,1,2,1,2,3,3,2,2,3,1,3,3,3,3,1,1,3,2,2,3,2,1,3,1,3,2,1,2,1,2,1,3,2,3,1,3,2,2,3,3,3,1,2,3,3,1,1,2,1,2,1,3,2,1,1,1,2,2,2,2,2,1,2,1,3,2,1,2,2,1,1,2,3,3,1,3,2,2,3,3,2,1,3,2,1,3,3,2,2,1,3,2,1,3,2,3,2,2,1,2,1,1,3,1,1,3,3,3,3,1,2,3,3,3,3,2,3,2,3,3,3,3,1,1,2,2,1,2,2,2,3,2,1,2,1,2,3,1,1,1,3,1,2,3,2,3,2,2,2,3,1,2,3,2,1,1,1,1,1,2,3,1,3,2,2,3,3,3,2,1,2,2,1,3,2,2,1,2,3,1,3,3,1,3,3,2,2,1,1,2,3,1,1,3,3,1,3,3,3,3,2,3,1,2,2,1,1,1,1,1,3,1,3,2,3,2,1,2,2,1,2,3,2,1,1,3,2,3,2,3,3,1,2,1,2,3,3,2,3,3,2,3,2,3,3,3,1,2,3,2,1,2,3,2,2,1,3,3,3,1,2,3,3,1,2,1,1,2,1,2,1,2,2,3,3,2,1,3,1,1,1,2,2,1,3,3,1,1,2,2,3,2,3,2,3,3,1,3,1,2,3,3,1,2,2,1,1,2,1,1,3,3,2,3,3,1,2,3,3,2,2,3,1,2,3,3,3,3,1,2,3,1,2,2,1,1,3,1,2,3,3,1,2,2,1,3,2,3,2,1,2,1,3,2,3,1,1,1,2,3,1,3,2,2,2,2,2,3,1,2,2,1,2,2,3,2,2,1,3,1,2,2,2,1,2,3,1,1,3,2,3,2,3,3,2,1,3,2,1,3,2,2,3,1,1,3,3,1,2,3,2,1,3,3,3,3,1,1,3,1,3,2,2,3,3,1,3,1,1,2,1,1,3,1,1,2,3,3,1,1,3,2,2,3,3,3,3,2,2,2,2,3,2,1,3,1,2,1,3,3,1,3,3,2,2,2,3,1,3,1,2,2,2,3,1,3,3,1,3,3,2,3,1,1,2,2,2,2,3,1,1,2,3,1,1,3,1,3,1,1,3,3,2,2,1,3,2,2,2,2,3,1,1,1,2,1,1,1,2,2,3,2,1,2,1,1,2,3,2,1,1,1,2,2,3,3,1,3,1,2,2,1,2,2,1,1,1,1,2,1,1,1,1,3,2,3,1,3,3,1,3,1,2,1,1,1,2,3,3,2,1,1,3,2,3,2,3,3,2,3,3,2,2,1,3,2,2,2,3,2,1,1,3,2,1,2,2,1,1,2,1,2,3,2,1,3,2,2,2,3,1,3,2,1,3,2,1,1,1,3,1,1,1,2,2,2,2,2,3,2,3,1,3,1,3,3,2,3,3,2,3,3,3,2,2,3,3,3,1,3,2,1,1,3,2,3,3,2,2,3,1,1,1,2,3,1,3,3,3,3,1,1,3,3,3,1,1,2,1,2,3,2,1,3,1,1,3,3,3,2,3,1,2,2,2,2,1,2,3,3,3,2,1,3,2,1,3,3,3,1,2,3,3,2,1,1,3,1,1,3,1,3,2,3,1,3,2,2,3,2,3,3,2,1,2,3,1,1,1,3,3,3,3,1,2,2,1,3,2,1,3,3,1,1,2,2,1,1,1,2,1,3,2,1,2,3,2,1,1,3,2,2,3,1,1,1,2,2,2,2,3,2,1,3,3,2,3,2,3,2,3,1,1,3,2,1,2,3,1,2,2,1,3,3,2,2,1,3,3,1,3,1,1,3,2,3,2,2,1,2,2,3,2,2,1,3,1,2,1,3,2,1,3,1,3,2,3,2,2,2,1,3,1,1,2,2,3,2,1,2,1,2,3,1,1,3,1,3,2,3,1,1,1,3,1,2,1,3,1,1,2,2,1,2,1,1,2,1,3,1,2,2,2,2,2,1,2,3,2,1,3,1,2,1,2,2,2,1,1,1,2,3,1,1,3,2,3,2,2,2,2,2,2,2,1,2,2,3,3,3,2,1,1,1,3,2,2,3,2,2,1,2,2,2,3,3,3,1,3,3,2,3,1,2,3,1,3,2,1,1,2,1,1,2,1,1,3,3,2,2,3,2,1,2,3,2,1,3,1,2,3,1,3,3,3,2,1,2,2,1,1,1,3,3,2,1,1,1,3,1,2,1,2,2,3,2,3,3,3,2,3,3,1,2,3,2,1,1,1,2,3,1,2,3,1,2,3,1,3,1,3,1,2,2,1,1,3,1,1,3,1,2,3,2,1,3,3,2,2,2,2,2,3,3,2,1,1,1,2,2,3,2,3,3,2,3,1,3,2,2,2,1,2,2,2,2,3,2,1,1,2,2,3,3,2,1,2,3,2,2,3,2,3,2,3,3,1,3,3,3,2,3,1,2,3,3,2,3,1,2,2,1,1,3,3,2,3,2,1,3,2,3,3,1,3,1,2,3,1,2,2,2,3,3,2,1,3,1,3,2,2,3,2,2,2,2,2,2,2,3,3,1,3,2,3,2,1,1,2,1,2,1,1,2,2,3,3,2,1,1,1,3,3,2,1,1,3,1,3,1,3,3,2,2,2,3,1,1,2,3,3,1,2,2,2,1,3,3,1,3,3,1,2,3,3,2,3,3,2,1,3,1,2,1,3,1,1,1,3,3,2,1,1,1,2,2,3,3,2,3,3,1,3,2,3,3,3,2,2,1,2,3,2,3,3,2,2,2,1,2,3,3,3,2,3,3,1,1,3,3,1,2,1,3,3,3,1,3,3,3,2,1,3,3,1,3,2,3,1,2,1,3,3,3,3,1,3,3,1,1,3,2,3,2,1,3,1,1,2,2,1,1,3,1,3,1,3,1,2,2,2,2,3,2,1,3,3,1,2,3,2,3,2,3,1,2,2,2,2,3,1,1,1,3,2,2,3,1,2,2,3,3,2,1,2,1,3,2,1,3,2,1,3,1,1,2,1,2,3,2,3,1,1,2,3,1,1,2,2,2,2,3,2,2,1,2,1,2,1,1,1,1,1,3,1,1,3,3,3,1,3,2,3,3,1,2,1,2,2,3,1,3,3,1,3,3,3,1,1,2,2,3,2,2,3,2,1,3,3,3,3,3,2,1,2,2,3,1,1,1,1,1,3,3,2,3,3,3,2,3,2,1,2,3,2,2,1,2,2,1,2,3,3,1,3,3,2,1,1,1,2,3,2,3,1,3,2,2,3,1,1,2,1,3,2,2,2,2,1,2,2,1,1,2,1,1,2,1,1,2,2,3,2,2,2,1,2,3,2,3,2,3,2,1,2,3,3,3,1,1,2,1,3,1,2,1,1,3,3,1,1,3,2,2,1,3,2,2,2,2,1,3,2,2,2,2,2,3,2,3,2,3,3,3,1,3,3,1,1,3,1,2,2,1,1,2,3,2,3,2,1,3,1,2,3,2,3,3,3,2,1,2,1,3,2,2,1,2,3,3,1,2,2,1,3,3,3,3,1,3,3,2,2,3,2,1,3,2,2,1,3,1,3,2,1,2,3,1,3,3,1,2,2,3,1,1,3,3,1,3,3,3,1,1,1,2,3,3,2,3,3,1,2,1,2,3,3,2,2,3,3,3,3,2,2,3,3,3,1,1,1,1,1,1,2,3,2,2,1,2,1,3,1,2,3,3,1,1,3,1,2,2,1,1,1,2,1,3,3,1,1,1,3,2,1,3,2,2,3,3,2,2,1,1,3,1,2,2,2,1,2,1,2,2,1,3,3,1,2,3,3,3,1,3,3,1,3,3,2,2,2,3,2,2,3,1,3,2,1,3,2,2,1,1,1,2,2,2,1,1,3,1,3,3,2,2,1,2,2,3,3,2,2,2,2,1,1,2,3,1,3,3,2,3,2,3,1,2,2,2,2,2,3,3,2,1,2,2,3,2,3,2,2,1,1,1,2,2,3,1,3,1,2,3,2,1,3,3,1,1,2,3,3,2,1,3,1,2,2,3,1,1,1,3,2,3,1,3,1,3,2,2,3,3,3,2,3,3,3,2,3,3,2,2,1,2,1,3,3,1,1,3,3,2,2,3,2,1,2,3,1,1,2,3,2,1,2,3,1,1,3,1,3,1,3,2,2,1,2,1,2,2,1,2,3,3,1,3,2,2,1,2,2,3,3,3,1,2,1,2,2,3,1,3,1,2,1,3,1,2,1,2,2,1,2,3,3,1,3,3,1,3,2,1,2,3,3,3,3,3,1,2,1,2,2,3,1,2,3,1,3,3,1,1,2,1,1,1,3,2,1,3,3,1,3,2,1,2,1,1,1,1,2,1,3,1,2,1,1,3,2,1,1,2,3,1,1,3,3,3,1,1,2,2,3,1,2,1,3,2,3,3,3,3,1,1,3,3,3,1,2,3,3,3,3,3,1,3,2,2,1,3,1,3,1,3,2,1,1,1,1,1,3,1,1,2,1,2,2,2,3,3,2,3,2,3,2,3,3,1,2,2,3,2,2,1,3,3,3,2,3,1,3,3,2,2,1,2,3,2,3,3,2,1,1,3,1,2,2,2,1,2,1,1,2,2,2,1,2,1,3,1,3,3,1,2,2,3,1,3,1,2,1,2,1,3,3,1,3,2,3,2,1,1,3,2,1,1,2,2,2,1,3,3,3,1,3,3,2,3,3,1,2,3,2,3,2,2,1,2,2,3,1,3,2,3,1,2,2,1,3,3,3,2,2,3,2,2,2,1,3,3,1,1,1,2,3,1,2,3,1,1,1,1,3,3,1,1,3,1,1,3,1,1,1,2,2,1,1,1,1,2,1,1,2,3,1,2,1,2,2,2,3,2,1,1,1,1,2,2,3,2,3,1,1,3,3,2,2,1,2,1,1,1,2,2,2,2,3,2,3,3,2,2,1,1,3,1,3,2,1,2,2,2,3,1,2,1,3,1,3,3,3,1,2,1,1,2,3,2,3,2,3,3,1,3,3,3,2,2,3,3,3,3,3,3,3,2,1,1,3,1,1,3,2,1,2,3,2,3,2,3,3,1,2,3,2,3,2,1,2,3,3,2,3,1,2,1,2,1,2,1,2,3,2,2,2,3,1,2,3,3,1,1,1,3,2,2,3,1,3,2,3,1,2,1,1,2,3,3,3,1,1,1,3,2,1,2,1,2,3,3,3,3,1,1,1,3,2,2,2,3,1,2,1,2,3,1,2,1,2,1,3,1,1,1,2,1,1,3,2,2,3,1,3,1,1,3,3,1,3,1,3,2,2,3,1,2,3,3,3,3,2,2,1,1,3,2,1,3,1,1,2,3,2,2,2,2,3,1,2,2,1,1,2,2,2,1,1,2,3,1,2,2,1,2,3,3,2,1,2,2,1,3,2,1,3,2,1,3,2,3,2,3,1,2,2,2,1,2,3,1,2,2,1,1,1,3,2,3,2,3,3,1,3,3,3,1,3,1,1,1,2,1,3,2,3,1,1,1,1,2,2,3,3,1,1,3,1,3,2,1,2,2,2,1,2,3,1,1,2,3,2,3,3,1,3,2,1,2,2,3,3,1,3,2,2,2,1,1,2,2,2,3,1,3,2,1,3,3,2,3,3,3,2,2,3,2,1,3,2,2,2,3,2,1,2,2,3,2,2,2,3,2,3,1,2,1,1,1,3,1,2,2,2,1,3,1,2,3,1,2,1,1,1,1,3,3,2,2,1,3,2,2,2,3,1,3,3,2,2,2,3,2,3,1,2,2,2,3,2,3,2,2,3,2,3,1,3,1,2,2,3,2,1,1,1,2,3,1,2,3,1,3,1,1,3,1,2,1,1,3,1,2,3,2,1,3,3,3,1,1,2,3,3,1,2,1,2,3,3,3,1,1,2,1,3,2,3,3,3,3,2,3,3,1,1,2,2,3,1,3,2,3,1,2,3,3,2,2,1,2,3,2,1,2,2,2,2,3,2,2,2,1,2,3,3,1,1,2,3,2,2,3,3,3,1,3,2,2,2,1,1,3,2,1,1,1,3,2,1,2,1,2,2,1,2,3,1,2,2,1,1,3,1,2,3,3,3,1,1,3,1,3,3,1,3,2,2,3,1,3,3,3,3,3,3,1,3,2,1,2,3,2,2,2,2,3,3,1,2,3,1,3,3,3,2,2,3,1,3,1,2,2,1,1,2,1,2,1,3,3,2,1,3,1,1,2,1,2,3,1,2,2,2,3,3,3,1,1,1,1,3,2,1,2,2,3,1,3,3,2,2,2,2,1,2,3,1,3,3,2,2,3,1,2,3,2,3,2,1,2,3,2,3,3,1,3,1,2,3,2,3,3,1,1,3,3,3,1,3,1,2,2,3,1,3,1,1,3,1,1,3,3,3,2,2,1,1,3,2,1,2,3,2,3,3,2,1,2,2,1,3,3,2,3,2,3,2,2,3,2,1,1,2,2,1,3,3,3,3,2,3,1,3,1,1,1,3,3,2,1,3,1,3,2,1,3,2,1,3,3,1,3,1,3,3,1,2,2,2,3,1,3,2,2,1,2,1,3,2,2,2,1,2,3,3,3,1,1,2,3,3,1,3,1,2,3,1,1,1,3,1,3,2,3,2,3,1,3,3,1,2,2,1,1,2,1,2,3,3,1,2,2,1,2,2,1,1,1,1,2,2,1,2,3,3,2,1,3,2,1,2,1,1,1,1,2,1,2,3,1,2,3,2,1,3,2,1,3,3,3,1,3,1,2,2,3,1,3,2,1,1,1,2,2,2,3,2,2,3,3,2,2,2,1,2,2,2,1,3,3,2,1,3,2,3,2,2,1,3,1,3,2,3,1,3,3,1,1,3,3,3,1,2,3,1,2,3,1,3,1,2,2,3,1,3,3,3,2,3,3,3,2,3,2,3,1,3,2,3,3,3,3,2,1,1,1,1,2,2,1,1,3,2,3,2,3,3,2,3,3,2,2,3,2,3,3,1,3,3,2,2,2,3,3,1,1,2,1,1,3,3,3,2,3,3,1,1,2,3,2,2,2,2,1,1,1,3,3,1,3,2,1,1,1,1,3,3,1,3,1,2,2,3,2,1,1,2,1,3,2,3,2,1,3,3,3,2,3,2,3,3,2,2,3,1,3,2,2,2,3,3,1,1,2,2,3,1,2,2,2,3,3,3,1,2,3,3,1,3,2,2,1,2,1,2,3,1,3,3,1,2,2,2,2,2,1,3,2,2,3,2,1,1,1,3,3,2,1,1,2,2,3,3,3,1,2,1,3,2,2,1,3,1,2,3,1,3,1,2,1,3,3,1,2,2,3,2,1,1,1,2,3,3,3,3,1,1,1,2,2,2,2,1,1,1,3,2,3,2,2,3,2,1,1,1,2,2,3,2,2,3,3,2,3,2,1,1,1,3,1,1,1,2,1,2,1,1,3,2,2,1,2,2,3,3,1,3,1,3,2,1,2,3,1,1,1,3,2,1,2,2,1,1,1,1,2,1,3,3,1,1,1,1,2,2,1,1,1,2,1,3,2,2,3,1,1,1,1,2,3,2,2,1,2,3,1,1,2};
        testCase.add(convertArrayToNodeList(node1));
        testCase.add(convertArrayToNodeList(node2));
        testCase.add(convertArrayToNodeList(node3));
        testCase.add(convertArrayToNodeList(node4));
        
        return testCase;
    }
    
    /**
     * generate test case from an array of integer
     * @param arr
     * @return
     */
    private static ListNode convertArrayToNodeList(int[] arr) {
        if (arr.length < 1) return null;
        ListNode[] nodeArr = new ListNode[arr.length];
        nodeArr[arr.length - 1] = new ListNode(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            nodeArr[i] = new ListNode(arr[i]);
            nodeArr[i].next = nodeArr[i + 1];
        }
        
        return nodeArr[0];
    }
    
    private static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) return null;
            
            return quickSort(head, null);
        }
        
        
        /**
         * Quick sort algorithm of single linked list
         * i.g. a sample linked list:1->3->2->7. 
         * If sort the whole list, set head = 1, tail = null(7->next=null);
         * Else sort only part of the list, 1->3->2, then set head = 1, tail = 7(2->next=7).
         * @param head - head node of linked list
         * @param tail - <i>next</i> node of the last node of linked list
         * @return head node of sorted linked list
         */
        private ListNode quickSort(ListNode head, ListNode tail) {
            if (head == null) return null;
//            System.out.printf("%d, %d\n", head.val, tail == null ? 0 : tail.val);
//            head.printList();
            if (head.next == tail) return head;
            
            /**
             * choose first node as reference node(nRefer).
             * those with value smaller than <i>nRefer</i> will be added backward to <i>nHead</i>;
             * those with value bigger than <i>nRefer</i> will be added forward to <i>nTail</i>;
             * those with value equal <i>nRefer</i> will be added between <i>nRefer(included)</i> and <i>nRefer(included)</i>.
             *     N    N    N    N    N    N
             *     ^    ^         ^         ^  
             *     |    |         |         |
             *   nHead nRefer  nReferR    nTail
             */
            ListNode nRefer = head,  // reference node
                    nReferR = head;  // used to solve problem of repeated value
            head = head.next;
            nRefer.next = null;
            ListNode nHead = nRefer,
                    nTail = nRefer;
            do {
                ListNode tmpNode = head;
                head = head.next;
                
                if (tmpNode.val > nRefer.val) {
                    nTail.next = tmpNode;
                    nTail = tmpNode;
                } else if (tmpNode.val < nRefer.val) {
                    tmpNode.next = nHead;
                    nHead = tmpNode;
                } else {
                    tmpNode.next = nReferR.next;
                    nReferR.next = tmpNode;
                    if (nTail == nReferR) {
                        nTail = tmpNode;
                    }
                    nReferR = tmpNode;
                }
            } while (head != tail);
            nTail.next = tail;  // link tail to <i>nTail</i> to avoid breaking origin linked list
            
            /**
             * sort both right and left side, and return new head of left side.
             */
            if (nReferR != nTail) {
                nReferR.next = quickSort(nReferR.next, nTail.next);
            }
            return quickSort(nHead, nRefer.next);
        }
    }
    
    /**
     * Definition for singly-linked list.
     *
     */
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        
        void printList() {
            ListNode node = this;
            System.out.println();
            while (node != null) {
                System.out.printf("%3d,", node.val);
                node = node.next;
            }
            System.out.println();
        }
    }
}
