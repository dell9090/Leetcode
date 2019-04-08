package com.company;
import java.util.*;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
//use stack

class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node); 
            node = node.left;
        }
    }
}

//not use stack
// has parent node

// class BSTIterator implements Iterator<Node> {
//     Node cur = null;

//     BSTIterator(Node root) {
//         if (root == null) {
//             return;
//         }
//         cur = root;
//         while (cur.left != null) {
//             cur = cur.left;
//         }
//     }

//     public boolean hasNext() {
//         return cur != null;
//     }

//     public Node next() {
//         Node tmp = cur;
//         cur = findSuccessor(cur);
//         return temp;
//     }

//     private Node findSuccessor(Node root) {
//         if (root == null) {
//             return null;
//         }
        
//         if (root.right != null) {
//             Node tmp = root.right;
//             while (tmp.left != null) {
//                 tmp = tmp.left;
//             }
//             return tmp;
//         }
        
//         Node father = root.parent;
//         Node child = root;
//         while (father != null && father.right == child) {
//             child = father;
//             father = father.parent;
//         }
//         return father;
//     }
// }





/**
* Your BSTIterator will be called like this:
* BSTIterator i = new BSTIterator(root);
* while (i.hasNext()) v[f()] = i.next();
*/