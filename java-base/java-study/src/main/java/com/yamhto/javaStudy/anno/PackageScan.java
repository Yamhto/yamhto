package com.yamhto.javaStudy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: PackageScan.java
 * @package com.yamhto.javaStudy.anno
 * @description:
 * @date 2019/11/18 10:36
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PackageScan {

    String packageName() default "";
}
