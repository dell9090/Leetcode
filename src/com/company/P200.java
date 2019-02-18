package com.company;

public class P200 {
    static int r;
    static int c;

    public static void main(String[] args) {
        // write your code here
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        P200 p = new P200();
        System.out.println(p.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        r = grid.length;
        c = grid[0].length;

        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid,i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = 0;
        System.out.println(i + ", " + j);
        if (i > 0 && grid[i - 1][j] == '1') {
            dfs(grid,i - 1 ,j);
        }
        if (i < r - 1 && grid[i + 1][j] == '1') {
            dfs(grid,i + 1 ,j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            dfs(grid,i ,j - 1);
        }
        if (j < c - 1&& grid[i][j + 1] == '1') {
            dfs(grid,i ,j + 1);
        }

        return;
    }
}
