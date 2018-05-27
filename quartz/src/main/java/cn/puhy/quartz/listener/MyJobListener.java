package cn.puhy.quartz.listener;

import org.quartz.*;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author puhongyu
 * 2018/5/27 10:14
 */
public class MyJobListener implements JobListener {
    @Override
    public String getName() {
        return "job1 listener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("执行前");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("job1执行后开始执行job2");
        JobDetail job2 = newJob(ListenerJob2.class).withIdentity("job2").build();
        Trigger trigger = newTrigger().withIdentity("job2Trigger").startNow().build();
        try {
            context.getScheduler().scheduleJob(job2, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
