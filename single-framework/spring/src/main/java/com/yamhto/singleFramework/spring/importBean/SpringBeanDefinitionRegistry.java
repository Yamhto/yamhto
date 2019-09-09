package com.yamhto.singleFramework.spring.importBean;

import com.yamhto.singleFramework.spring.bean.SpringBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: SpringBeanDefinitionRegistry.java
 * @package com.yamhto.singleFramework.spring.importBean
 * @description: 通过BeanDefinitionRegistryPostProcessor 向Spring中引入Bean
 * @date 2019/9/8 14:49
 */
public class SpringBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(SpringBean.class);
        builder.addPropertyValue("single",false);
        beanDefinitionRegistry.registerBeanDefinition("springBean",builder.getBeanDefinition());
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
