package cn.puhy.quartz.calendar;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.quartz.DateBuilder.dateOf;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author puhongyu
 * 2018/5/27 09:03
 */
public class CalendarRunner {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        //以年为周期的
        AnnualCalendar holidays = new AnnualCalendar();
        //五一节
        Calendar wuyi = new GregorianCalendar();
        //设置月份，从0开始的
        wuyi.set(Calendar.MONTH, 4);
        wuyi.set(Calendar.DATE, 1);
        System.out.println(wuyi.getTime());
        //排除指定日期
        holidays.setDayExcluded(wuyi, true);
        //注册日历
        scheduler.addCalendar("holidays", holidays, false, false);

        Date runDate = dateOf(0, 0, 0, 1, 6);
//        Date startTime = DateBuilder.nextGivenSecondDate(null, 3);
        JobDetail job = newJob(CalendarJob.class).withIdentity("job1", "group1").build();

        SimpleTrigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runDate)
                .withSchedule(simpleSchedule().withIntervalInSeconds(2).repeatForever()).modifiedByCalendar("holidays").build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }
}
