package com.company;

class Solution {
    private final String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] below100 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] unit = {"", " Thousand", " Million", " Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000, num / 1000) + unit[i] + words;
            }
            num /= 1000;
            i++;
        }
        return words;
    }
    
    private String helper(int num, int front) {
        if (num == 0) {
           return "";
        } else if (num < 20) {
            return (front == 0 ? "" : " ") + below20[num];
        } else if (num < 100) {
            return (front == 0 ? "" : " ") + below100[num / 10] + helper(num % 10, num / 10);
        } else {
            return (front == 0 ? "" : " ") + below20[num / 100] + " Hundred" + helper(num % 100, num / 100);
        }
        
           
    }
}