package com.company;
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        int max = r + c - 2;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int up = (i > 0) ? dp[i - 1][j] : max;
                    int left = (j > 0) ? dp[i][j - 1] : max;
                    dp[i][j] = Math.min(up, left) + 1;
                }
            }
        }
    
    for (int i = r - 1; i >= 0; i--) {
        for (int j = c - 1; j >= 0; j--) {
            if (matrix[i][j] == 0) {
                dp[i][j] = 0;
            } else {
                int down = (i < r - 1) ? dp[i + 1][j] : max;
                int right = (j < c - 1) ? dp[i][j + 1] : max;
                dp[i][j] = Math.min(Math.min(down, right) + 1, dp[i][j]);
            }
        }
    }
    
    return dp;
}
}