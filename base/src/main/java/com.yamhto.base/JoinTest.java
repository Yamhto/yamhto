package com.yamhto.base;

import java.util.concurrent.CountDownLatch;

public class JoinTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 80; i++) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
                //countDownLatch.countDown();
            }
        }, "t1");
        t1.start();
        t1.join();
        //countDownLatch.await();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }, "t2");
        t2.start();
        t2.join();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 90; i++) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }, "t3").start();
    }

}

