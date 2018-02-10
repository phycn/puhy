package cn.puhy.activiti.test;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.*;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BpmnModelTest {

    public static void main(String[] args) throws IOException {

        //创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        //获取流程存储服务组件
        RepositoryService repositoryService = engine.getRepositoryService();
        //获取运行时服务组件
        RuntimeService runtimeService = engine.getRuntimeService();
        //获取流程任务组件
        TaskService taskService = engine.getTaskService();
        //部署流程文件
        repositoryService.createDeployment().addClasspathResource("bpmn/first.bpmn").deploy();

        Map<String, Object> variables = new HashMap<String, Object>(16);
        variables.put("orgId", "222111333");

        //启动流程
        ProcessInstance pi =  runtimeService.startProcessInstanceByKey("phyFirstProcess", "phy", variables);
        List<Task> tasks11 =  taskService.createTaskQuery().processInstanceId(pi.getId()).list();
        System.out.println(tasks11.size());

//        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("222111333").list();
//
//        Map<String, Object> variables1 = new HashMap<String, Object>(16);
//        variables1.put("approveResult", "1");
//        taskService.complete(tasks.get(0).getId(), variables1);
//        Map<String, Object> variables2 = new HashMap<String, Object>(16);
//        variables2.put("approveResult", "0");
//        taskService.complete("15", variables2);
    }
}
