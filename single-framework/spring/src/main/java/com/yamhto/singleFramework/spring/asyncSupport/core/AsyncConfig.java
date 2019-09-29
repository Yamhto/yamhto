package com.yamhto.singleFramework.spring.asyncSupport.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: AsyncConfig.java
 * @package com.yamhto.singleFramework.spring.asyncSupport.core
 * @description:
 * @date 2019/9/24 10:21
 */
//@Configuration
@EnableAsync
@ComponentScan(basePackages = "com.yamhto.singleFramework.spring.asyncSupport.core")
public class AsyncConfig {

    @Bean
    public ThreadPoolTaskExecutor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(10);
        //配置队列大小
        executor.setQueueCapacity(25);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("ym-executor-");
        //执行初始化
        executor.initialize();
        return executor;
    }


}
