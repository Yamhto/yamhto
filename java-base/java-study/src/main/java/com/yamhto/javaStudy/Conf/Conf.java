package com.yamhto.javaStudy.Conf;

import com.yamhto.javaStudy.RountBase;
import com.yamhto.javaStudy.anno.Before;
import com.yamhto.javaStudy.anno.PackageScan;
import com.yamhto.javaStudy.anno.Rount;
import org.reflections.Reflections;

import java.util.*;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: Conf.java
 * @package com.yamhto.javaStudy.Conf
 * @description:
 * @date 2019/11/15 17:31
 */
@PackageScan(packageName = "com.yamhto.javaStudy.impl")
public class Conf {

    Map<String, Object> map;

    String packagePath;

    public Conf() {
        map = new HashMap<String, Object>();
    }

    public Conf(String packagePath) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        map = new HashMap<String, Object>();
        this.packagePath = packagePath;
        init();
    }


    @Before
    public void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections(packagePath);
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Rount.class);

        for (Class<?> cl : typesAnnotatedWith) {
            Class<?> aClass = Class.forName(cl.getName());
            Rount annotation = cl.getAnnotation(Rount.class);
            RountBase rount = (RountBase) aClass.newInstance();
            map.put(annotation.value(), rount);
            System.out.println("key:" + annotation.value() + "--value:" + rount + "放入容器中");
        }
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
