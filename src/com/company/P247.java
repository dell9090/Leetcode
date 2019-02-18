package com.company;

import java.util.ArrayList;
import java.util.List;

public class P247 {

    static boolean isfirst = true;
    public static void main(String[] args) {
        // write your code here
        List<String> a = new ArrayList<>();
        P247 p = new P247();
        a = p.findStrobogrammatic(4);
        System.out.print(" ");
    }

    public List<String> findStrobogrammatic(int n) {
        String[] lm = {"0","1","6","8","9"};
        String[] rm = {"0","1","9","8","6"};
        int mstart = 0;
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
            return ans;
        } else if (n == 1){
            ans.add("0");
            ans.add("1");
            ans.add("8");
            return ans;
        }
        if (isfirst) {
            mstart = 1;
            isfirst = false;
        }
        for (int i = mstart; i < 5; i++) {
            for (String s: findStrobogrammatic(n - 2)) {
                ans.add(lm[i] + s + rm[i]);
            }
        }
        return ans;
    }

}
