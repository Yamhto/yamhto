package com.yamhto.javaStudy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: Before.java
 * @package com.yamhto.javaStudy.anno
 * @description:
 * @date 2019/11/15 17:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Before {

    String value() default "";
}
