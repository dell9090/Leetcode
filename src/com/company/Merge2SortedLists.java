package com.company;

 
 
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
   }
    // recursion

    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    //     ListNode ans = new ListNode(0);
    //     ListNode n1 = l1;
    //     ListNode n2 = l2;
    //     ListNode cur = ans;
        
    //     if (n1 == null) {
    //         return n2;
    //     } else if (n2 == null){
    //         return n1;
    //     }
        
    //     if (n1.val <= n2.val) {
    //         cur.next = n1;
    //         cur = cur.next;
    //         cur.next = mergeTwoLists(n1.next, n2);
    //     } else {
    //         cur.next = n2;
    //         cur = cur.next;
    //         cur.next = mergeTwoLists(n1, n2.next);
    //     }
        
    //     return ans.next;
    // }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode cur = res;
        
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                cur.next = n1;
                cur = cur.next;
                n1 = n1.next;
            } else {
                cur.next = n2;
                cur = cur.next;
                n2 = n2.next;
            }
        }
        
        while (n1 != null) {
            cur.next = n1;
            cur = cur.next;
            n1 = n1.next;
        }
        
        while (n2 != null) {
            cur.next = n2;
            cur = cur.next;
            n2 = n2.next;
        }
        return res.next;
    }
}