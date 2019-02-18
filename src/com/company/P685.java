package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P685 {
    static int MAXSIZE = 1000;

    public static void main(String[] args) {
        // write your code here
        int[][] edges = {{2,1},{3,1},{4,2},{1,4}};
        P685 p = new P685();
        int[] temp = p.findRedundantDirectedConnection(edges);
        System.out.print(temp[0] + ','+ temp[1]);
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int[] ans = new int[2];
        int wrongnode = 0;
        Map<Integer, ArrayList<int[]>> check = new HashMap<Integer,ArrayList<int[]>>();
        for (int[] e : edges) {
            if (!check.containsKey(e[1])) {
                check.put(e[1],new ArrayList<int[]>());
            } else {
                wrongnode = e[1];
            }
            check.get(e[1]).add(e);
        }
        if (wrongnode == 0) {
            DSU d = new DSU (MAXSIZE+1);
            for (int[] e : edges) {
                if (!d.unite(e[0],e[1])) {
                    ans = e;
                }
            }
        } else {
            for (int[] c: check.get(wrongnode)) {
                DSU d = new DSU (MAXSIZE+1);
                boolean safe = false;
                for (int[] e : edges) {
                    if (e[0]==c[0] && e[1]==c[1]) {
                        continue;
                    }
                    if (!d.unite(e[0],e[1])) {
                        safe = true;
                    }
                }
                if (!safe) {
                    ans = c;
                }
            }
        }

        return ans;
    }
}

class DSU {
    int[] rank;
    int[] parent;

    public DSU (int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find (int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean unite (int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        } else if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (rank[x] == rank[y]) {
                rank[y]++;
            }
        }

        return true;
    }
}
