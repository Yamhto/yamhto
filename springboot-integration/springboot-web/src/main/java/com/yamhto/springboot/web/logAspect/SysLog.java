package com.yamhto.springboot.web.logAspect;

import java.lang.annotation.*;

/**
 * @author yamhto
 * @className: SysLog.java
 * @package com.yamhto.springboot.web.logAspect
 * @description:
 * @date 2020/4/3 11:32
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
