package com.company;

import java.util.*;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    class ListNode { 
        int val; 
        ListNode next; 
        ListNode(int x) { val = x; } 
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
         
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode l1 = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }
    
    private ListNode reverse(ListNode head) {
      ListNode pre = null, cur = head, next = null;
      while (cur != null) {
        next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
      }
      return pre;
    }
    
    private void merge(ListNode l1, ListNode l2) { 
         while (l1 != null) {
             ListNode n1 = l1.next;
             ListNode n2 = l2.next;
             l1.next = l2;
             if (n1 == null) {
                 break;
             }
             l2.next = n1;
             l1 = n1;
             l2 = n2;
         }       
    }
}