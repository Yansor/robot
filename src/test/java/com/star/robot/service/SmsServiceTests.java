package com.star.robot.service;

import com.star.robot.RobotApplicationTests;
import io.swagger.annotations.ApiModelProperty;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class SmsServiceTests {

    @Test
    public void send(){
        System.out.println(SmsService.sendMsg("15515988667"));
    }
}
