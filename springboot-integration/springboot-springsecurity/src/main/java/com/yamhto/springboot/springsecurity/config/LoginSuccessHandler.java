package com.yamhto.springboot.springsecurity.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yamhto
 * @className: LoginSuccessHandler.java
 * @package com.yamhto.springboot.springsecurity.config
 * @description:
 * @date 2020/3/26 15:09
 */

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        httpServletResponse.setContentType("application/json;charset=UTF-8");

        httpServletResponse.getWriter().write(authentication.getName());
    }
}
