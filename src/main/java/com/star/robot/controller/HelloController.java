package com.star.robot.controller;

import com.star.robot.dto.ResultDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @ApiOperation(value = "测试服务器健康状态")
    @GetMapping(value = "/hello")
    public ResultDto hello(){
        return ResultDto.builder().data("Hello World!").build();
    }
}
