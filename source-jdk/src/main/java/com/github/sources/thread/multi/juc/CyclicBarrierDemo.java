package com.github.sources.thread.multi.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 所有线程都准备好之后一起执行
 */
public class CyclicBarrierDemo {

    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.submit(new Runner(cyclicBarrier, "zhangsan"));
        service.submit(new Runner(cyclicBarrier, "lisi"));
        service.submit(new Runner(cyclicBarrier, "wangwu"));

        service.shutdown();
    }

    public static class Runner implements Runnable {

        private CyclicBarrier cyclicBarrier;
        private String name;

        public Runner(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000*(new Random().nextInt(8)));
                System.out.println(name + " 准备好了");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name+" go....");
        }
    }
}
