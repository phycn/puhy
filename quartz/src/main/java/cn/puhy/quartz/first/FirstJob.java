package cn.puhy.quartz.first;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author puhongyu
 * 2018/5/26 16:33
 */
public class FirstJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz 初体验");
    }
}
