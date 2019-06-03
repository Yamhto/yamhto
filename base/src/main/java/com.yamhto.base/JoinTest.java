package com.yamhto.base;

public class JoinTest {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 8; i++) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }, "t1");
        t1.start();
        t1.join();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }, "t2");
        t2.start();
        t2.join();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 9; i++) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }, "t3").start();
    }

}

