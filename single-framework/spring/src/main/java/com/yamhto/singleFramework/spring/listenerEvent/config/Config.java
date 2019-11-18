package com.yamhto.singleFramework.spring.listenerEvent.config;

import com.yamhto.singleFramework.spring.listenerEvent.configRefreshEvent.AfterSpringInitation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: Config.java
 * @package com.yamhto.singleFramework.spring.listenerEvent.config
 * @description:
 * @date 2019/9/29 17:29
 */
@Configuration
public class Config {

    @Bean
    public AfterSpringInitation getAfterSpringInitation(){
        return new AfterSpringInitation();
    }
}
