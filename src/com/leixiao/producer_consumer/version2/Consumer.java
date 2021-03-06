package com.leixiao.producer_consumer.version2;

import java.util.List;
import java.util.Objects;

public class Consumer implements Runnable {
    private List<PCData> list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted()) break;
                PCData data = null;

                synchronized (list) {
                    if (list.size() == 0) {
                        list.wait();
                        list.notifyAll();
                    }
                    list.remove(0);
                }
                System.out.println(data);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
