package com.yamhto.singleFramework.spring.listenerEvent.configRefreshEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: AfterSpringInitation.java
 * @package com.yamhto.singleFramework.spring.listenerEvent.configRefreshEvent
 * @description:
 * @date 2019/9/29 17:21
 */
public class AfterSpringInitation implements ApplicationListener<ContextRefreshedEvent> {

    Map<String, String> map = new HashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();

        if (null != context) {
            map.put("key", "value");
            System.out.println(map);
        }
    }
}
