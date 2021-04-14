package org.example.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ButtonTimerJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(ButtonTimerJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("--------------定时任务执行逻辑---------------------");
    }
}
