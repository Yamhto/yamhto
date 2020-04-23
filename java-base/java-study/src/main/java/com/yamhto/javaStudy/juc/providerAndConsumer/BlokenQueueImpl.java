package com.yamhto.javaStudy.juc.providerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yamhto
 * @className: BlokenQueueImpl.java
 * @package com.yamhto.javaStudy.juc.providerAndConsumer
 * @description:
 * @date 2020/4/12 19:55
 */
public class BlokenQueueImpl {

    static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1);


    public static void main(String[] args) throws InterruptedException {

        providerAndConsumer();

    }

    private static void providerAndConsumer() {
        Runnable provider = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);

                while (true) {
                    int value = (int) (Math.random() * 100);
                    System.out.println("product:" + value);
                    blockingQueue.put(value);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                while (true) {
                    System.out.println("consumer:" + blockingQueue.take());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        while (true) {
            new Thread(provider).start();
            new Thread(consumer).start();
        }
    }
}
