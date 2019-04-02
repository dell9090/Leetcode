package com.company;

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<Integer>();// save the index
        int maxArea = 0;
        for(int i = 0; i <= len; i++){// stack of value: 3, 2 cur: 1
            int h = (i == len ? 0 : height[i]);
            if (stack.isEmpty() || h >= height[stack.peek()]) {
                stack.push(i);
            } else {// stack of value: 3, 2  cur: 4
                int tp = stack.pop();
                maxArea = Math.max(maxArea, height[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}