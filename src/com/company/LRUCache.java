package com.company;

import java.util.*;

class LRUCache {
    class ListNode {
        int val;
        int key;
        ListNode prev;
        ListNode next;
        
        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
            prev = null;
            next = null;
        }
        
    }
    
    Map<Integer, ListNode> map;
    ListNode head ;
    ListNode tail;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } 
        
        ListNode cur = map.get(key);
        remove(cur);
        insert(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode cur = map.get(key);
            remove(cur);
            insert(cur);
            cur.val = value;
        } else {
            if (map.size() >= capacity) {
                map.remove(head.next.key);
                remove(head.next);
            } 
            ListNode cur = new ListNode(key, value);
            insert(cur);
            map.put(key, cur);
        }
        
    }
    
    public void insert(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }
    
    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}