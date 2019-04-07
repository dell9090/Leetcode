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

// dfs recursion 0ms 40mb

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// dfs iterate 2ms 39.7mb

// class Solution {
//     public int maxDepth(TreeNode root) {
//         class NodePair {
//             public TreeNode node;
//             public int depth;
//             NodePair(TreeNode node, int depth) {
//                 this.node = node;
//                 this.depth = depth;
//             }
//         }
        
//         int max = 0;
//         Stack<NodePair> stack = new Stack<>();
//         NodePair cur = new NodePair(root, 1);
//         stack.push(cur);
//         if (root == null) {
//             return 0;
//         }
//         while (!stack.isEmpty()) {
//             cur = stack.pop();
//             max = Math.max(max, cur.depth);
//             if (cur.node.left != null) {
//                 NodePair temp = new NodePair(cur.node.left, cur.depth + 1);
//                 stack.push(temp);
//             }
//             if (cur.node.right != null) {
//                 NodePair temp = new NodePair(cur.node.right, cur.depth + 1);
//                 stack.push(temp);
//             }
//         }
//         return max;
//     }
// }

// bfs recursion  1ms 39.8mb

// class Solution {
//     public int maxDepth(TreeNode root) {
//          int depth = 0;
//         if (root == null) {
//           return 0;  
//         }
//         List<TreeNode> temp = new LinkedList<>();
//         temp.add(root);
//         return search(temp);
//     }
    
//     private int search(List<TreeNode> nodeList) {
//         List<TreeNode> res = new LinkedList<>();
//         if (nodeList.isEmpty()) {
//             return 0;
//         }
        
//         for (TreeNode node : nodeList) {
//             if (node.left != null) {
//                 res.add(node.left);
//             }
//             if (node.right != null) {
//                 res.add(node.right);
//             }
//         }        
//         return search(res) + 1;
//     }
// }

//bfs iterate
