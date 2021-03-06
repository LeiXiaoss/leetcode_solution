package com.leixiao.producer_consumer.version1;

import javax.swing.plaf.SliderUI;
import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {

    private BlockingDeque<PCData> queue;
    private static final int SLEEPTIME = 100;

    public Consumer(BlockingDeque queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start consumer id : " + Thread.currentThread().getId());
        Random r = new Random();

        try {
            while (true) {
                PCData data = queue.take();
                if (data != null) {
                    System.out.println(data);
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }


    }
}