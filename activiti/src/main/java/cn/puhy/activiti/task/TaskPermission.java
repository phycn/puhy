package cn.puhy.activiti.task;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.IdentityLinkType;
import org.activiti.engine.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务权限
 */
public class TaskPermission {

    public static void main(String[] args) {
        //获取流程引擎实例
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 获取身份服务组件
        IdentityService identityService = engine.getIdentityService();
        // 新建用户组
        Group groupA = createGroup(identityService, "group1", "管理员", "manager");
        Group groupB = createGroup(identityService, "group2", "管理员2", "manager");
        // 获取任务服务组件
        TaskService taskService = engine.getTaskService();
        //保存第一个Task
        Task task1 = taskService.newTask("task1");
        task1.setName("申请假期");
        taskService.saveTask(task1);
        //保存第二个Task
        Task task2 = taskService.newTask("task2");
        task2.setName("审批申请");
        taskService.saveTask(task2);
        //绑定用户组和任务关系，设置候选用户组
        taskService.addCandidateGroup("task1", groupA.getId());
        taskService.addCandidateGroup("task2", groupA.getId());
//        与addCandidateGroup相同的效果
//        taskService.addGroupIdentityLink(task1.getId(), groupA.getId(), IdentityLinkType.CANDIDATE);

        User user = creatUser(identityService, "user1", "蒲",
                "红宇", "phy2533@163.com", "123");

        //绑定用户和任务关系，设置候选用户
        taskService.addCandidateUser("task1", user.getId());
//        与addCandidateUser相同的效果
//        taskService.addUserIdentityLink(task1.getId(), user.getId(), IdentityLinkType.CANDIDATE);

        //根据用户组查询任务
        List<String> groups = new ArrayList<>();
        groups.add(groupA.getId());
        groups.add(groupB.getId());
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroupIn(groups).list();
        System.out.println("管理员组的候选任务：");
        for (Task task : tasks) {
            System.out.println(task.getId());
        }
        //根据用户查询任务
        tasks = taskService.createTaskQuery().taskCandidateUser(user.getId()).list();
        System.out.println("蒲红宇的候选任务：");
        for (Task task : tasks) {
            System.out.println(task.getName());
        }
        //查询权限数据
        List<IdentityLink> links = taskService.getIdentityLinksForTask(task1.getId());
        for (IdentityLink link : links) {
            System.out.println(link.getTaskId());
        }

        //设置任务持有人
        taskService.setOwner(task1.getId(), user.getId());
        System.out.println("蒲红宇拥有的任务数：" + taskService.createTaskQuery().taskOwner(user.getId()).count());
//        与setOwner相同的效果
//        taskService.addUserIdentityLink(task1.getId(), user.getId(), IdentityLinkType.OWNER);

        //设置任务代理人
        taskService.setAssignee(task2.getId(), user.getId());
        System.out.println("蒲红宇受理的任务数：" + taskService.createTaskQuery().taskAssignee(user.getId()).count());
//        与setAssignee相同的效果
//        taskService.addUserIdentityLink(task1.getId(), user.getId(), IdentityLinkType.ASSIGNEE);


        //删除用户组权限
        taskService.deleteCandidateGroup(task1.getId(), groupA.getId());
//        与deleteCandidateGroup相同的效果
//        taskService.deleteGroupIdentityLink(task1.getId(), groupA.getId(), IdentityLinkType.CANDIDATE);

        //删除用户权限
        taskService.deleteCandidateUser(task1.getId(), user.getId());
//        与deleteCandidateUser相同的效果
//        taskService.deleteUserIdentityLink(task1.getId(), user.getId(), IdentityLinkType.CANDIDATE);
    }



    // 将用户组数据保存到数据库中
    private static Group createGroup(IdentityService identityService, String id,
                                     String name, String type) {
        // 调用newGroup方法创建Group实例
        Group group = identityService.newGroup(id);
        group.setName(name);
        group.setType(type);
        identityService.saveGroup(group);
        return identityService.createGroupQuery().groupId(id).singleResult();
    }

    // 创建用户方法
    private static User creatUser(IdentityService identityService, String id,
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
        return identityService.createUserQuery().userId(id).singleResult();
    }
}
