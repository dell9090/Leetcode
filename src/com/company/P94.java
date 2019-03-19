package com.company;

import java.util.*;
/**
 * Definition for a binary tree node.
 */



class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }

    // stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
    
    // liner tree
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List <Integer> res = new ArrayList<>();
    //     TreeNode cur = root;
    //     TreeNode pre = null;
    //     while (cur != null) {
    //         if (cur.left == null) {
    //             res.add(cur.val);
    //             cur = cur.right;
    //         } else {
    //             pre = cur.left;
    //             while (pre.right != null) {
    //                 pre = pre.right;
    //             }
    //             pre.right = cur;
    //             TreeNode temp = cur;
    //             cur = cur.left;
    //             temp.left = null;
    //         }
    //     }
    //     return res;
    // }
}