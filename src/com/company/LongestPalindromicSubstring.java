package com.company;

class Solution {
    private int max;
    private int lo;
    public String longestPalindrome(String s) {
        max = 0;
        if (s.length() < 2) {
            return s;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return s.substring(lo, lo + max);
    }
    
    private void helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        
        if (max < j - i - 1) {
            max = j - i - 1;
            lo = i + 1;
        }
    }
    
}