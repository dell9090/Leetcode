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

// union find
class Solution {
    int[] parent;
    int[] rank;
    int count;
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length; 
        parent = new int[m * n];
        rank = new int[m * n];
         
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                parent[i * m + j] = i * m + j;
                rank[i * m + j] = 0;
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        union(i * m + j, (i - 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        union(i * m + j, i * m + j - 1);
                    }
                }
            }
        }
        return count;
    }

  
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }    
        return parent[x];
    }
    
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        } else {
            count--;
            if(rank[x] < rank[y]) {
                parent[x] = y;
            } else {
                parent[y] = x;
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }
            }
        }
    }
}
