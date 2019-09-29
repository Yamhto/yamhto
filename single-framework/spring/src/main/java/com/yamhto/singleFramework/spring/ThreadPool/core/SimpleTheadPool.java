package com.yamhto.singleFramework.spring.ThreadPool.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: SimpleTheadPool.java
 * @package com.yamhto.singleFramework.spring.ThreadPool.core
 * @description:
 * @date 2019/9/29 15:48
 */
public class SimpleTheadPool {

   private ExecutorService executorService = Executors.newFixedThreadPool(5);

   public void test(){
       System.out.println(executorService);
   }

}
