package com.github.sources.jdk;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 */
public class DequeSource {

    public static void main(String[] args){
        Deque linkedBlockingDeque = new LinkedBlockingDeque<>();
        Deque arrayDeque = new ArrayDeque();
        Deque concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
    }
}
