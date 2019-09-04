package com.yamhto.singleFramework.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.Arrays;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: SqlSessionFactory.java
 * @package com.yamhto.singleFramework.mybatis
 * @description:
 * @date 2019/9/4 15:09
 */
public class SqlSessionFactory {

    public static SqlSession getSqlSession() {

        try {
            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
