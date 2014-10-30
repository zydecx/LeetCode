package com.leetcode.breadthfirstsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        List<char[][]> testCase = getTestCase();
        
        long start = System.currentTimeMillis();
        
        for (char[][] tc : testCase) {
            solution.solve(tc);
        }
        
        long end = System.currentTimeMillis();
        
        System.out.printf("time cost: %dms", end - start);
    }
    
    public static List getTestCase() {
        char[][] testCase1 = {{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}},
                testCase2 = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        List<char[][]> testCase = new ArrayList<>();
        testCase.add(testCase1);
        testCase.add(testCase2);
        
        return testCase;
    }
}

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        if (rows < 1) return;
        int columns = board[0].length;
        if (columns < 1) return;
        
        for (int i = 0; i < columns; i++) {
            setOuterFlag(0, i, board, rows, columns);
        }
        for (int i = 0; i < columns; i++) {
            setOuterFlag(rows - 1, i, board, rows, columns);
        }
        for (int i = 0; i < rows; i++) {
            setOuterFlag(i, 0, board, rows, columns);
        }
        for (int i = 0; i < rows; i++) {
            setOuterFlag(i, columns - 1, board, rows, columns);
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = 'X';
            }
        }
        
        for (int i = 0, len = outerRowAxis.size(); i < len; i++) {
            board[outerRowAxis.get(i)][outerColumnAxis.get(i)] = 'O';
        }
        

        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%s,", board[i][j]);
            }
            System.out.print("\n");
        }*/
    }
    
    public void setOuterFlag(int row, int column, char[][] board, int rows, int columns) {
        if (board[row][column] == 'X') return;
        
        Stack<Integer> rowAxisStack = new Stack<>();
        Stack<Integer> columnAxisStack = new Stack<>();
        rowAxisStack.push(row);
        columnAxisStack.push(column);
        while (!rowAxisStack.isEmpty()) {
            int tr = rowAxisStack.pop();
            int tc = columnAxisStack.pop();
            if (board[tr][tc] == 'O') {
                board[tr][tc] = 'X';
                outerRowAxis.add(tr);
                outerColumnAxis.add(tc);

                if (tr > 0) {
                    rowAxisStack.push(tr - 1);
                    columnAxisStack.push(tc);
                }
                if (tr < rows - 1) {
                    rowAxisStack.push(tr + 1);
                    columnAxisStack.push(tc);
                }
                if (tc > 0) {
                    rowAxisStack.push(tr);
                    columnAxisStack.push(tc - 1);
                }
                if (tc < columns - 1) {
                    rowAxisStack.push(tr);
                    columnAxisStack.push(tc + 1);
                }
            }
        }
        /*if (board[row][column] == 'O') {
            outerRowAxis.add(row);
            outerColumnAxis.add(column);
            board[row][column] = 'X';

            if (row > 0) setOuterFlag(row - 1, column, board, rows, columns);
            if (row < rows - 1) setOuterFlag(row + 1, column, board, rows, columns);
            if (column > 0) setOuterFlag(row, column - 1, board, rows, columns);
            if (column < columns - 1) setOuterFlag(row, column + 1, board, rows, columns);
        }*/
    }
    
    List<Integer> outerRowAxis = new ArrayList<>();
    List<Integer> outerColumnAxis = new ArrayList<>();
}
