package com.yamhto.singleFramework.spring.ThreadPool.test;

import com.yamhto.singleFramework.spring.ThreadPool.core.Config;
import com.yamhto.singleFramework.spring.ThreadPool.core.SimpleTheadPool;
import com.yamhto.singleFramework.spring.ThreadPool.core.SpringThread;
import com.yamhto.singleFramework.spring.ThreadPool.core.StaticThreadPool;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: App.java
 * @package com.yamhto.singleFramework.spring.ThreadPool.test
 * @description:
 * @date 2019/9/29 15:38
 */
public class App {


    public static void main(String[] args) {
        testSpringThreadPool();

        //testSimpleThreadPool();

        //testStaticThreadPool();
    }

    /**
     * 测试被Spring管理的线程池
     */
    private static void testSpringThreadPool(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SpringThread bean = context.getBean(SpringThread.class);

        for (int i = 0; i < 5; i++){
            bean.test();
        }
    }

    /**
     * 测试普通的线程池代码
     */
    private static void testSimpleThreadPool(){
        for (int i = 0; i < 5; i++){
            SimpleTheadPool theadPool = new SimpleTheadPool();
            theadPool.test();
        }
    }

    /**
     * 在静态块中实例化线程池
     */
    private static void testStaticThreadPool(){
        for (int i = 0; i < 5; i++){
            StaticThreadPool theadPool = new StaticThreadPool();
            theadPool.test();
        }
    }
}
