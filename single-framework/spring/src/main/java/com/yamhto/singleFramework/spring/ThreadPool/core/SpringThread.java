package com.yamhto.singleFramework.spring.ThreadPool.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: SpringThread.java
 * @package com.yamhto.singleFramework.spring.ThreadPool.core
 * @description:
 * @date 2019/9/29 15:39
 */
public class SpringThread {

    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public void test(){
        System.out.println(executor);
    }
}
