package com.yamhto.singleFramework.spring.bean;

/**
 * @author yamhto
 * @company lhfinance.com
 * @className: SpringBean.java
 * @package com.yamhto.singleFramework.spring.bean
 * @description: bean
 * @date 2019/9/6 16:48
 */
public class SpringBean {

    private String id = "1";

    private String className = "name";

    private String classPath = "path";

    private Class<?> clazz;

    private boolean single = true;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }
}
