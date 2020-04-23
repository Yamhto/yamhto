package com.yamhto.javaStudy.juc.providerAndConsumer;

import java.util.Random;

/**
 * @author yamhto
 * @className: Data.java
 * @package com.yamhto.javaStudy.juc.providerAndConsumer
 * @description:
 * @date 2020/4/12 20:18
 */
public class Data {

    String value;

    Data(String value) {
        System.out.println("product :" + value);
        this.value = value;
    }
}
