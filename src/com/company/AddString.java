package com.company;

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int inc = 0;
        while (i >= 0 || j >= 0 || inc > 0) {
            int a = i < 0 ? 0 : num1.charAt(i--) - '0';
            int b = j < 0 ? 0 : num2.charAt(j--) - '0';
            ans.append((a + b + inc) % 10);
            inc = (a + b + inc) / 10;
        }
        return ans.reverse().toString();
    }
}