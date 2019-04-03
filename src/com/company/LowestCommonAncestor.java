package com.company;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// p, q must exist in the tree
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null || root == p || root == q)  {
//             return root;
//         }
        
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
        
//         if (left != null && right != null) {// different branch
//             return root;
//         }  
        
//         return left != null ? left : right;//same branch
        
//     }
// }


// p,q may not exist
class Solution {
    
    TreeNode single = new TreeNode(Integer.MAX_VALUE);
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tmp = helper(root, p, q);
        if (tmp == null || tmp == single) {
            return null;
        }
        return tmp;
    }
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode tl = helper(root.left,  p, q);
        TreeNode tr = helper(root.right, p, q);
        
        if (root == p || root == q) {
            if (tl != null || tr != null) {
                return root;
            }
            return single;
        }
        return tl == null ? tr : (tr == null ? tl : root);
    }
}