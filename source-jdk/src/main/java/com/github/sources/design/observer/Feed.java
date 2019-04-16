package com.github.sources.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hairen.long
 * @date 2019-03-31
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObserver(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }


    public static void main(String[] args){
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Grardian());
        f.registerObserver(new Lemonde());

        f.notifyObserver("the queen said her favourite book is java 8 in action");
    }
}
