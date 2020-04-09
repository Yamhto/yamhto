package com.yamhto.singleFramework.spring.aop;

import java.lang.annotation.*;

/**
 * @author yamhto
 * @className: Log.java
 * @package com.yamhto.singleFramework.spring.aop
 * @description:
 * @date 2020/4/9 17:55
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Log {

    String value() default "";
}
