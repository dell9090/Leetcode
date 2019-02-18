package com.company;

public class P684 {
    static int MAXSIZE = 1000;

    public static void main(String[] args) {
        // write your code here
        int[][] edges = {{1,2},{1,3},{2,3}};
        P684 p = new P684();
        int[] temp = p.findRedundantConnection(edges);
        System.out.print(temp[0] + ','+ temp[1]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        DSU1 d = new DSU1(MAXSIZE+1);
        for (int[] e : edges) {
            if (!d.unite(e[0],e[1])) {
                return e;
            }
        }
        return null;
    }
}

class DSU1 {
    int[] rank;
    int[] parent;

    public DSU1(int size ){
        rank = new int[size];
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;

        if(rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        }
        return true;
    }
}