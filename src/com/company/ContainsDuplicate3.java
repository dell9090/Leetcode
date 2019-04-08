package com.company;

import java.util.*;
// bucket O(n)   space comlecity: O(t)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        
        Map<Long, Long> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            long mapNum = (long) nums[i] + Integer.MAX_VALUE;
            long bucket = mapNum / ((long) t + 1);
            
            if (map.containsKey(bucket) || 
                (map.containsKey(bucket - 1) && map.get(bucket - 1) + t >= mapNum) ||
               (map.containsKey(bucket + 1) && map.get(bucket + 1) - t <= mapNum)) {
                return true;
            }
            
            if (map.entrySet().size() >= k) {
                long first = ((long) nums[i - k] + Integer.MAX_VALUE) / ((long) t + 1);
                map.remove(first);
            }
            
            map.put(bucket, mapNum);
        }
        
        return false;
    }
}

//use TreeSet  O(nlogn)
// class Solution {
//     public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//         TreeSet<Integer> set = new TreeSet<>();
        
//         for (int i = 0; i < nums.length; i++) {
//             if (set.floor(nums[i]) != null) {
//                 long temp = set.floor(nums[i]);
//                 if (nums[i] - temp <= t) {
//                     return true;
//                 }
//             }
            
//             if (set.ceiling(nums[i]) != null) {
//                 long temp = set.ceiling(nums[i]);
//                 if (temp - nums[i] <= t) {
//                     return true;
//                 }
//             }
            
//             set.add(nums[i]);
//             if (set.size() > k) {
//                 set.remove(nums[i - k]);
//             }
            
//         }
//         return false;
//     }
// }