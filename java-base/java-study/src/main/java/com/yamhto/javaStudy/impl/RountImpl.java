package com.yamhto.javaStudy.impl;

import com.yamhto.javaStudy.RountApi;
import com.yamhto.javaStudy.RountBase;
import com.yamhto.javaStudy.anno.Rount;

@Rount(value = "A")
public class RountImpl extends RountBase implements RountApi {

    @Override
    public void before() {
        System.out.println("A:before");
    }

    @Override
    public void after() {
        System.out.println("A:after");
    }

    @Override
    public void fina() {
        System.out.println("A:fina");
    }
}
