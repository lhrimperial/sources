package com.github.sources.jdk;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.*;

/**
 *
 */
public class QueueSource {

    public static void main(String[] args){
        Queue arrayBlockingQueue = new ArrayBlockingQueue(10);
        Queue linkedBlockingQueue = new LinkedBlockingQueue<>();
        Queue synchronousQueue = new SynchronousQueue<>();
        Queue priorityBlockingQueue = new PriorityBlockingQueue();
        Queue concurrentLinkedQueue = new ConcurrentLinkedQueue<>();



    }
}
