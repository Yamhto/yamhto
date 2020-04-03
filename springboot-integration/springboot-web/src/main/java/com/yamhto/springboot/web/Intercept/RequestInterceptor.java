package com.yamhto.springboot.web.Intercept;

import org.apache.commons.io.IOUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yamhto
 * @className: RequestInterceptor.java
 * @package com.yamhto.springboot.web.Intercept
 * @description:
 * @date 2020/4/1 17:54
 */
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        byte[] bytes = IOUtils.toByteArray(request.getInputStream());
        System.out.println("request ===============================");
        return true;
    }
}
