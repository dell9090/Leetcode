package com.company;

class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int lowCount = count(nums, low, mid);
            if (low == high && lowCount > 1) {
                return low;
            }
            
            if (lowCount > mid - low + 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    // count nums in [low, high]
    private int count(int[] nums, int low, int high) {
        int res = 0;
        if (low > high) {
            return 0;
        } 
        for (int num : nums) {
            if (num >= low && num <= high) {
                res++;
            }
        }
        return res;
    }
    
}


