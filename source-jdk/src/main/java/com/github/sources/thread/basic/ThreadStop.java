package com.github.sources.thread.basic;

/**
 *
 */
public class ThreadStop {

    public static User user = new User();

    public static void main(String[] args){
        Thread thread1 = new Thread(new ReadObjectThread());
        thread1.start();
        while (true) {
            ChangeObjectThread thread2 = new ChangeObjectThread();
            thread2.start();

            try {
                Thread.sleep(110);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**
             * stop 过于暴力，会破坏数据
             * 可通过一个volatile变量来达到关闭线程的目的
             */
//            thread2.stop();
            thread2.stopMe();
        }

    }

    public static class ChangeObjectThread extends Thread {

        volatile boolean stopMe = false;

        public void stopMe(){
            this.stopMe = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stopMe) {
                    System.out.println("stop thread");
                    break;
                }

                synchronized (user) {
                    int v = (int) (System.currentTimeMillis()/1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread implements Runnable{

        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.valueOf(user.getName())) {
                        System.out.println(user);
                    }
                }
                Thread.yield();
            }
        }
    }

    public static class User{
        private int id;
        private String name;

        public User() {
            this.id = 0;
            this.name = "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
