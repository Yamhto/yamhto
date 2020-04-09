package com.yamhto.spi.core;


import com.yamhto.spi.MySpi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yamhto
 * @className: SpiFactory.java
 * @package com.yamhto.spi.core
 * @description:
 * @date 2020/4/7 10:57
 */
public class SpiFactory {

    public void invoker() {
        ServiceLoader<MySpi> mySpis = ServiceLoader.load(MySpi.class);
        Iterator<MySpi> iterator = mySpis.iterator();

        boolean notFound = true;

        while (iterator.hasNext()) {
            notFound = false;
            MySpi next = iterator.next();
            next.invoker();
        }

        if (notFound) {
            throw new RuntimeException("未找到spi实现========================");
        }
    }
}
