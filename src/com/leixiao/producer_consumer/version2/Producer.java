package com.leixiao.producer_consumer.version2;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private List<PCData> list;
    private int length;

    public Producer(List list, int length) {
        this.list = list;
        this.length = length;
    }


    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted()) break;

                Random r = new Random();
                int temp = r.nextInt(100);
                System.out.println(temp);
                PCData data = new PCData(temp);
                synchronized (list) {
                    if (list.size() >= length) {
                        list.notifyAll();
                        list.wait();
                    } else {
                        list.add(data);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        }
    }
}
