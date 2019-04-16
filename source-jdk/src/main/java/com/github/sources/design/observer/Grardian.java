package com.github.sources.design.observer;

/**
 * @author hairen.long
 * @date 2019-03-31
 */
public class Grardian implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Breaking news in Grardian! " + tweet);
        }
    }
}
