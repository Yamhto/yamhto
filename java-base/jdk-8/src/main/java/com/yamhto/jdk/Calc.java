package com.yamhto.jdk;


import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: Calc.java
 * @package com.yamhto.jdk
 * @description: 计算类
 * @date 2019/9/3 10:02
 */
public class Calc {

    /**
     * 抽象出行为，也就是将方法当作参数传递
     *
     * @param in
     * @param fun
     * @return
     */
    public String compuse(Integer in, Function<Integer, String> fun) {
        return fun.apply(in);
    }

    public Integer calc(Integer in1, Integer in2, BiFunction<Integer, Integer, Integer> fun) {
        return fun.apply(in1, in2);
    }


    public static void main(String[] args) {

        Calc calc = new Calc();

        System.out.println(calc.compuse(2, (i) -> String.valueOf(i * i)));

        System.out.println(calc.calc(9, 2, (i1, i2) -> i1 * i2));
    }

}


