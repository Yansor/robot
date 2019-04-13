package com.star.robot.enums;


public enum AdminTypeEnum {
    PROVINCEADMIN("1","省级管理员") , CITYADMIN("2","市级管理员");
    private String code;

    private String name;

    AdminTypeEnum(String code ,String name){
        this.code = code;
        this.name = name;
    }
}
