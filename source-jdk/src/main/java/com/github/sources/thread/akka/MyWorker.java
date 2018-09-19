package com.github.sources.thread.akka;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 *
 */
public class MyWorker extends UntypedAbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public static enum Msg {
        WORKING, DONE, CLOSE;
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("MyWorker is starting.....");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("MyWorker is stop.....");
    }

    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg == Msg.WORKING) {
            System.out.println("I am working....");
        } else if (msg == Msg.DONE) {
            System.out.println("stop working.....");
        } else if (msg == Msg.CLOSE) {
            System.out.println("i will shutdown");
            getSender().tell(Msg.CLOSE, getSelf());
            getContext().stop(getSelf());
        } else {
            unhandled(msg);
        }
    }
}
