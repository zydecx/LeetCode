package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        List<ListNode> testCase = getTestCase();
        
        long start = System.currentTimeMillis();
        
        for (ListNode tc : testCase) {
            solution.reorderList(tc);
            tc.printList();
        }
        
        long end = System.currentTimeMillis();
        
        System.out.printf("time cost: %dms", end - start);
    }
    
    public static List getTestCase() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        List<ListNode> testCase = new ArrayList<>();
        testCase.add(node1);
        testCase.add(node2);
        testCase.add(node3);
        testCase.add(node4);
        testCase.add(node5);
        testCase.add(node6);
        
        return testCase;
    }
    
    private static class Solution {
        public void reorderList(ListNode head) {
            if (head == null) return;
            if (head.next == null) return;
            if (head.next.next == null) return;
            
            ListNode oneJump = head, 
                    twoJump = head.next;
            while (twoJump != null && twoJump.next != null) {
                oneJump = oneJump.next;
                twoJump = twoJump.next.next;
            }
            
            ListNode temp;
            
            ListNode current = oneJump.next,
                    next = current.next;
            oneJump.next = null;
            current.next = null;
            while (next != null) {
                temp = next.next;
                next.next = current;
                current = next;
                next = temp;
            }
            
            ListNode tail = current;
            while (tail != null) {
                temp = head.next;
                head.next = tail;
                tail = tail.next;
                head.next.next = temp;
                head = temp;
            }
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
        }
    }
}
