package com.yamhto.singleFramework.spring.importBean;

import com.yamhto.singleFramework.spring.bean.SpringBean;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: SpringFactoryBean.java
 * @package com.yamhto.singleFramework.spring.importBean
 * @description: 通过FactoryBean<T> 向Spring中引入Bean
 * @date 2019/9/8 14:34
 */
public class SpringFactoryBean  implements FactoryBean<SpringBean> {

    public SpringBean getObject() throws Exception {
        return new SpringBean();
    }

    public Class<?> getObjectType() {
        return SpringBean.class;
    }
}
