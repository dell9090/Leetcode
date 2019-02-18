package com.company;

import java.util.HashMap;
import java.util.Map;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class P106 {
    private Map<Integer,Integer> in = new HashMap<>();
    public static void main(String[] args) {
        // write your code here
        P106 p = new P106();
        int[] a = {9,3,15,20,7};
        int[] b = {9,15,7,20,3};
        p.buildTree(a,b);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int start, int end, int index) {
        if (start > end || index < 0) {
            return null;
        }
        int rootidx = postorder[index];
        TreeNode node = new TreeNode(postorder[index]);
        node.right = helper(inorder, postorder, rootidx + 1, end, index - 1);
        node.left = helper(inorder, postorder, start, rootidx - 1, index - (end - rootidx) - 1);
        return node;
    }
}
