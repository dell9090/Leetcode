package com.company;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int nLen = nums.length;
        int[] dp = new int[nLen];//dp[i] : the minimum of length i + 1.  dp is an increasing array
        int size = 0;
        Arrays.fill(dp,Integer.MAX_VALUE);
        if (nums.length == 0) {
            return 0;
        }
        
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, nLen - 1, num);
            if (i < 0) { // dp[i - 1] < num <= dp[i]    use num update dp[i]
                dp[-i - 1] = num;
                if (i == - size - 1) {  // num > all dp[]  so size + 1
                    size++;
                }
            }
        }
        
        return size;
    }
}
