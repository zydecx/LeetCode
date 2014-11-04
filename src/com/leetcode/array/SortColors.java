package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        List<int[]> testCase = getTestCase();
        
        long start = System.currentTimeMillis();
        
        int min;
        for (int[] tc : testCase) {
            solution.sortColors(tc);
            System.out.println(Arrays.toString(tc));
        }
        
        long end = System.currentTimeMillis();
        
        System.out.printf("time cost: %dms", end - start);
    }
    
    public static List getTestCase() {
        List<int[]> testCase = new ArrayList<>();
        int[] tc;
        int count = 10;
        int maxSize = 100;
        for (int i = 0; i < count; i++) {
            Random r = new Random();
            int size = r.nextInt(maxSize);
            tc = new int[size];
            for (int j = 0; j < size; j++) {
                tc[j] = r.nextInt(2);
            }
            testCase.add(tc);
        }
        
        return testCase;
    }
    
    private static class Solution {
        public void sortColors(int[] A) {
            int length = A.length;
        }
        
        public static final int RED = 0;
        public static final int WHITE = 1;
        public static final int BLUE = 2;
    }
}
