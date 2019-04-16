package com.github.sources.design.observer;

/**
 * @author hairen.long
 * @date 2019-03-31
 */
public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
