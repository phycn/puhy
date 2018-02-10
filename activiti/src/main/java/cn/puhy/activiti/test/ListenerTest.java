package cn.puhy.activiti.test;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class ListenerTest implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("哈哈哈");
    }
}
