package com.leixiao.design_pattern.singleton;

public class DoubleValidateSingleton {
    //双检锁，考虑到了线程安全

    private volatile static DoubleValidateSingleton singleton;

    private DoubleValidateSingleton(){}

    public static DoubleValidateSingleton getInstance(){
        if(singleton == null){
            synchronized (DoubleValidateSingleton.class){
                if(singleton == null){
                    singleton = new DoubleValidateSingleton();
                }
            }
        }
        return singleton;
    }
}
