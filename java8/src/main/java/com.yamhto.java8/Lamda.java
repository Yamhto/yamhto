package com.yamhto.java8;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: Lamda.java
 * @package com.yamhto.java8
 * @description:
 * @date 2019/8/6 12:48
 */
public class Lamda {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.forEach(i -> {
            System.out.println(i);
        });
    }
}
