package com.yamhto.spi.test;

import com.yamhto.spi.core.SpiFactory;

/**
 * @author yamhto
 * @className: TestSpi.java
 * @package com.yamhto.spi.test
 * @description:
 * @date 2020/4/7 11:02
 */
public class TestSpi {

    public static void main(String[] args) {
        SpiFactory factory = new SpiFactory();
        factory.invoker();
    }
}
