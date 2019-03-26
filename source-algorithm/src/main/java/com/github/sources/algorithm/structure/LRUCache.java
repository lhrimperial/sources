package com.github.sources.algorithm.structure;

import java.util.HashMap;

public class LRUCache {
    class LRUNode{
        private String key;
        private Object value;
        private LRUNode prev;
        private LRUNode next;

        public LRUNode(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<String, LRUNode> map;
    private int capacity;
    private LRUNode head;
    private LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    public void set(String key, Object value) {
        LRUNode node = map.get(key);
        if (node != null) {
            node.value = value;
            remove(node, false);
        } else {
            node = new LRUNode(key, value);
            if (map.size() > capacity) {
                remove(tail, true);
            }
            map.put(key, node);
        }
        setHead(node);
    }

    public Object get(String key) {
        LRUNode node = map.get(key);
        if (node != null) {
            remove(node, false);
            setHead(node);
            return node.value;
        }
        return null;
    }

    public void setHead(LRUNode node) {
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    public void remove(LRUNode node, boolean flag) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        node.prev = null;
        node.next = null;
        if (flag) {
            map.remove(node.key);
        }
    }
}
