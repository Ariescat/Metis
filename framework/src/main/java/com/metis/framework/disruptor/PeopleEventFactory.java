package com.metis.framework.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author Ariescat
 * @version 2020/4/10 14:54
 */
public class PeopleEventFactory implements EventFactory<PeopleEvent> {

    @Override
    public PeopleEvent newInstance() {
        return new PeopleEvent();
    }
}
