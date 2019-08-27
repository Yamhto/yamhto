package com.yamhto.java8;

import java.util.function.Function;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: FunctionTest.java
 * @package com.yamhto.java8
 * @description: Function interface test
 * @date 2019/8/19 11:21
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        System.out.println(test.functionTest(2, i-> String.valueOf(i * i)));
    }


    public String functionTest(Integer i, Function<Integer, String> function) {

        return function.apply(i);
    }

}
