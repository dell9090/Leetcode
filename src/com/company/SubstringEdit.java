package com.company;
import java.util.*;

class SubstringMatch {
    public List<String> match(String s1, String s2) {
        List<String> res = new ArrayList<>();
        int sLen1 = s1.length();
        int sLen2 = s2.length();
        int [][][] dp = new int[sLen1][sLen2][sLen1];

        for (int k = 1; k < sLen1; k++) {
            for (int i = 0; i < sLen1; i++) {
                for (int j = 0; j < sLen2; j++) {
                    if (j + k > sLen2) {
                        break;
                    }
                    
                    if (s1.charAt(i + k - 1) == s2.charAt(j + k - 1)) {
                        dp[i][j][k] = dp[i][j][k - 1];
                    } else {
                        dp[i][j][k] = dp[i][j][k - 1] + 1;
                    }

                    if (dp[i][j][k] <= 1) {
                        res.add(s1.substring(i, i + k));
                    }
                }
            }
        }

        return res; 
    }
}  