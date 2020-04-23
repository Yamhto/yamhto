package com.yamhto.javaStudy.juc.futureAndCompletableFuture;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author yamhto
 * @className: CompletableFutureTest.java
 * @package com.yamhto.javaStudy.juc.futureAndCompletableFuture
 * @description:
 * @date 2020/4/23 9:43
 */
public class CompletableFutureTest {

    public static ThreadPoolExecutor executor;

    static {
        executor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new SynchronousQueue<>());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture
                // 执行异步任务
                .supplyAsync(() -> {
                    return new Random().nextInt(100);
                }, executor)
                // 对上一步的结果进行处理
                .thenApply(n -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int res = new Random().nextInt(100);
                    System.out.println(String.format("如果是同步的，这条消息应该先输出。上一步结果：%s，新加：%s", n, res));
                    return n + res;
                });

        System.out.println("我等了你2秒");
        System.out.println(future.get());

        executor.shutdown();
    }
}
