package cn.puhy.quartz.listener;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author puhongyu
 * 2018/5/27 10:13
 */
public class ListenerJob2 implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("job2 running");
    }
}
