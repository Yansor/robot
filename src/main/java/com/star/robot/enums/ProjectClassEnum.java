package com.star.robot.enums;

public enum ProjectClassEnum {
    XIAOXUE("1","小学组") , CHUZHONG("2","初中组"),GAOZHONG("3","高中组");
    private String code;

    private String name;

    ProjectClassEnum(String code ,String name){
        this.code = code;
        this.name = name;
    }
}

