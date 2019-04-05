package com.star.robot.service;

import com.star.robot.util.MD5Util;
import org.junit.Test;

public class Md5Tests {
    @Test
    public void encrypt(){
        System.out.println(MD5Util.encrypt("admin"));
    }
}
