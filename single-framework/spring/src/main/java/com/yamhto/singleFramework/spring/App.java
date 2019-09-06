package com.yamhto.singleFramework.spring;

import com.yamhto.singleFramework.spring.bean.SpringBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: App.java
 * @package com.yamhto.singleFramework.spring
 * @description:
 * @date 2019/9/6 16:46
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");

        SpringBean bean = (SpringBean) context.getBean("springBean");

        System.out.println(bean.getId());
    }
}
