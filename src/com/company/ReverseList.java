package com.company;
import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    // public ListNode reverseList(ListNode head) {
    //     ListNode cur = head;
    //     ListNode pre = null;
        
    //     while (cur != null) {
    //         ListNode tmp = cur.next;
    //         cur.next = pre;
    //         pre = cur;
    //         cur = tmp;
    //     }
        
    //     return pre;
    // }
    
    //dfs
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}