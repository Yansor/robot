package com.star.robot.util;

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**
     * md5加密成16位16进制字符串
     * @param before
     * @return
     */
    public static String encrypt(String before){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] output = messageDigest.digest(before.getBytes(Charset.forName("utf8")));

            StringBuffer sb = new StringBuffer();

            if(output != null && output.length >0 ){
                for(byte b : output){
                    sb.append(ascii(b));
                }
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 97转成ascii字符串a
     */
    public static String ascii(byte b){

        return (char)b + "";
    }
}
