package com.yamhto.spring.activiti;

import com.yamhto.spring.activiti.constant.ActivitiConstant;
import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.*;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yamhto
 * @className: App.java
 * @package com.yamhto.spring.activiti
 * @description:
 * @date 2020/3/30 11:26
 */
public class App {


    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-activiti.xml");

        createBpmn();
    }


    private static void createBpmn() throws IOException {
        //创建bpmn模型
        BpmnModel model = new BpmnModel();
        Process process = new Process();
        model.addProcess(process);
        process.setId("my-process");


        //创建bpmn元素
        process.addFlowElement(createStartEvent());
        process.addFlowElement(createUserTask("task1", "First task", "fred"));
        ServiceTask serviceTask = createServiceTask("servicetask", "First task", "BoundaryEventId01");
        process.addFlowElement(serviceTask);
        process.addFlowElement(createUserTask("task2", "Second task", "john"));
        process.addFlowElement(createEndEvent());
        process.addFlowElement(createBoundaryEvent("BoundaryEventId01", serviceTask));


        process.addFlowElement(createSequenceFlow("start", "servicetask"));

        // process.addFlowElement(createSequenceFlow("task1", "servicetask"));

        //process.addFlowElement(createSequenceFlow("servicetask", "task2"));
        process.addFlowElement(createSequenceFlow("servicetask", "end"));


        // 2.生成BPMN自动布局
        new BpmnAutoLayout(model).execute();

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        Deployment deployment = processEngine.getRepositoryService().createDeployment().addBpmnModel("my-process.bpmn", model).name("my-process.bpmn").deploy();
        //启动流程
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("my-process");
        System.err.println("部署id" + processInstance.getId());
        System.err.println("部署名称" + processInstance.getName());
        //存储流程 图片
        // 7. 存储xml
        InputStream processBpmn = processEngine.getRepositoryService()
                .getResourceAsStream(deployment.getId(), "my-process.bpmn");
        FileUtils.copyInputStreamToFile(processBpmn,
                new File("C:\\Users\\admin_YM\\Desktop\\my-process.bpmn"));
        System.err.println("执行完毕");


    }


    protected static UserTask createUserTask(String id, String name, String assignee) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setAssignee(assignee);
        return userTask;
    }

    protected static ServiceTask createServiceTask(String id, String name, String BoundaryEventId) {
        ServiceTask serviceTask = new ServiceTask();
        serviceTask.setName(name);
        serviceTask.setId(id);
        serviceTask.setImplementationType("delegateExpression");
        serviceTask.setImplementation("${testServiceTask}");
        //serviceTask.setResultVariableName("");

        ArrayList<BoundaryEvent> boundaryEvents = new ArrayList<>();
        boundaryEvents.add(createBoundaryEvent(id, serviceTask));
        serviceTask.setBoundaryEvents(boundaryEvents);

        return serviceTask;
    }

    /**
     * 错误节点
     *
     * @param BoundaryEventId
     * @param serviceTask
     * @return
     */
    protected static BoundaryEvent createBoundaryEvent(String BoundaryEventId, ServiceTask serviceTask) {
        BoundaryEvent boundaryEvent = new BoundaryEvent();
        boundaryEvent.setId(BoundaryEventId);
        boundaryEvent.setName(ActivitiConstant.BoundaryErrorEventName);
        boundaryEvent.setAttachedToRef(serviceTask);
        ErrorEventDefinition errorEventDefinition = createerrorEventDefinition();

        List<EventDefinition> eds = new ArrayList<>();
        eds.add(errorEventDefinition);

        boundaryEvent.setEventDefinitions(eds);

        return boundaryEvent;
    }

    /**
     * 错误定义
     *
     * @return
     */
    protected static ErrorEventDefinition createerrorEventDefinition() {

        ErrorEventDefinition errorEventDefinition = new ErrorEventDefinition();
        errorEventDefinition.setErrorCode(ActivitiConstant.errorCode);

        return errorEventDefinition;
    }


    //创建箭头
    protected static SequenceFlow createSequenceFlow(String from, String to) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);

        return flow;
    }


    protected static StartEvent createStartEvent() {
        StartEvent startEvent = new StartEvent();
        startEvent.setId("start");
        return startEvent;
    }


    protected static EndEvent createEndEvent() {
        EndEvent endEvent = new EndEvent();
        endEvent.setId("end");
        return endEvent;
    }
}
