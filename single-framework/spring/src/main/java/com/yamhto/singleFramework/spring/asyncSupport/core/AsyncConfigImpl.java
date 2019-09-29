package com.yamhto.singleFramework.spring.asyncSupport.core;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: AsyncConfigImpl.java
 * @package com.yamhto.singleFramework.spring.asyncSupport.core
 * @description:
 * @date 2019/9/24 10:42
 */
@EnableAsync
@ComponentScan(basePackages = "com.yamhto.singleFramework.spring.asyncSupport.core")
public class AsyncConfigImpl extends AsyncConfigurerSupport {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(10);
        //配置队列大小
        executor.setQueueCapacity(25);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("ym-executor-support");
        //执行初始化
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (t, method, obj) ->
                System.out.print("error in " + method + "error msg :" + t.getMessage());
    }

}
