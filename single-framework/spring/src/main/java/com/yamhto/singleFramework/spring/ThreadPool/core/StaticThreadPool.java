package com.yamhto.singleFramework.spring.ThreadPool.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: StaticThreadPool.java
 * @package com.yamhto.singleFramework.spring.ThreadPool.core
 * @description:
 * @date 2019/9/29 15:54
 */
public class StaticThreadPool {

    private static ExecutorService executorService = null;


    static {
        executorService = Executors.newFixedThreadPool(5);
    }

    public void test(){
        System.out.println(executorService);
    }
}
