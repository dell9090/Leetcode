package com.company;

public class P64 {
    public static void main(String[] args) {
        // write your code here
        P64 p = new P64();
        int[][] s = {{1,3,1},{1,5,1},{4,2,2}};
        System.out.print(p.minPathSum(s));
    }
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[0][i] += grid[0][i - 1];
            grid[i][0] += grid[i -1][0];
        }
        for (int len = 1; len < grid.length; len++) {
            for (int i = 1; i < len; i++) {
                grid[len][i] += Math.min(grid[len - 1][i], grid[len][i - 1]);
                grid[i][len] += Math.min(grid[len - 1][i], grid[len][i - 1]);
            }
            grid[len][len] += Math.min(grid[len - 1][len], grid[len][len - 1]);
        }
        return grid[grid.length - 1][grid.length - 1];
    }

}
