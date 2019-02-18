package com.company;

public class P886 {
    int[] color;
    public static void main(String[] args) {
        // write your code here
        int[][] b = {{1,2},{1,3}, {2,4}};
        P886 a = new P886();
        a.possibleBipartition(4,b);
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        color = new int[N+1];

        for(int i = 1; i <= N; i++) {
            if (color[i] == 0){
                if(!dfs(i,1,dislikes)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int v, int c,int[][] dislikes) {
        color[v] = c;
        for (int i = 0; i<dislikes.length; i++) {
            if(dislikes[i][0] == v){
                if(color[dislikes[i][1]] == color[v]) {
                    return false;
                } else if(color[dislikes[i][1]] == 0 && !dfs(dislikes[i][1],-c,dislikes)){
                    return false;
                }
            }
        }

        return true;
    }

}
