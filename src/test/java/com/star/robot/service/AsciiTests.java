package com.star.robot.service;

import com.star.robot.util.MD5Util;
import org.junit.Test;

public class AsciiTests {
    @Test
    public void letter2Ascii(){
        byte a = 97;

        for(byte i = 0 ; i <=127;i++)
        System.out.println(MD5Util.ascii(i));
    }
}
