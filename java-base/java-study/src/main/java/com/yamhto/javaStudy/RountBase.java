package com.yamhto.javaStudy;


import com.yamhto.javaStudy.Conf.Conf;

import java.util.Map;


public class RountBase extends Conf {

   public RountBase(){
       super();
   }

    public void invoke(String rount,RountApi rountApi) {

        rountApi.before();

        doInvoke();

        rountApi.after();

        rountApi.fina();

    }


    public void doInvoke() {
        System.out.println("公用做的事");
    }
}
