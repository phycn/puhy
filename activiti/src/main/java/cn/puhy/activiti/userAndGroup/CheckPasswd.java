package cn.puhy.activiti.userAndGroup;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

/**
 * 验证用户密码
 */
public class CheckPasswd {

    public static void main(String[] args) {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到身份服务组件实例
        IdentityService identityService = engine.getIdentityService();
        String id = UUID.randomUUID().toString();
        // 创建用户
        creatUser(identityService, id, "蒲", "红宇", "phy@163.com", "puhongyu");
        // 验证用户密码
        System.out.println("验证密码结果：" + identityService.checkPassword(id, "puhongyu"));
        System.out.println("验证密码结果：" + identityService.checkPassword(id, "c"));
    }

    //创建用户方法
    private static void creatUser(IdentityService identityService, String id, String first, String last, String email, String passwd) {
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
}
