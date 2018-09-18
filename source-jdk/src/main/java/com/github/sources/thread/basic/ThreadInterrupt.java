package com.github.sources.thread.basic;

/**
 *
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws Exception{
//        noDealInterrupt();
//        dealInterrupt();
        dealInterruptException();
    }

    public static void dealInterruptException () throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread is interrupt");
                        break;
                    }

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupt when sleep");
                        //Thread.sleep()方法由于中断而抛出异常，此时，他会清除中断标记，所以在异常处理中，再次设置中断标记。
                        Thread.currentThread().interrupt();
                    }

                    Thread.yield();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    public static void dealInterrupt() throws  Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("thread is interrupt");
                        break;
                    }
                    Thread.yield();
                }
            }
        });

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    public static void noDealInterrupt() throws Exception{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Thread.yield();
                }
            }
        });

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
