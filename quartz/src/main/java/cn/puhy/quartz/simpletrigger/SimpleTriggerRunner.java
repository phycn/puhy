package cn.puhy.quartz.simpletrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.futureDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author puhongyu
 * 2018/5/26 17:10
 */
public class SimpleTriggerRunner {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        Date startTime = DateBuilder.nextGivenSecondDate(null, 3);

        JobDetail job1 = newJob(SimpleJob.class).withIdentity("job1", "group1").build();
        SimpleTrigger trigger1 = (SimpleTrigger) newTrigger()
                .withIdentity("trigger1", "group1").startAt(startTime).build();
        scheduler.scheduleJob(job1, trigger1);

        //执行4次，每2秒执行1次
        JobDetail job2 = newJob(SimpleJob.class).withIdentity("job2", "group1").build();
        SimpleTrigger trigger2 = newTrigger().withIdentity("trigger2", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(2).withRepeatCount(3)).build();
        scheduler.scheduleJob(job2, trigger2);

        //每2秒执行1次
        JobDetail job3 = newJob(SimpleJob.class).withIdentity("job3", "group1").build();
        SimpleTrigger trigger3 = newTrigger().withIdentity("trigger3", "group1")
                //10秒后开始执行
                .startAt(futureDate(10, DateBuilder.IntervalUnit.SECOND))
                .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        scheduler.scheduleJob(job3, trigger3);

        scheduler.start();
    }
}
