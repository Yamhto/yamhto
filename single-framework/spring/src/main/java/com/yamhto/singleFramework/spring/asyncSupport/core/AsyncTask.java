package com.yamhto.singleFramework.spring.asyncSupport.core;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: AsyncTask.java
 * @package com.yamhto.singleFramework.spring.asyncSupport.core
 * @description:
 * @date 2019/9/24 10:26
 */
@Component
public class AsyncTask {

    @Async    // 这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行
    public void fun1() throws InterruptedException {
        System.out.println("f1 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        int sleepTime = new Random().nextInt(100);
        Thread.sleep(sleepTime);
        if (sleepTime < 50) {
            throw new InterruptedException("------异常信息---");
        }
    }

    @Async
    public void fun2() {
        System.out.println("f2 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
