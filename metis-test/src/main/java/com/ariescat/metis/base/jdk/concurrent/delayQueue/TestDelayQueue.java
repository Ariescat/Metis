package com.ariescat.metis.base.jdk.concurrent.delayQueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;

public class TestDelayQueue {

    public static void main(String[] args) {
        DelayQueue<Message> delayQueue = new DelayQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Message message = new Message(i, "content" + i, i * 3000);
            Message message_r = new Message(i + 20, "content" + i, random.nextInt(3000));
            delayQueue.add(message_r);
        }

        new Thread(() -> {
            while (true) {
                Message message;
                try {
                    message = delayQueue.take();
                    System.out.println("message = " + message.getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
