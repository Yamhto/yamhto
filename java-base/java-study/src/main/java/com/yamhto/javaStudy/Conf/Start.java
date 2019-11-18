package com.yamhto.javaStudy.Conf;

import com.yamhto.javaStudy.anno.PackageScan;

import java.lang.annotation.Annotation;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: Start.java
 * @package com.yamhto.javaStudy
 * @description:
 * @date 2019/11/15 17:42
 */
public class Start {

    public Conf start(Class<?> c) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        PackageScan annotation = c.getAnnotation(PackageScan.class);

        String s = annotation.packageName();

         return new Conf(s);
    }
}
