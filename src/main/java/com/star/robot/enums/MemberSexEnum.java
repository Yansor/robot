package com.star.robot.enums;

public enum  MemberSexEnum {

    MALE("1","男") , FEMALE("2","女");
    private String code;

    private String name;

    MemberSexEnum(String code ,String name){
        this.code = code;
        this.name = name;
    }
}
