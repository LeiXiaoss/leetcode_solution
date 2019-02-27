package com.leixiao.design_pattern.singleton;

public class StaticInnerClassSingleton {
    //静态内部类

    private StaticInnerClassSingleton(){}

    public static final StaticInnerClassSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }
}
