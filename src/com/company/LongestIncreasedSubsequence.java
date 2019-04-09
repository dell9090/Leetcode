package com.company;

import java.util.Arrays;

class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length - 1;
        int[] dp = new int[n + 1];
        int ans;
        Arrays.fill(dp,Integer.MAX_VALUE);

        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, n, num);
            if (i < 0) {
                dp[-i - 1] = num;
            } else {
                dp[i] = num;
            }

        }
        for (ans = 0; ans <= n && dp[ans] != Integer.MAX_VALUE; ans++) {}

        return ans;
    }

}
