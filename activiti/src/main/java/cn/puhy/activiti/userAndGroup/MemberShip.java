package cn.puhy.activiti.userAndGroup;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

/**
 * 用户组与用户的关系
 */
public class MemberShip {

    public static void main(String[] args) {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到身份服务组件实例
        IdentityService identityService = engine.getIdentityService();
        // 保存用户
        User user1 = creatUser(identityService, UUID.randomUUID().toString(),
                "蒲", "红宇", "phy@163.com", "abc");
        User user2 = creatUser(identityService, UUID.randomUUID().toString(),
                "张", "三", "zs@163.com", "abc");
        User user3 = creatUser(identityService, UUID.randomUUID().toString(),
                "张", "三", "zs@163.com", "abc");
        // 保存用户组
        Group group1 = createGroup(identityService,
                UUID.randomUUID().toString(), "管理员", "manager");
        Group group2 = createGroup(identityService,
                UUID.randomUUID().toString(), "超级管理员", "root");

        // 绑定关系
        identityService.createMembership(user1.getId(), group1.getId());
        identityService.createMembership(user2.getId(), group1.getId());
        identityService.createMembership(user3.getId(), group1.getId());

        identityService.createMembership(user1.getId(), group2.getId());

        // 解除绑定
        identityService.deleteMembership(user2.getId(), group1.getId());

        //查询用户组下的用户
        List<User> users = identityService.createUserQuery().memberOfGroup(group1.getId()).list();
        System.out.println(group1.getName() + " 成员：");
        for(User user : users) {
            System.out.println(user.getFirstName() + user.getLastName());
        }

        //查询用户所属的用户组
        List<Group> groups = identityService.createGroupQuery().groupMember(user1.getId()).list();
        System.out.println("蒲红宇所属的用户组：");
        for(Group group : groups) {
            System.out.println(group.getName());
        }
    }

    // 创建用户方法
    static User creatUser(IdentityService identityService, String id,
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

    // 将用户组数据保存到数据库中
    static Group createGroup(IdentityService identityService, String id,
                             String name, String type) {
        // 调用newGroup方法创建Group实例
        Group group = identityService.newGroup(id);
        group.setName(name);
        group.setType(type);
        identityService.saveGroup(group);
        return identityService.createGroupQuery().groupId(id).singleResult();
    }
}
