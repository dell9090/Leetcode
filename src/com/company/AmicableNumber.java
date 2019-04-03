package com.company;
class AmicableNumber {
    public static final int MAX_NUM = 5000;

	static void amicablePair(int sum[], int n) {
		
		for (int i = 1; i <= n; i++) {
			sum[i] = 1;
		}

		for (int i = 2; i <= n / 2; i++) {
            int j = i * 2;
			while (j <= n) {
				sum[j] += i;
				j += i;
			}
		}

		for (int i = 1; i <= n; i++) {
            //System.out.println(i + " " + sum[i]);
			if (sum[i] > i && sum[i] <= n && sum[sum[i]] == i) {
			    System.out.printf("%d:%d\n", sum[i], i);
			}
		}
    }
    
    public static void main(String[] args) {
        int[] sum = new int[MAX_NUM + 1];
        amicablePair(sum, MAX_NUM);    
    }
}