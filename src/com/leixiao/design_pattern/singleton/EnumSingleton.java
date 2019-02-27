package com.leixiao.design_pattern.singleton;

public enum EnumSingleton {
    //枚举
    INSTANCE;
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
