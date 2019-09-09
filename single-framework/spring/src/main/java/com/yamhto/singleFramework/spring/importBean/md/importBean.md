###向Spring引入javaBean的方法
```text
1. 在 xml中直接引入Bean:
    <bean id="beanId" class="Bean 的类路径" ></bean>

2. 通过实现FactoryBean接口引入：
    public class SpringFactoryBean  implements FactoryBean<SpringBean> {
    
        public SpringBean getObject() throws Exception {
            return new SpringBean();
        }
    
        public Class<?> getObjectType() {
            return SpringBean.class;
        }
    }
    注入SpringFactoryBean，之后通过id="SpringBeanFactory"取到的对象为SpringBean对象，如果需要拿到SpringBeanFactory对象
    只需要取id为"&SpringBeanFactory"的Bean。

3. 通过实现BeanDefinitionRegistryPostProcessor接口引入：
    public class SpringBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {
    
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(SpringBean.class);
            beanDefinitionRegistry.registerBeanDefinition("springBean",builder.getBeanDefinition());
        }
    
        public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    
        }
    }
```