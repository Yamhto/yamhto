package com.yamhto.spi.impl.one;

import com.yamhto.spi.MySpi;

/**
 * @author yamhto
 * @className: JavaSpiImpl.java
 * @package com.yamhto.spi.impl.one
 * @description:
 * @date 2020/4/7 10:52
 */
public class JavaSpiImpl implements MySpi {

    public void invoker() {
        System.out.println("Java spi impl==================");
    }
}
