package cn.puhy.activiti.userAndGroup;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

/**
 * 查询用户数据
 * memberOfGroup    根据用户组ID查询属于该组的全部用户数据
 * potentialStarter 根据流程定义的ID查询有权限启动流程定义的用户
 */
public class UserQuery {

    public static void main(String[] args) {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到身份服务组件实例
        IdentityService identityService = engine.getIdentityService();
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        // 创建两个用户
        creatUser(identityService, id1, "张", "三",
                "zhangsan@163.com", "abc");
        creatUser(identityService, id2, "李", "四", "lisi@163.com",
                "123");
        // 调用UserQuery的各个查询方法
        // userId
        User user = identityService.createUserQuery().userId(id1)
                .singleResult();
        System.out.println("userId:" + user.getFirstName());
        // userFirstName
        user = identityService.createUserQuery().userFirstName("张")
                .singleResult();
        System.out.println("userFirstName:" + user.getFirstName());
        // userFirstNameLike
        List<User> datas = identityService.createUserQuery()
                .userFirstNameLike("angus%").list();
        System.out.println("createUserQuery:" + datas.size());
        // userLastName
        user = identityService.createUserQuery().userLastName("四")
                .singleResult();
        System.out.println("userLastName:" + user.getFirstName());
        // userLastNameLike
        datas = identityService.createUserQuery().userLastNameLike("young%")
                .list();
        System.out.println("userLastNameLike:" + datas.size());
        // userEmail
        user = identityService.createUserQuery().userEmail("lisi@163.com")
                .singleResult();
        System.out.println("userEmail:" + user.getFirstName());
        // userEmailLike
        datas = identityService.createUserQuery().userEmailLike("%163.com")
                .list();
        System.out.println("userEmailLike:" + datas.size());
        // 使用NativeQuery
        datas = identityService.createNativeUserQuery()
                .sql("select * from ACT_ID_USER where EMAIL_ = #{email}")
                .parameter("email", "zhangsan@163.com").list();
        System.out.println("native query:" + datas.get(0).getEmail());
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
}
