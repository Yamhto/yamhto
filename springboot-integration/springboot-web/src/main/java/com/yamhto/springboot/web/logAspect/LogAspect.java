package com.yamhto.springboot.web.logAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yamhto
 * @className: LogAspect.java
 * @package com.yamhto.springboot.web.logAspect
 * @description:
 * @date 2020/4/3 11:33
 */
@Aspect
@Component
public class LogAspect {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.yamhto.springboot.web.logAspect.SysLog)")
    public void logPointCut() {

    }


    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        log.info(point.getTarget().getClass().getSimpleName()+ ";任务开始时间：{}",beginTime);
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        log.info(point.getTarget().getClass().getSimpleName() + ";任务结束时间：{}",time);
        //保存日志

        return result;
    }
}
