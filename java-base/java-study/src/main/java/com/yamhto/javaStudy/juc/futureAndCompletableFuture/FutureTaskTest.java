package com.yamhto.javaStudy.juc.futureAndCompletableFuture;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author yamhto
 * @className: FutureTaskTest.java
 * @package com.yamhto.javaStudy.juc.futureAndCompletableFuture
 * @description: Future.get()是阻塞的
 * @date 2020/4/23 9:33
 */
public class FutureTaskTest {

    public static ThreadPoolExecutor executor;

    static {
        executor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new SynchronousQueue<>());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Integer> future = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(2);

            return new Random().nextInt(1299);
        });


        System.out.println(future.get());
        System.out.println("如果阻塞，会在2s之后获取到结果");

        executor.shutdown();
    }
}
