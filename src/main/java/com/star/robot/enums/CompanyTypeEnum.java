package com.star.robot.enums;

public enum CompanyTypeEnum {
    GONGSI("1","公司") , JIGOU("2","机构");
    private String code;

    private String name;

    CompanyTypeEnum(String code ,String name){
        this.code = code;
        this.name = name;
    }
}
