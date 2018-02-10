package cn.puhy.activiti.task;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

public class NewTask {

    public static void main(String[] args) {
        // 创建流程引擎
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        //获取任务服务组件
        TaskService taskService = engine.getTaskService();
        //保存第一个Task，不设置ID
        Task task1 = taskService.newTask();
        taskService.saveTask(task1);
        //保存第二个Task，设置ID
        Task task2 = taskService.newTask("审核任务");
        taskService.saveTask(task2);

        //删除task，不包括历史数据和子任务，在ACT_HI_TASKINST中还有数据
        taskService.deleteTask(task1.getId());
        //级联删除task，包括历史数据和子任务
        taskService.deleteTask(task2.getId(), true);
    }
}
