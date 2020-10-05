package com.github.sources.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author hairen.long
 * @date 2020/3/23
 */
public class FutureDemo {

    public static void main(String[] args) {
        testgetPrice();
        testAsync();
    }

    /** 测试同步API */
    public static void testgetPrice() {
        Shop shop = new Shop("Best Shop");
        long start = System.nanoTime();
        double price = shop.getPrice("mac book pro");
        System.out.printf(shop.getName() + " Price is %.2f%n", price);
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("同步方法调用花费时间:--- " + invocationTime + " --- msecs");

        // ...其他操作
        doSomethingElse();

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("同步方法返回价格所需时间: --- " + retrievalTime + " ---msecs");
    }

    /** 测试异步API */
    public static void testAsync() {
        Shop shop = new Shop("Best Shop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("mac book pro");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("异步方法调用花费时间: --- " + invocationTime + " --- msecs");

        // ...其他操作
        doSomethingElse();

        // 从future对象中读取价格,如果价格未知,则发生阻塞.
        try {
            Double price = futurePrice.get();
            System.out.printf(shop.getName() + " Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("异步方法返回价格所需时间: --- " + retrievalTime + " ---msecs");
    }

    /** 其它操作 */
    public static void doSomethingElse() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
