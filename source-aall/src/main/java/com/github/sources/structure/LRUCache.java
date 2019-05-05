package com.github.sources.structure;

import java.util.HashMap;

/**
 * @author hairen.long
 * @date 2019-05-01
 */
public class LRUCache {

    class LRUNode{
        private String code;
        private Object value;
        private LRUNode next;
        private LRUNode prev;

        public LRUNode(String code, Object value){
            this.code = code;
            this.value = value;
        }
    }

    private HashMap<String,LRUNode> cache = new HashMap<>();

    public static void main(String[] args){
        System.out.println("hello world");
    }
}
