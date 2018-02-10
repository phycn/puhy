package cn.puhy.activiti.test;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class FirstListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        String orgId = (String) delegateTask.getVariable("orgId");
        delegateTask.addCandidateGroup(orgId);
        delegateTask.addCandidateGroup("entering");
    }
}
