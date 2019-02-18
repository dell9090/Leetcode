package com.company;

import java.util.HashMap;
import java.util.Map;

public class P399 {
    public static void main(String[] args) {
        // write your code here
        String[][] equations = {{"a","b"},{"e","f"},{"b","e"}};
        double[] values = {3.4,1.4,2.3};
        String[][] queries = {{"b","a"},{"a","f"},{"f","f"},{"e","e"},{"c","c"},{"a","c"},{"f","e"}};
        P399 p = new P399();
        double[] ans = p.calcEquation(equations,values,queries);
        for (double a : ans) {
            System.out.print(Double.toString(a)+", ");
        }

    }
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            double[] ans = new double[queries.length];
            Map<String, Double> val = new HashMap<>();
            DSU399 d = new DSU399();

            if (values.length == 0 || queries.length == 0) {
                return ans;
            }

            for (int i = 0; i < values.length; i++) {
                String n1 = equations[i][0];
                String n2 = equations[i][1];
                if (!d.parent.containsKey(n1) && !d.parent.containsKey(n2)) {// n1, n2 not include
                    d.parent.put(n1, n1);
                    d.parent.put(n2, n2);
                    d.rank.put(n1, 1);
                    d.rank.put(n2, 1);
                    val.put(n1, 1.0);
                    val.put(n2, values[i]);
                } else if (!d.parent.containsKey(n1)) {// only n1 not include
                    d.parent.put(n1, n1);
                    d.rank.put(n1, 1);
                    val.put(n1, val.get(n2) / values[i]);
                } else if (!d.parent.containsKey(n2)) {// only n2 not include
                    d.parent.put(n2, n2);
                    d.rank.put(n2, 1);
                    val.put(n2, val.get(n1) * values[i]);
                } else {// n1 n2 both include
                     String p1 = d.find(n1);
                     String p2 = d.find(n2);
                     if (d.rank.get(p1) < d.rank.get(p2)) {//add p1 to p2
                         for (String key: val.keySet()) {
                              if (d.find(key).equals(p1)) {
                                   val.put(key, (val.get(n2) / values[i]) / val.get(key));
                              }
                         }
                     } else {// add p2 to p1
                         for (String key : val.keySet()) {
                             if (d.find(key).equals(p2)) {
                                 val.put(key, val.get(n1) * values[i] * val.get(key));
                             }
                         }
                     }

                }
                d.unite(n1, n2);
            }

            for (int i = 0; i < queries.length; i++) {
                String n1 = queries[i][0];
                String n2 = queries[i][1];
                if (!d.parent.containsKey(n1) || !d.parent.containsKey(n2) || !d.find(n1).equals(d.find(n2))) {
                    ans[i] = -1.0;
                } else {
                    ans[i] = val.get(n2) / val.get(n1);
                }
            }
            return ans;
        }
}

class DSU399 {
    Map<String, String> parent;
    Map<String, Integer> rank;

    DSU399() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    public String find(String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void unite(String x, String y) {
         x = find(x);
         y = find(y);

         if (x.equals(y)) {
             return;
         } else if (rank.get(x) < rank.get(y)) {
             parent.put(x,y);
         } else {
             parent.put(y,x);
             if (rank.get(x) == rank.get(y)) {
                 rank.put(x,rank.get(x)+1);
             }
         }
    }
}