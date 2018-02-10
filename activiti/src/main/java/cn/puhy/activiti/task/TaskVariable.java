package cn.puhy.activiti.task;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * 任务参数
 */
public class TaskVariable {

    public static void main(String[] args) {
        //获取流程引擎实例
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 获取任务服务组件
        TaskService taskService = engine.getTaskService();
        //保存第一个Task
        Task task1 = taskService.newTask("task1");
        taskService.saveTask(task1);
        Date d = new Date();
        short s = 3;
        //设置各种基本类型参数

        taskService.setVariable(task1.getId(), "arg0", false);
        taskService.setVariable(task1.getId(), "arg1", d);
        taskService.setVariable(task1.getId(), "arg2", 1.5D);
        taskService.setVariable(task1.getId(), "arg3", 2);
        taskService.setVariable(task1.getId(), "arg4", 10L);
        taskService.setVariable(task1.getId(), "arg5", null);
        taskService.setVariable(task1.getId(), "arg6", s);
        taskService.setVariable(task1.getId(), "arg7", "test");

        //setVariableLocal为设置当前任务参数，只在本任务内有效
        taskService.setVariableLocal(task1.getId(), "arg8", "蒲红宇");

        //设置多个参数
        Map<String, String> arg9 = new HashMap<>();
        arg9.put("phy", "蒲红宇");
        arg9.put("hehe", "呵呵");
        taskService.setVariables(task1.getId(), arg9);

        //序列化参数
        taskService.setVariable(task1.getId(), "TestBean", new TestBean("aaa"));

        //获取参数
        int arg3 = (int) taskService.getVariable(task1.getId(), "arg3");
        System.out.println(arg3);
    }

}
