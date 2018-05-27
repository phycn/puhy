package cn.puhy.quartz.state;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.nextGivenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author puhongyu
 * 2018/5/26 22:45
 */
public class StateJobRunner {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        Date startTime = nextGivenSecondDate(null, 3);

        JobDetail job1 = newJob(StateJob.class).withIdentity("job1", "group1").build();
        SimpleTrigger trigger1 = newTrigger().withIdentity("trigger1", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(2).withRepeatCount(6)).build();
        //设置任务参数
        job1.getJobDataMap().put("count", 5);

        scheduler.scheduleJob(job1, trigger1);
        scheduler.start();
    }
}
