package com.star.robot.exception;

import com.star.robot.dto.ResultDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
    /**
     * 全局请求参数验证
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResultDto processException(Exception e){
        return ResultDto.builder().success(Boolean.FALSE).message(e.getMessage()).build();
    }
}