package com.star.robot.enums;
//组别 1小学组　2中学组　3大学组
public enum TeamGroupTypeEnum {
    XIAOXUE("1","小学组") , ZHONGXUE("2","中学组"),DAXUE("3","大学组");
    private String code;

    private String name;

    TeamGroupTypeEnum(String code ,String name){
        this.code = code;
        this.name = name;
    }
}
