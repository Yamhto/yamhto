package com.yamhto.springboot.springsecurity.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author yamhto
 * @className: UserDetailServiceImpl.java
 * @package com.yamhto.springboot.springsecurity.config
 * @description:
 * @date 2020/3/26 15:08
 */

@Component
public class UserDetailServiceImpl implements UserDetailsService {
    /**
     * 用户校验
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Collection<GrantedAuthority> collection = new ArrayList<>();//权限集合
        String password = new BCryptPasswordEncoder().encode("123456");
        User user = new User(s,password,collection);

        return user;
    }

}
