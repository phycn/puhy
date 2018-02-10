package cn.puhy.activiti.repository;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 部署资源
 */
public class RepositoryServiceTest {

    public static void main(String[] args) throws Exception {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到流程存储服务对象
        RepositoryService repositoryService = engine.getRepositoryService();

        DeploymentBuilder builder = repositoryService.createDeployment();
        // 部署一份txt文件
//        Deployment txtDep = builder.addClasspathResource("repository/repositoryServiceTest.txt").deploy();
        // 查询txt资源文件
//        InputStream txtIs = repositoryService.getResourceAsStream(txtDep.getId(),
//                "repository/repositoryServiceTest.txt");
        // 部署流程文件
        Deployment bpmnDep = builder.addClasspathResource("bpmn/first.bpmn").deploy();
        ProcessDefinition def = repositoryService.createProcessDefinitionQuery().deploymentId(bpmnDep.getId()).singleResult();
        // 查询流程文件，参数为流程定义ID
        InputStream bpmnIs = repositoryService.getProcessModel(def.getId());

        // 读取输入流
        int count = bpmnIs.available();
        byte[] contents = new byte[count];
        bpmnIs.read(contents);
        String result = new String(contents);
        //输出结果
        System.out.println(result);

        //启动流程
        engine.getRuntimeService().startProcessInstanceById(def.getId());

        try {
            repositoryService.deleteDeployment(bpmnDep.getId());
        } catch(Exception e) {
            System.out.println("删除失败，流程已启动，没有设置cascade为true");
        }

        //能删除成功
        repositoryService.deleteDeployment(bpmnDep.getId(), true);
    }
}
