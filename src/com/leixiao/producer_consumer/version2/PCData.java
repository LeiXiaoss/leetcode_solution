package com.leixiao.producer_consumer.version2;

public class PCData {
    private final int initData;

    public PCData(int initData) {
        this.initData = initData;
    }

    public int getData() {
        return initData;
    }
}
