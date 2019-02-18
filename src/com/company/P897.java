package com.company;

import java.util.ArrayList;
import java.util.List;


public class P897 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        search(root, vals);

        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }
    public void search(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        search(node.left, vals);
        vals.add(node.val);
        search(node.right, vals);
    }
}
