package cn.puhy.activiti.userAndGroup;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.identity.Authentication;

public class AuthenticatedUserId {

    public static void main(String[] args) {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 得到身份服务组件实例
        final IdentityService identityService = engine.getIdentityService();
        // 设置当前线程的userId为3
        identityService.setAuthenticatedUserId("3");
        System.out.println("当前线程usreId：" + Authentication.getAuthenticatedUserId());
        // 启动两条线程
        new Thread() {
            @Override
            public void run() {
                try {
                    identityService.setAuthenticatedUserId("1");
                    Thread.sleep(5000);
                    System.out.println("线程1的userId：" + Authentication.getAuthenticatedUserId());
                } catch (Exception e) {

                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                identityService.setAuthenticatedUserId("2");
                System.out.println("线程2的usrId：" + Authentication.getAuthenticatedUserId());
            }
        }.start();
    }
}
