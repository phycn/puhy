package cn.puhy.activiti.first;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;

public class Frist {
    public static void main(String[] args) {

        //创建流程引擎的另外一种方式
//        ProcessEngineConfiguration config = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
//        ProcessEngine engine = config.buildProcessEngine();
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
        //启动流程
        String pd = runtimeService.startProcessInstanceByKey("phyFirstProcess").getProcessInstanceId();
        //查询第一个任务
        Task task = taskService.createTaskQuery().processInstanceId(pd).singleResult();
        System.out.println("这是第一个任务：" + task.getName());
        //完成任务
        taskService.complete(task.getId());
        task = taskService.createTaskQuery().singleResult();
        System.out.println("这是第二个任务：" + task.getName());
        taskService.complete(task.getId());
        task = taskService.createTaskQuery().singleResult();
        System.out.println("流程结束了，任务：" + task);

        engine.close();
    }
}
