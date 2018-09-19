package com.github.sources.thread.akka;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 *
 */
public class WatchActor extends UntypedAbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public WatchActor(ActorRef actorRef) {
        getContext().watch(actorRef);
    }

    @Override
    public void onReceive(Object o) throws Throwable {
        if (o instanceof Terminated) {
            System.out.println(String.format("%s has terminated, shutting down system", ((Terminated) o).getActor().path()));
//            getContext().system().shutdown();
        } else {
            unhandled(o);
        }
    }
}
