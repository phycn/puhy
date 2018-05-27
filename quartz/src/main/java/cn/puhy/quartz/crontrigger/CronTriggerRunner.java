package cn.puhy.quartz.crontrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author puhongyu
 * 2018/5/26 22:13
 */
public class CronTriggerRunner {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        JobDetail job = newJob(CronJob.class).withIdentity("job1", "group1").build();
        CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/1 * * * * ?"))
                .build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();

        job = newJob(CronJob.class).withIdentity("job2", "group1").build();
        trigger = newTrigger().withIdentity("trigger2", "group1")
                .withSchedule(cronSchedule("0/1 * * * * ?"))
                .build();
        scheduler.scheduleJob(job, trigger);
        Thread.sleep(5000);
        //删除任务，job2任务被删除
        scheduler.deleteJob(job.getKey());
    }
}
