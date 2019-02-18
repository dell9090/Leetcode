package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class P354 {
    public static void main(String[] args) {
        // write your code here
        P354 p = new P354();
        int[][] a = {{1,1},{4,5},{4,6},{6,7},{2,3}};
        System.out.print(p.maxEnvelopes(a));
    }
        public int maxEnvelopes(int[][] envelopes) {
            if(envelopes.length == 0 || envelopes[0].length != 2) {
                return 0;
            }
            int n = envelopes.length;
            Arrays.sort(envelopes, new Comparator<int[]>(){
                public int compare(int[] arr1, int[] arr2){
                    if(arr1[0] == arr2[0])
                        return arr2[1] - arr1[1];   //increase
                    else
                        return arr1[0] - arr2[0]; // decrease
                }
            });

            int[] dp = new int[n];
            Arrays.fill(dp,Integer.MAX_VALUE);
            int ans = 0;

            for (int[] envelope : envelopes) {
                int i = Arrays.binarySearch(dp, 0, n, envelope[1]);

                if (i < 0) {
                    i = -(i + 1);
                }

                dp[i] = envelope[1];
            }

            for (ans = 0; ans < n && dp[ans] != Integer.MAX_VALUE; ans++) {
            }

            return ans;
        }
}
