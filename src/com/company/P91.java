package com.company;
import java.util.*;

class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[2]; 
        Arrays.fill(dp,1);
        int len = s.length();
        
        for (int i = 1; i < len; i++) {
            int cur = dp[1];
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                } else {
                    cur = dp[0]; 
                }
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')) {
                cur += dp[0];
            }
            dp[0] = dp[1];
            dp[1] = cur;
        }
        return dp[1];
    }
}