package com.metis.jdk.concurrent.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Message implements Delayed {

    private Integer id;
    private String content;
    private long delay;//延迟时间
    private long exceptTime;//执行时间

    public Message(Integer id, String content, long delay) {
        this.id = id;
        this.content = content;
        this.delay = delay;
        this.exceptTime = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(Delayed delayed) {
        Message message = (Message) delayed;
        return this.exceptTime > message.getExceptTime() ? 1 : 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        System.out.println(exceptTime - System.currentTimeMillis());
        return unit.convert(exceptTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public long getExceptTime() {
        return exceptTime;
    }

    public void setExceptTime(long exceptTime) {
        this.exceptTime = exceptTime;
    }


}