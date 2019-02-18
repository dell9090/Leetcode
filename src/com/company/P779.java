package com.company;

public class P779 {
    public int kthGrammar(int N, int K) {
        return search(N,K);
    }

    public int search(int n, int k) {
        int a = (int)Math.pow(2,n-2);
        if (n <= 2) {
            return (k + 1) % 2;
        } else if (k > a) {
            int tempk = k % a;
            if (tempk == 0) {
                tempk = a;
            }
            return (search( n-1, tempk )+1) % 2;
        } else {
            return search( n-1, k);
        }
    }
}
