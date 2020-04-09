package com.yamhto.javaStudy.juc;

import java.util.concurrent.*;

/**
 * @author yamhto
 * @className: TestThreedPool.java
 * @package com.yamhto.javaStudy.juc
 * @description:
 * @date 2020/4/8 16:08
 */
public class TestThreedPool {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = new ThreadPoolExecutor(3, Runtime.getRuntime().availableProcessors(), 20, TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(8), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 1; i <= 20; i++) {
                final int temp = i;
                executorService.execute(() -> {

                    System.out.println(Thread.currentThread().getName() + "在占用" + temp);
                });
            }
        } catch (Exception e) {

        }

        executorService.shutdown();
    }
}
