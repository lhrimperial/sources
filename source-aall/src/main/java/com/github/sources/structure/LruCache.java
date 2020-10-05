package com.github.sources.structure;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author hairen.long
 * @date 2019-06-20
 */
public class LruCache {

    private Map<String, LruNode> container;
    private int capacity;
    private LruNode head;
    private LruNode tail;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.container = new HashMap<>(capacity);
    }

    public void set(String key, Object value) {
        LruNode node = container.get(key);
        if (Objects.nonNull(node)) {
            node.setValue(value);
            remove(node, false);
        } else {
            node = new LruNode(key, value);
            if (container.size() > capacity) {
                remove(tail, true);
            }
            container.put(key, node);
        }
        setHead(node);
    }

    public Object get(String key) {
        LruNode node = container.get(key);
        if (Objects.nonNull(node)) {
            remove(node, false);
            setHead(node);
            return node.getValue();
        }
        return null;
    }

    public void setHead(LruNode node) {
        if (Objects.nonNull(head) && Objects.nonNull(node)) {
            head.prev = node;
            node.next = head;
        }
        head = node;
        if (Objects.isNull(tail)) {
            tail = node;
        }
    }

    private void remove(LruNode node, boolean realRemove) {
        if (Objects.isNull(node)) {
            return;
        }
        if (Objects.nonNull(node.prev)) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (Objects.nonNull(node.next)) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        if (realRemove) {
            container.remove(node);
        }
    }

    @Data
    public static class LruNode {
        private String key;
        private Object value;
        private LruNode prev;
        private LruNode next;

        public LruNode(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
