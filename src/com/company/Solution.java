package com.company;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

class Solution {

//    public  void swap(int[] array, int index1, int index2) {
//        int temp = array[index1];
//        array[index1] = array[index2];∏
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
//    public static List<Integer> closest(String s, List<Integer> queries) {
//        // Write your code here
//        int n = s.length();
//        List<Integer> ans = new ArrayList();
//        int[] map = new int[26];
//        int[] left = new int[n];
//        int[] right = new int[n];
//        Arrays.fill(left, Integer.MAX_VALUE);
//        Arrays.fill(right, Integer.MAX_VALUE);
//
//        Arrays.fill(map, -1);
//        for (int i = 0; i < n; i++) {
//            int index = s.charAt(i) - 'a';
//            if (map[index] == -1) {
//                map[index] = i;
//            } else {
//                left[i] = map[index];
//                map[index] = i;
//            }
//        }
//
//        Arrays.fill(map, -1);
//        for (int i = n - 1; i >= 0; i--) {
//            int index = s.charAt(i) - 'a';
//            if (map[index] == -1) {
//                map[index] = i;
//            } else {
//                right[i] = map[index];
//                map[index] = i;
//            }
//        }
//
//        for (int a : queries) {
//            int tmp;
//            if (left[a] == Integer.MAX_VALUE && right[a] == Integer.MAX_VALUE) {
//                tmp = -1;
//            } else {
//                tmp = Math.min(left[a], right[a]);
//            }
//            ans.add(tmp);
//        }
//
//        return ans;
//   }
public static List<Integer> closest(String s, List<Integer> queries) {
    // Write your code here
    int n = s.length();
    List<Integer> ans = new ArrayList();
    int[] map = new int[26];
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(left, Integer.MAX_VALUE);
    Arrays.fill(right, Integer.MAX_VALUE);

    Arrays.fill(map, -1);
    for (int i = 0; i < n; i++) {
        int index = s.charAt(i) - 'a';
        if (map[index] == -1) {
            map[index] = i;
        } else {
            left[i] = map[index];
            map[index] = i;
        }
    }
    Arrays.fill(map, -1);
    for (int i = n - 1; i >= 0; i--) {
        int index = s.charAt(i) - 'a';
        if (map[index] == -1) {
            map[index] = i;
        } else {
            right[i] = map[index];
            map[index] = i;
        }
    }

    for (int a : queries) {
        int tmp;

        if (left[a] != Integer.MAX_VALUE && right[a] != Integer.MAX_VALUE) {
            int disL = a - left[a];
            int disR = right[a] - a;
            tmp = disR < disL ? right[a] : left[a];
        } else {
            tmp = Math.min(left[a], right[a]);
            tmp = tmp == Integer.MAX_VALUE ? -1 : tmp;
        }
        ans.add(tmp);
    }

    return ans;
}
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

//        public static int countMatches(List<String> grid1, List<String> grid2) {
//        // Write your code here
//        int ans = 0;
//        int len1 = grid1.size();
//        int len2 = grid2.size();
//
//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//
//                List<int[]> region1 = search(grid1, i, j);
//                List<int[]> region2 = search(grid2, i, j);
//
//                if (compare(region1, region2)) {
//                    ans++;
//                }
//
//            }
//        }
//        return ans;
//    }
//
//        private static List<int[]> search(List<String> grid, int i, int j) { // i -> row, j -> column
//            List<int[]> ans = new ArrayList<>();
//
//            List<int[]> move = new ArrayList<>();
//            move.add(new int[] { 0, 1 });
//            move.add(new int[] { 0, -1 });
//            move.add(new int[] { 1, 0 });
//            move.add(new int[] { -1, 0 });
//
//            int m = grid.size();
//            if (grid.get(i).charAt(j) == '1') {
//                Queue<int[]> q = new LinkedList<>();
//                q.offer(new int[]{i, j});
//                while (!q.isEmpty()) {
//                    int[] tmp = q.poll();
//                    int r = tmp[0];
//                    int c = tmp[1];
//
//                    StringBuilder s = new StringBuilder(grid.get(r));
//                    s.setCharAt(c, '0');
//                    grid.set(r, s.toString());
//
//                    ans.add(tmp);
//
//                    for (int[] a : move) {
//                        int newR = r + a[0];
//                        int newC = c + a[1];
//
//                        if (newR >= 0 && newR < m && newC >= 0 && newC < grid.get(newR).length() && grid.get(newR).charAt(newC) == '1') {
//                            q.offer(new int[]{r + a[0], c + a[1]});
//                        }
//                    }
//                }
//            }
//
//            return ans;
//        }
//
//        private static boolean compare(List<int[]> r1, List<int[]> r2) {
//            if (r1.size() != r2.size() || r1.size() == 0) {
//                return false;
//            }
//            int n = r1.size();
//            for (int i = 0; i < n; i++) {
//                if (r1.get(i)[0] != r1.get(i)[0] || r1.get(i)[1] != r1.get(i)[1]) {
//                    return false;
//                }
//            }
//            return true;
//        }
public static int countMatches(List<String> grid1, List<String> grid2) {

    List<char[]> map1 = new ArrayList<>();
    for (String tmp: grid1) {
        map1.add(tmp.toCharArray());
    }

    List<char[]> map2 = new ArrayList<>();
    for (String tmp: grid2) {
        map2.add(tmp.toCharArray());
    }

    int ans = 0;

    for (int i = 0; i < map1.size(); i++) {
        for (int j = 0; j < map1.get(i).length; j++) {
            // change in place
            List<int[]> records1 = bfs(map1, i, j);
            List<int[]> records2 = bfs(map2, i, j);

            // compare the records
            if (compare(records1, records2)) {
                ans++;
            }
        }
    }
    return ans;

}

    private static List<int[]> bfs(List<char[]> map, int i, int j) {
        List<int[]> res = new ArrayList<>();

        if (map.get(i)[j] == '1') {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i, j});
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int r = temp[0];
                int c = temp[1];
                map.get(r)[c] = '0';
                res.add(temp);
                // check the 4 directions
                if (r - 1 >= 0 && c < map.get(r - 1).length && map.get(r - 1)[c] == '1') {
                    queue.offer(new int[]{r - 1, c});
                }
                if (r + 1 < map.size() && c < map.get(r + 1).length && map.get(r + 1)[c] == '1') {
                    queue.offer(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && map.get(r)[c - 1] == '1') {
                    queue.offer(new int[]{r, c - 1});
                }
                if (c + 1 < map.get(r).length && map.get(r)[c + 1] == '1') {
                    queue.offer(new int[]{r, c + 1});
                }
            }
        }

        return res;
    }

    private static boolean compare(List<int[]> l1, List<int[]> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }

        if (l1.size() == 0) {
            return false;
        }

        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i)[0] != l2.get(i)[0] || l1.get(i)[1] != l2.get(i)[1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Create a Binary Search Tree
        String s = "hackerrank";
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(6);
        list.add(8);


       Solution tmp = new Solution();

        List<String> map1a = new ArrayList<>();
        map1a.add("0100");
        map1a.add("1001");
        map1a.add("0011");
        map1a.add("0011");

        List<String> map1b = new ArrayList<>();

        map1b.add("0101");
        map1b.add("1001");
        map1b.add("0011");
        map1b.add("0011");
        int a = -1;
        
        System.out.println(((a>>>31)^1)&a);

//       int ans  = tmp.findMaximumXOR(grid);
//       System.out.print(ans);
    }
}