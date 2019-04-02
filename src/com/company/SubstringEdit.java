package com.company;
import java.util.*;

class SubstringMatch {
    public List<String> match(String s1, String s2) {
        List<String> res = new ArrayList<>();
        Set<String> ans = new HashSet<>();
        int sLen1 = s1.length();
        int sLen2 = s2.length();
        int [][][] dp = new int[sLen1][sLen2][sLen1];

        for (int k = 1; k < sLen1; k++) {
            for (int i = 0; i < sLen1 - k + 1; i++) {
                for (int j = 0; j < sLen2 - k + 1; j++) {
                    if (j + k > sLen2) {
                        break;
                    }

                    if (s1.charAt(i + k - 1) == s2.charAt(j + k - 1)) {
                        dp[i][j][k] = dp[i][j][k - 1];
                    } else {
                        dp[i][j][k] = dp[i][j][k - 1] + 1;
                    }

                    if (dp[i][j][k] <= 1) {
                        ans.add(s1.substring(i, i + k) + "/" +
                        s2.substring(j, j + k));
                    }
                }
            }
        }
        for (String s : ans) {
            res.add(s);
        }
        return res; 
    }
}  