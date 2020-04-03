package com.yamhto.springboot.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yamhto
 * @className: TestController.java
 * @package com.yamhto.springboot.springsecurity.controller
 * @description:
 * @date 2020/3/26 15:04
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Security";
    }
}
