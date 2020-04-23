package com.yamhto.javaStudy.jvm.Error;

import java.util.Random;

/**
 * @author yamhto
 * @className: OomTest.java
 * @package com.yamhto.javaStudy.jvm.Error
 * @description:
 * @date 2020/4/12 14:56
 */
public class OomTest {
    public static void main(String[] args) {
        oom();
    }

    private static void oom() {
        String str = "OOM";
        while (true){
            str = str + new Random().nextInt(999999999) + new Random().nextInt(888888888);
        }
    }
}
