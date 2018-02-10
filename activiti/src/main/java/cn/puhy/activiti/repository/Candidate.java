package cn.puhy.activiti.repository;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.IdentityLink;

import java.util.List;

/**
 * 流程定义权限
 */
public class Candidate {

    public static void main(String[] args) {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到流程存储服务实例
        RepositoryService repositoryService = engine.getRepositoryService();
        // 得到身份服务组件
        IdentityService identityService = engine.getIdentityService();
        // 部署流程描述文件
        Deployment dep = repositoryService.createDeployment()
                .addClasspathResource("bpmn/first.bpmn").deploy();
        // 查询流程定义实体
        ProcessDefinition def = repositoryService
                .createProcessDefinitionQuery().deploymentId(dep.getId())
                .singleResult();
        // 写入用户数据
        creatUser(identityService, "user1", "angus", "young", "abc@163.com",
                "123");
        creatUser(identityService, "user2", "angus2", "young2", "abc@163.com",
                "123");
        creatUser(identityService, "user3", "angus3", "young3", "abc@163.com",
                "123");

        createGroup(identityService, "group1", "userGroup1", "userGroup");
        // 设置用户与流程定义的关系（设置权限），第一个参数为流程定义ID，第二个参数为用户ID
        repositoryService.addCandidateStarterUser(def.getId(), "user1");
        repositoryService.addCandidateStarterUser(def.getId(), "user2");
        //设置用户组与流程定义的关系
        repositoryService.addCandidateStarterGroup(def.getId(), "group1");

        //根据用户查询有权限的流程定义
        List<ProcessDefinition> defs = repositoryService.createProcessDefinitionQuery().startableByUser("user1").list();
        System.out.println("user1有权限的流程定义：");
        for(ProcessDefinition pd : defs) {
            System.out.println("    " + pd.getId());
        }

        //根据流程定义查询有权限的用户组
        List<Group> groups = identityService.createGroupQuery().potentialStarter(def.getId()).list();
        System.out.println("有权限的用户组：");
        for(Group group : groups) {
            System.out.println("    " + group.getName());
        }

        //根据流程定义查询有权限的用户
        List<User> users = identityService.createUserQuery().potentialStarter(def.getId()).list();
        System.out.println("有权限的用户：");
        for(User user : users) {
            System.out.println("    " + user.getId());
        }

        //根据流程定义查询全部的IdentityLink
        List<IdentityLink> links = repositoryService.getIdentityLinksForProcessDefinition(def.getId());
        System.out.println(links.size());
    }

    // 创建用户方法
    private static void creatUser(IdentityService identityService, String id,
                                  String first, String last, String email, String passwd) {
        // 使用newUser方法创建User实例
        User user = identityService.newUser(id);
        // 设置用户的各个属性
        user.setFirstName(first);
        user.setLastName(last);
        user.setEmail(email);
        user.setPassword(passwd);
        // 使用saveUser方法保存用户
        identityService.saveUser(user);
    }

    //创建用户组
    private static void createGroup(IdentityService identityService, String id, String name, String type) {
        Group group = identityService.newGroup(id);
        group.setName(name);
        group.setType(type);
        //保存Group到数据库
        identityService.saveGroup(group);
    }
}
