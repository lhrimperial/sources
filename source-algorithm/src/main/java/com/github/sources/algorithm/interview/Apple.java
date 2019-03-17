package com.github.sources.algorithm.interview;

/**
 * 评测题目: 共计9个苹果，有2只猴子，一个猴子每次拿2个苹果，一个猴子每次拿3个苹果，如果剩余的苹果不够猴子每次拿的数量，则2只猴子停止拿苹果。
 */
public class Apple {
    public int appleCount = 9;
    public static void main(String[] args){
        Apple apple = new Apple();
        Thread monkey1 = new Thread(new Monkey(2, apple));
        Thread monkey2 = new Thread(new Monkey(3, apple));
        monkey1.start();
        monkey2.start();
    }
}

class Monkey implements Runnable {

    private int num;
    private Apple apple;

    public Monkey(int num, Apple apple) {
        this.num = num;
        this.apple = apple;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (apple) {
                if (apple.appleCount < num) {
                    break;
                } else {
                    apple.appleCount = apple.appleCount - num;
                }
                System.out.println("消费了"+num+"剩余"+apple.appleCount);
            }
        }
    }
}