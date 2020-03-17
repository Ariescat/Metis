package com.metis.framework.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) {
        // 打印当前的执行时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("现在的时间是：" + sf.format(date));
        //具体的业务逻辑
        System.out.println("Hello Quartz");
    }
}