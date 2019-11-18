package com.yamhto.singleFramework.spring.listenerEvent.test;

import com.yamhto.singleFramework.spring.listenerEvent.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: App.java
 * @package com.yamhto.singleFramework.spring.listenerEvent.test
 * @description:
 * @date 2019/9/29 17:28
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        context.start();
    }
}
