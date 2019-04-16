package com.github.sources.design.observer;

/**
 * @author hairen.long
 * @date 2019-03-31
 */
public interface Subject {

    void registerObserver(Observer observer);

    void notifyObserver(String tweet);
}
