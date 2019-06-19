package com.github.sources.jdk;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 */
public class MapSource {

    public static void main(String[] args){
        Map hashTable = new Hashtable();
        Map hashMap = new HashMap();
        Map linkedHashMap = new LinkedHashMap();
        Map treeMap = new TreeMap();
        Map weakHashMap = new WeakHashMap();
        Map concurrentHashMap = new ConcurrentHashMap<>();
        Map concurrentSkipListMap = new ConcurrentSkipListMap<>();
    }
}
