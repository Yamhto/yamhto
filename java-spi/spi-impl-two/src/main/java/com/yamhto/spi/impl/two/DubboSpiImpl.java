package com.yamhto.spi.impl.two;

import com.yamhto.spi.MySpi;

/**
 * @author yamhto
 * @className: DubboSpiImpl.java
 * @package com.yamhto.spi.impl.two
 * @description:
 * @date 2020/4/7 10:55
 */
public class DubboSpiImpl implements MySpi {
    public void invoker() {
        System.out.println("dubbo spi impl==================");
    }
}
