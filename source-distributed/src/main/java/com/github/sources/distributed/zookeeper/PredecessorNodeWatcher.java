package com.github.sources.distributed.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.locks.Condition;

/**
 *
 */
public class PredecessorNodeWatcher implements Watcher{

    private Condition condition = null;

    public PredecessorNodeWatcher(Condition condition) {
        this.condition = condition;
    }

    public void process(WatchedEvent event) {
        //前序节点被删除，锁被释放，唤醒当前等待线程
        if(event.getType() == Event.EventType.NodeDeleted){
            condition.signal();
        }
    }
}
