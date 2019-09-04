package com.yamhto.singleFramework.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.Arrays;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: MySqlSessionFactory.java
 * @package com.yamhto.singleFramework.mybatis
 * @description: 获取，关闭session
 * @date 2019/9/4 15:09
 */
public class MySqlSessionFactory {

    private static SqlSessionFactory factory;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {

        return factory.openSession();
    }

    public static void closeSession(Closeable... closes) {
        Arrays.asList(closes).forEach(close -> {
            if (null != close) {
                try {
                    close.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
