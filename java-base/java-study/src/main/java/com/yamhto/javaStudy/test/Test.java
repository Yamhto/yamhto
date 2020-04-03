package com.yamhto.javaStudy.test;

import com.yamhto.javaStudy.Conf.Conf;
import com.yamhto.javaStudy.Conf.Start;
import com.yamhto.javaStudy.RountApi;
import com.yamhto.javaStudy.RountBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: Test.java
 * @package com.yamhto.javaStudy.test
 * @description:
 * @date 2019/11/15 17:49
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Start start = new Start();
        Conf conf = start.start(Conf.class);

        Map<String, Object> map = conf.getMap();

        System.out.println(map.size());

        RountBase a = (RountBase) map.get("B");

        RountApi api = (RountApi) map.get("B");

        a.invoke("B", api);




    }
}
