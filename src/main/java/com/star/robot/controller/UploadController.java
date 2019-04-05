package com.star.robot.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    private String uploadPath = System.getProperty("user.dir");
    private org.slf4j.Logger logger = LoggerFactory.getLogger(UploadController.class);
    @ApiOperation(value = "文件上传",notes = "form-data上传方式上传文件,multipartFile为上传文件的名称")
    @PostMapping
    public void upload(@RequestBody MultipartFile multipartFile){
        try {
            logger.info("UploadController upload path is :"+new File(uploadPath  + "/upload").getAbsolutePath());
            if(!new File(uploadPath + "/upload").exists()){
                new File(uploadPath + "/upload").mkdirs();
            }
            //保留原文件名
            String fileName = multipartFile.getOriginalFilename();
            logger.info("UploadController upload fileName is :"+fileName);
            //建立文件
            new File(uploadPath + "/upload/"+fileName).createNewFile();
            multipartFile.transferTo(new File(uploadPath + "/upload/"+fileName) );
        } catch (IOException e) {
            logger.info("UploadController_IOException"+e.getMessage());
            e.printStackTrace();
        }
    }
}
