package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class P726 {
    public String countOfAtoms(String formula) {
            int N = formula.length();
            Stack<HashMap<String, Integer>> stack = new Stack();
            stack.push(new HashMap<String, Integer>());

            for (int i = 0; i < N;) {
                if (formula.charAt(i) == '(') {
                    stack.push(new HashMap<String, Integer>());
                    i++;
                } else if (formula.charAt(i) == ')') {
                    HashMap<String, Integer> top = stack.pop();
                    int iStart = ++i, multiplicity = 1;
                    for (;i < N && Character.isDigit(formula.charAt(i));i++) {
                    }
                    if (i > iStart) {
                        multiplicity = Integer.parseInt(formula.substring(iStart, i));
                    }
                    for (String c: top.keySet()) {
                        int v = top.get(c);
                        stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity);
                    }
                } else {
                    int iStart = i++;
                    while (i < N && Character.isLowerCase(formula.charAt(i))) i++;
                    String name = formula.substring(iStart, i);
                    iStart = i;
                    while (i < N && Character.isDigit(formula.charAt(i))) i++;
                    int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                    stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
                }
            }

            StringBuilder ans = new StringBuilder();
            for (String name: stack.peek().keySet()) {
                ans.append(name);
                int multiplicity = stack.peek().get(name);
                if (multiplicity > 1) ans.append("" + multiplicity);
            }
            return new String(ans);
    }
}
