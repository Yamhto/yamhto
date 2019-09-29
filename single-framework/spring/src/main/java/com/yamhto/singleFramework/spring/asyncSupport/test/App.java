package com.yamhto.singleFramework.spring.asyncSupport.test;

import com.yamhto.singleFramework.spring.asyncSupport.core.AsyncConfig;
import com.yamhto.singleFramework.spring.asyncSupport.core.AsyncConfigImpl;
import com.yamhto.singleFramework.spring.asyncSupport.core.AsyncTask;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: App.java
 * @package com.yamhto.singleFramework.spring.asyncSupport.test
 * @description:
 * @date 2019/9/24 10:24
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        //testAsyncConfig();

        testAsyncConfigImpl();
    }

    private static void testAsyncConfig() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class);
        AsyncTask task = context.getBean(AsyncTask.class);

        for (int i = 0; i <= 9; i++) {
            task.fun1();
            task.fun2();
        }
    }

    private static void testAsyncConfigImpl() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfigImpl.class);
        AsyncTask task = context.getBean(AsyncTask.class);

        for (int i = 0; i <= 9; i++) {

            task.fun1();
            //task.fun2();
        }

    }


}
