###Spirng Async Support
```text
two method:
    1。直接配置异步线程池
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
    2. extends AsyncConfigurerSupport
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
                       Systssem.out.print("error in " + method + "error msg :" + t.getMessage());
           }
       
       }

    eg: 推荐使用后面的那种，因为后面那种方式兼容了异常的处理情况。
```