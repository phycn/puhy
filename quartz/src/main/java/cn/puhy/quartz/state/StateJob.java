package cn.puhy.quartz.state;

import org.quartz.*;

/**
 * @author puhongyu
 * 2018/5/26 22:37
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class StateJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        //获取任务参数
        JobDataMap data = context.getJobDetail().getJobDataMap();
        int count = data.getInt("count");
        System.out.println(count);
        //设置任务参数，下一次执行会获取到
        count++;
        data.put("count", count);
    }
}
