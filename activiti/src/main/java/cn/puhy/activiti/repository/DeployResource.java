package cn.puhy.activiti.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.bpmn.model.*;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * 部署资源
 */
public class DeployResource {

    public static void main(String[] args) throws Exception {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到流程存储服务实例
        RepositoryService repositoryService = engine.getRepositoryService();
        // 输入流资源
        InputStream is = new FileInputStream(new File(
                "/Users/puhongyu/phy/idea/activiti/src/main/resources/repository/flow_inputstream.png"));


        // 创建DeploymentBuilder实例
        DeploymentBuilder builder = repositoryService.createDeployment();
        // 添加输入流资源
        builder.addInputStream("InputStream", is);
        //添加classpath下的资源
        builder.addClasspathResource("repository/classpath.png");
        builder.addClasspathResource("bpmn/first.bpmn");
        //添加字符串资源
        builder.addString("phy", "蒲红宇");

        //添加压缩包资源
        FileInputStream fis = new FileInputStream(new File("/Users/puhongyu/phy/idea/activiti/src/main/resources/repository/ZipInputStream.zip"));
        ZipInputStream zis = new ZipInputStream(fis);
        builder.addZipInputStream(zis);

        //添加BPMN模型资源
        builder.addBpmnModel("phyBPMN", createProcessModel());

        //设置部署信息
        builder.name("蒲红宇部署资源学习").tenantId("tenantId").key("phyKey").category("phyCategory");

        //过滤重复部署
        builder.enableDuplicateFiltering();
        // 执行部署方法
        builder.deploy();
    }

    /**
     * 创建bpmn模型
     * @return
     */
    private static BpmnModel createProcessModel() {
        // 创建BPMN模型对象
        BpmnModel model = new BpmnModel();
        org.activiti.bpmn.model.Process process = new org.activiti.bpmn.model.Process();

        process.setId("phyProcess");
        process.setName("phyProcess");
        // 开始事件
        StartEvent startEvent = new StartEvent();
        startEvent.setId("startEvent");
        process.addFlowElement(startEvent);
        // 用户任务
        UserTask userTask = new UserTask();
        userTask.setName("User Task");
        userTask.setId("userTask");
        List<String> users = new ArrayList<>();
        users.add("phy");
        userTask.setCandidateUsers(users);
        process.addFlowElement(userTask);
        // 结束事件
        EndEvent endEvent = new EndEvent();
        endEvent.setId("endEvent");
        process.addFlowElement(endEvent);
        // 添加流程顺序
        process.addFlowElement(new SequenceFlow("startEvent", "userTask"));
        process.addFlowElement(new SequenceFlow("userTask", "endEvent"));
        model.addProcess(process);
        return model;
    }
}
