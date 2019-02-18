package com.company;

public class P321 {
    public static void main(String[] args) {
        // write your code here
        P321 p = new P321();
        int[] a = {3,4,6,5};
        int[] b = {9,1,2,5,8,3};
        int k = 5;
        System.out.print(p.maxNumber(a,b,k));
    }
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int m = nums1.length;
            int n = nums2.length;
            int[] ans= new int[k];
            for (int len1 = Math.max(0, k - n); len1 <= Math.min(m, k); len1++){
                int len2= k - len1; // 0<=len2=k-len1<=n -> k-n<=len1<=n
                int[] candidate= merge(maxArray(nums1, len1), maxArray(nums2, len2));
                if (greater(candidate, 0, ans, 0)) {
                    ans = candidate;
                }
            }
            return ans;
        }

        public int[] maxArray(int[] nums, int len){
            int[] res= new int[len];

            if (len == 0) {
                return res;
            }

            for (int i = 0, idx = 0; i < nums.length; i++) {
                while(idx != -1 && nums[i] > res[idx] && nums.length - i >= len - idx) { //greedy, use greater one to replace smaller
                    idx--;
                }
                if (idx + 1 < len) {
                    res[++idx]=nums[i];
                }
            }

            return res;
        }

        public int[] merge(int[] a, int[] b){
            int[] res= new int[a.length + b.length];
            for (int idx = 0, i = 0, j = 0; idx < res.length; idx++){
                 if (greater(a, i, b, j)) {
                     res[idx]=a[i++];
                 }
                 else {
                     res[idx]=b[j++];
                 }
            }
            return res;
        }

        public boolean greater(int[] a, int i, int[] b, int j){
            for (; i < a.length && j < b.length; i++, j++){
                if (a[i] == b[j]) {
                    continue;
                }
                return a[i] > b[j];
            }

            return i != a.length;
        }

}
