package com.yamhto.singleFramework.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yamhto
 * @className: Aspect.java
 * @package com.yamhto.singleFramework.spring.aop
 * @description:
 * @date 2020/4/9 17:55
 */
@org.aspectj.lang.annotation.Aspect
public class Aspect {


    @Pointcut("@annotation(com.yamhto.singleFramework.spring.aop.Log)")
    public void logPoint() {
    }

    @Around("logPoint()")
    public Object around(@org.jetbrains.annotations.NotNull ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        System.out.println(point.getTarget().getClass().getSimpleName() + ";任务开始时间：" + beginTime);
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        System.out.println(point.getTarget().getClass().getSimpleName() + ";任务结束时间：" + time);
        //保存日志

        return result;
    }
}
