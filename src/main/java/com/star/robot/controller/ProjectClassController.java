package com.star.robot.controller;

import com.star.robot.dto.CommonRequestDto;
import com.star.robot.dto.ResultDto;
import com.star.robot.entity.ProjectClass;
import com.star.robot.repository.ProjectClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projectClass")
public class ProjectClassController {

    @Autowired
    private ProjectClassRepository projectClassRepository;
    @GetMapping
    public ResultDto findByParentId(CommonRequestDto requestDto){
        if(requestDto.getId() == null){
            throw new IllegalArgumentException("请求参数ID必填");
        }
        List<ProjectClass> projectClassList = projectClassRepository.findByParentId(requestDto.getId());
        return ResultDto.builder().data(projectClassList).build();
    }
}
