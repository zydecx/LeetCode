package com.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        List<int[]> testCase = getTestCase();
        
        long start = System.currentTimeMillis();
        
        int min;
        for (int[] tc : testCase) {
            min = solution.findMin(tc);
            System.out.println(min);
        }
        
        long end = System.currentTimeMillis();
        
        System.out.printf("time cost: %dms", end - start);
    }
    
    public static List getTestCase() {
        int[] testCase1 = {4, 5, 6, 7, 0, 1, 2},
                testCase2 = {0, 1, 2, 4, 5, 6, 7},
                testCase3 = {4, 5, 6, 7, 0, 1, 2},
                testCase4 = {3, 1},
                testCase5 = {1,10},
                testCase6 = {3, 1, 2},
                testCase7 = {5, 1, 3};
        List<int[]> testCase = new ArrayList<>();
        testCase.add(testCase1);
        testCase.add(testCase2);
        testCase.add(testCase3);
        testCase.add(testCase4);
        testCase.add(testCase5);
        testCase.add(testCase6);
        testCase.add(testCase7);
        
        return testCase;
    }
    
    private static class Solution {
        public int findMin(int[] num) {
            int length = num.length;
            
            int firstNum = num[0];
            int s = 0,
                    e = length - 1,
                    m;
            while (s < e - 1) {
                m = (s + e) / 2;
                int middle = num[m];
                
                if (middle > firstNum) {
                    s = m;
                } else {
                    e = m;
                }
            }
            
            return num[e] < firstNum ? num[e] : firstNum;
        }
    }

}
