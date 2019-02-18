package com.company;

import java.util.*;

public class P743 {
    public static void main(String[] args) {
        // write your code here
        int[][] temp = {{2,1,1},{2,3,1},{3,4,1}};
        P743 p = new P743();
        int ans = p.networkDelayTime(temp,4 ,2);
        System.out.print(ans);
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, ArrayList<int[]>> graph = new HashMap<>();

        for (int[] edge: times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((info1,info2)-> info1[0] - info2[0]);
        heap.offer(new int[]{0,K});
        Map<Integer, Integer> d = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            d.put(i, 10000);
        }
        d.put(K,0);

        while(!heap.isEmpty()){
            int[] info = heap.poll();
            int v = info[1];
            int dis = info[0];

            if (d.get(v) < dis) continue;
            //if(d.containsKey(v)) continue;

            //d.put(v,dis);

            if (graph.containsKey(v)) {
                for (int[] edge: graph.get(v)) {
                    if (d.get(edge[0]) > dis+edge[1]) {
                    //if (!d.containsKey(edge[0])) {
                        d.put(edge[0],dis+edge[1]);
                        heap.offer(new int[]{dis+edge[1], edge[0]});
                    }
                }
            }

        }
        for (int i = 1; i <= N; i++) {
            if (d.get(i) == 10000) {
                return -1;
            }
        }
        int ans = 0;
        for (int cand: d.values()) {
            ans = Math.max(ans, cand);
        }
        return ans;
    }

}
