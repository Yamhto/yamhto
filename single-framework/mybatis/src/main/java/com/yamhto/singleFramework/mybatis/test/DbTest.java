package com.yamhto.singleFramework.mybatis.test;

import com.yamhto.singleFramework.mybatis.SqlSessionFactory;
import com.yamhto.singleFramework.mybatis.bean.Hr;
import com.yamhto.singleFramework.mybatis.mapping.HrMapper;
import org.apache.ibatis.session.SqlSession;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: DbTest.java
 * @package com.yamhto.singleFramework.mybatis.test
 * @description:
 * @date 2019/9/4 16:04
 */
public class DbTest {

    public static void main(String[] args) {
        SqlSession session = SqlSessionFactory.getSqlSession();

        HrMapper mapper = session.getMapper(HrMapper.class);

        Hr hr = mapper.selectByPrimaryKey(3);

        System.out.println(hr.getAddress());

        SqlSessionFactory.closeSession(session);
    }
}
