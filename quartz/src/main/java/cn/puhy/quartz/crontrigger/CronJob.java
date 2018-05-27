package cn.puhy.quartz.crontrigger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author puhongyu
 * 2018/5/26 22:14
 */
public class CronJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(context.getJobDetail().getKey() + " " + context.getJobRunTime());
    }
}
