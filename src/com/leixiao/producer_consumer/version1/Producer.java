package com.leixiao.producer_consumer.version1;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private volatile boolean isRunning = true;
    private BlockingDeque<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingDeque queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();
        System.out.println("start producting id :" + Thread.currentThread().getId());

        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.incrementAndGet());
                System.out.println(data + "加入队列");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("加入队列失败");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}
