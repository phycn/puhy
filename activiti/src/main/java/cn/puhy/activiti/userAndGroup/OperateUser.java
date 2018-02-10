package cn.puhy.activiti.userAndGroup;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

/**
 * 添加用户
 */
public class OperateUser {

    public static void main(String[] args) {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到身份服务组件实例
        IdentityService identityService = engine.getIdentityService();
        String id = UUID.randomUUID().toString();
        // 使用newUser方法创建User实例
        User user = identityService.newUser(id);
        // 设置用户的各个属性
        user.setFirstName("蒲");
        user.setLastName("红宇");
        user.setEmail("phy@163.com");
        user.setPassword("phy");
        // 使用saveUser方法保存用户
        identityService.saveUser(user);
        // 根据 id 查询
        user = identityService.createUserQuery().userId(id).singleResult();
        System.out.println("修改前：" + user.getEmail());

        //修改用户信息
        user.setEmail("phy253399933@qq.com");
        identityService.saveUser(user);

        user = identityService.createUserQuery().userId(id).singleResult();
        System.out.println("修改后：" + user.getEmail());

        //删除用户
        identityService.deleteUser(id);
        System.out.println("用户总数：" + identityService.createUserQuery().count());
    }
}
