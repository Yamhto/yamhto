package com.yamhto.spring.activiti.seviceTask;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @author yamhto
 * @className: TestServiceTask.java
 * @package com.yamhto.spring.activiti.seviceTask
 * @description:
 * @date 2020/3/30 13:55
 */

public class TestServiceTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("任务开始了");
    }
}
