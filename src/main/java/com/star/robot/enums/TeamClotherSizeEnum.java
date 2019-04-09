package com.star.robot.enums;

public enum TeamClotherSizeEnum {
    SMALL("small","S") , MEDIUM("medium","M"),LARGE("large","L")
    ,XL("xl","XL"),XXL("xxl","XXL");
    private String code;

    private String name;

    TeamClotherSizeEnum(String code ,String name){
        this.code = code;
        this.name = name;
    }
}
