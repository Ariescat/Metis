package com.metis.framework.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class Test {

    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail的实例，将该实例与HelloJob绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("zhlJob").build();
        //开始时间 3秒钟之后  （具体时间按实际业务编写）
        Date sData = new Date();
        sData.setTime(sData.getTime() + 3000);
        //结束时间 6秒钟之后 （具体时间按实际业务编写）
        Date eData = new Date();
        eData.setTime(eData.getTime() + 6000);
        //创建一个Trigger实例，定义该job3秒之后执行，在6秒之后结束
        SimpleTrigger zhlTrigger = TriggerBuilder.newTrigger().withIdentity("zhlTrigger")
                .startAt(sData) //设定开始时间
                .endAt(eData)   //设定结束时间
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()) //每两秒打印一次
                .build();
        //创建Scheduler实例
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, zhlTrigger);
    }
}
