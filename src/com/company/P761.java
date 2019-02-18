package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P761 {
    public static void main(String[] args) {
        // write your code here
        String s = "11011000";
        P761 p = new P761();
        String temp = p.makeLargestSpecial(s);
        System.out.print(temp);
    }

    public String makeLargestSpecial(String S) {
        int count = 0;
        List<String> subans = new ArrayList<>();
        int n = S.length();
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (S.charAt(r) == '0') {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                subans.add("1" + makeLargestSpecial(S.substring(l + 1, r)) + "0");
                l = r + 1;
            }
        }
        Collections.sort(subans, Collections.reverseOrder());
        return String.join("", subans);
    }
}
