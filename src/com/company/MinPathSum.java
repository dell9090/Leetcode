package com.company;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 1; i < r; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < c; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[r - 1][c - 1];
    }
}
