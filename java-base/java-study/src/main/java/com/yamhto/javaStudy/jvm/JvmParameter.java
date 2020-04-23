package com.yamhto.javaStudy.jvm;

/**
 * @author yamhto
 * @className: JvmParameter.java
 * @package com.yamhto.javaStudy.jvm
 * @description:
 * -Xmx:最大运行内存
 * -Xms:初始运行内存
 * -Xmn:新生代所占内存
 * @date 2020/4/12 14:42
 */
public class JvmParameter {

    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("-xmx:" + (maxMemory / 1024 / 1024) + "MB");
        System.out.println("-xms:" + (totalMemory / 1024 / 1024) + "MB");
    }
}
