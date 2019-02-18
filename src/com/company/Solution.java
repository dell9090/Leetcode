package com.company;

import java.io.IOException;
import java.util.*;

class Solution {

//    public  void swap(int[] array, int index1, int index2) {
//        int temp = array[index1];
//        array[index1] = array[index2];
//        array[index2] = temp;
//    }
//
//    public  void quickSort(int[] arr,int start,int end){
//
//        if(end - start < 1) {
//            return;
//        }
//
//        int part = partArr(arr, start, end);
//        if(part == start) {
//            quickSort(arr, part + 1, end);
//        } else if(part == end) {
//            quickSort(arr, start, end - 1);
//        } else{
//            quickSort(arr,start,part - 1);
//            quickSort(arr,part + 1, end);
//        }
//    }

//    public static int partArr(int[] arr, int start, int end) {
//
//
//        int base = arr[end];
//        int n = start;
//
//        for (int i = start; i < end; i++) {
//            if (arr[i] < base) {
//                if (i != n) {
//                    swap(arr, i, n);
//                }
//                n++;
//            }
//        }
//        swap(arr, n, end);
//        return n;
//    }


//    void quick_sort(int s[], int l, int r) {
//        if (l < r) {
//            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
//            int i = l, j = r, x = s[l];
//            while (i < j) {
//                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
//                    j--;
//                if (i < j)
//                    s[i++] = s[j];
//
//                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
//                    i++;
//                if (i < j)
//                    s[j--] = s[i];
//            }
//            s[i] = x;
//            quick_sort(s, l, i - 1); // 递归调用
//            quick_sort(s, i + 1, r);
//        }
//    }
//
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Create a Binary Search Tree

       int[]grid = {3, 10, 5, 25, 2, 8};
       Solution tmp = new Solution();
       int ans  = tmp.findMaximumXOR(grid);
       System.out.print(ans);
    }
}