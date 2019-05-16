package com.github.sources.thread.forkjoin;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author hairen.long
 * @date 2019-05-15
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {
        //        testAsync();
//        testSync();
        testAsync1();
    }

    public static void testAsync1() {
        CompletableFuture<String> cf =
                CompletableFuture.supplyAsync(
                                () -> {
                                    randomSleep();
                                    System.out.println(
                                            "supplyAsync="
                                                    + Thread.currentThread().getName()
                                                    + "|"
                                                    + Thread.currentThread().isDaemon());
                                    return "message";
                                })
                        .thenApplyAsync(
                                s -> {
                                    randomSleep();
                                    System.out.println(
                                            "thenApplyAsync="
                                                    + Thread.currentThread().getName()
                                                    + "|"
                                                    + Thread.currentThread().isDaemon());
                                    return s.toUpperCase();
                                });
        // gotNow 如果成功就返回结果
        System.out.println(cf.getNow(null));
        // 一直等待成功，然后返回结果
        System.out.println(cf.join());
    }

    public static void testSync() {
        CompletableFuture<String> cf =
                CompletableFuture.completedFuture("message")
                        .thenApply(
                                s -> {
                                    randomSleep();
                                    System.out.println(
                                            "thenApply="
                                                    + Thread.currentThread().getName()
                                                    + "|"
                                                    + Thread.currentThread().isDaemon());
                                    return s.toUpperCase();
                                });
        // gotNow 如果成功就返回结果
        System.out.println(cf.getNow(null));
        // 一直等待成功，然后返回结果
        System.out.println(cf.join());
    }

    private static void randomSleep() {
        Random random = new Random();
        try {
            Thread.sleep(Long.valueOf(random.nextInt(100)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testAsync() throws InterruptedException {
        CompletableFuture<Void> cf =
                CompletableFuture.runAsync(
                        () -> {
                            System.out.println(
                                    "runAsync="
                                            + Thread.currentThread().getName()
                                            + "|"
                                            + Thread.currentThread().isDaemon());
                            try {
                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });

        System.out.println("done=" + cf.isDone());
        TimeUnit.SECONDS.sleep(4);
        System.out.println("done=" + cf.isDone());
    }
}
