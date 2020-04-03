package com.yamhto.springboot.web.controller;

import com.yamhto.springboot.web.logAspect.SysLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yamhto
 * @className: HelloController.java
 * @package com.yamhto.springboot.web.controller
 * @description:
 * @date 2020/4/1 9:37
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    @SysLog
    public String say(){
        System.out.println("controller ==============");
        return "hello";
    }
}
