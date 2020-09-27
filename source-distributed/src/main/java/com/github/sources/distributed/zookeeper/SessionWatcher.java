package com.github.sources.distributed.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class SessionWatcher implements Watcher {

    private Logger log = LoggerFactory.getLogger(SessionWatcher.class);

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            log.info("get zookeeper success");
        }
    }
}
