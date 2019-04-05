package com.star.robot.controller;

import com.star.robot.dto.DtAreaRequestDto;
import com.star.robot.dto.ResultDto;
import com.star.robot.repository.DtAreaRepositoty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dtArea")
public class DtAreaController {

    @Autowired
    private DtAreaRepositoty dtAreaRepositoty;

    /**
     * 查找全部省　省下市　市下区
     * @param requestDto
     * @return
     */
    @ApiOperation(value = "1.查找全部省,参数传0, 2.省下市 传对应省id, 3.市下区 传对应市id")
    @GetMapping(value = "/")
    public ResultDto findByParentId(DtAreaRequestDto requestDto){
        if(requestDto != null && requestDto.getParentAreaId()!= null){
            return ResultDto.builder().data(dtAreaRepositoty.findAllByAreaParentId(requestDto.getParentAreaId())).build();
        }else{
            return ResultDto.builder().build();
        }
    }
}
