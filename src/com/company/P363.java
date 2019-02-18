package com.company;

class P363 {
    public static void main(String[] args) {
        // write your code here
        P363 p = new P363();
        int[][] a = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        int k = 10;
        System.out.print(p.maxSumSubmatrix(a,k));
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[r][c];
        dp[0][0] = matrix[0][0];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] > ans && matrix[i][j] <= k) {
                    ans = matrix[i][j];
                }
            }
        }

        for (int i = 1; i < r; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
            if (dp[i][0] > ans && dp[i][0] <= k) {
                ans = dp[i][0];
            }
        }
        for (int i = 1; i < c; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
            if (dp[0][i] > ans && dp[0][i] <= k) {
                ans = dp[0][i];
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
                if (dp[i][j] > ans && dp[i][j] <= k) {
                    ans = dp[i][j];
                }
            }
        }

        return ans;
    }
}