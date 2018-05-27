package cn.puhy.quartz.first;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author puhongyu
 * 2018/5/26 16:44
 */
public class FirstRunner {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        //执行时间，当前时间下一分钟
        Date runTime = evenMinuteDate(new Date());

        JobDetail job = newJob(FirstJob.class).withIdentity("job1", "group1").build();
        //触发器
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
        scheduler.scheduleJob(job, trigger);

        scheduler.start();
    }
}
