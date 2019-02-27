package com.leixiao.design_pattern.singleton;

public class LazySingleton {
    //懒汉，线程不安全

    private static LazySingleton instance;

    private LazySingleton(){}

    public LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
