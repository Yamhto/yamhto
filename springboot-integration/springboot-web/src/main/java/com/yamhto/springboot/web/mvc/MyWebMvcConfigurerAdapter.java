package com.yamhto.springboot.web.mvc;

import com.yamhto.springboot.web.Intercept.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author yamhto
 * @className: MyWebMvcConfigurerAdapter.java
 * @package com.yamhto.springboot.web.mvc
 * @description:
 * @date 2020/4/1 18:04
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
    }
}
