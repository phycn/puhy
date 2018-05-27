package cn.puhy.quartz.listener;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author puhongyu
 * 2018/5/27 10:16
 */
public class ListenerRunner {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        JobDetail job = newJob(ListenerJob1.class).withIdentity("job1").build();
        Trigger trigger = newTrigger().withIdentity("trigger1").startNow().build();

        //设置监听
        JobListener listener = new MyJobListener();
        Matcher<JobKey> matcher = KeyMatcher.keyEquals(job.getKey());
        scheduler.getListenerManager().addJobListener(listener, matcher);

        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }
}
