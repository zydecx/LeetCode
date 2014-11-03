package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        List<String> testCase = getTestCase();
        
        long start = System.currentTimeMillis();
        
        for (String tc : testCase) {
            solution.isPalindrome(tc);
        }
        
        long end = System.currentTimeMillis();
        
        System.out.printf("time cost: %dms", end - start);
    }
    
    public static List getTestCase() {
        String testCase1 = "A man, a plan, a canal: Panama",
                testCase2 = "race a car";
        List<String> testCase = new ArrayList<>();
        testCase.add(testCase1);
        testCase.add(testCase2);
        
        return testCase;
    }
    
    private static class Solution {
        public boolean isPalindrome(String s) {
            int len = s.length();
                int i = 0;
                int j = len - 1;
                char ci, cj;
                boolean isValid = true;
                while (i < j) {
                    do {
                        ci = s.charAt(i);
                        i++;
                        if ((ci = validateCharacter(ci)) != ' ') {
                            break;
                        }
                    } while (i < len);
                    do {
                        cj = s.charAt(j);
                        j--;
                        if ((cj = validateCharacter(cj)) != ' ') {
                            break;
                        }
                    } while (j >= 0);
                    
                    if ((i - 1) < (j + 1) && ci != cj) {
                        isValid = false;
                        break;
                    }
                }
                
                return isValid;
        }
        
        private char validateCharacter(char c) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
            } else if ((c < 'a' || c > 'z') && (c < '0' || c > '9')) {
                c = ' ';
            }
            
            return c;
        }
    }
}

