package com.yamhto.singleFramework.spring.ThreadPool.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: Config.java
 * @package com.yamhto.singleFramework.spring.ThreadPool.core
 * @description:
 * @date 2019/9/29 15:37
 */

@Configuration
@ComponentScan(basePackages = "com.yamhto.singleFramework.spring.ThreadPool")
public class Config {

    @Bean
    public SpringThread getSpringThread(){
        return new SpringThread();
    }

}
