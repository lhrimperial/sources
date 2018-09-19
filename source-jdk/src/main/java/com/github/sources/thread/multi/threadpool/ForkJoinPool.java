package com.github.sources.thread.multi.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 *
 */
public class ForkJoinPool {

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        java.util.concurrent.ForkJoinPool forkJoinPool = new java.util.concurrent.ForkJoinPool();
        CountTask task = new CountTask(0, 2000000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
            System.out.println("res is " + res);
            System.out.println("use time " + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 2000000L; i++) {
            sum += i;
        }
        System.out.println("res is " + sum);
        System.out.println("use time " + (System.currentTimeMillis() - start));
    }

    public static class CountTask extends RecursiveTask<Long> {

        private static final int THRESHOLD = 10000;
        private long start;
        private long end;

        public CountTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long sum = 0;
            if ((end - start) < THRESHOLD) {
                for (long i = start; i < end; i++) {
                    sum += i;
                }
            } else {
                long step = (start + end) / 1000;
                List<CountTask> subTask = new ArrayList<>();
                long pos = start;
                CountTask task = null;
                for (int i = 0; i < 1000; i++) {
                    long last = pos + step;
                    if (last > end) {
                        last = end;
                    }
                    task = new CountTask(pos, last);
                    pos += step;
                    subTask.add(task);
                    task.fork();
                }
                for (CountTask task1 : subTask) {
                    sum += task1.join();
                }
            }
            return sum;
        }
    }
}
