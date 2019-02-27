package com.leixiao.design_pattern.singleton;

public class HungerSingleton {
    //饿汉，第一次引用就创建对象，无法做到延迟创建

    private static HungerSingleton instance = new HungerSingleton();

    private HungerSingleton(){}

    public HungerSingleton getInstance(){
        return instance;
    }
}
