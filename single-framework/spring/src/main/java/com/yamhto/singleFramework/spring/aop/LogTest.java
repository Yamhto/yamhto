package com.yamhto.singleFramework.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author yamhto
 * @className: LogTest.java
 * @package com.yamhto.singleFramework.spring.aop
 * @description:
 * @date 2020/4/9 17:59
 */
public class LogTest {

    @Log
    public void test(){
        System.out.println("=====================================");
    }
}
