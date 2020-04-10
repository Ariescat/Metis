package com.metis.framework.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author Ariescat
 * @version 2020/4/10 14:57
 */
public class PeopleEventHandler implements EventHandler<PeopleEvent> {

    @Override
    public void onEvent(PeopleEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("name:" + event.getName() + ",sex:" + event.getSex() + ",age:" + event.getAge());
    }
}
