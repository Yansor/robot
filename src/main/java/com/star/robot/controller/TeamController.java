package com.star.robot.controller;

import com.star.robot.dto.ResultDto;
import com.star.robot.dto.TeamRequestDto;
import com.star.robot.entity.Project;
import com.star.robot.entity.ProjectClass;
import com.star.robot.repository.ProjectClassRepository;
import com.star.robot.repository.TeamRepository;
import com.star.robot.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 队伍管理
 */
@RestController
@RequestMapping(value = "/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ProjectClassRepository projectClassRepository;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResultDto add(@RequestBody  TeamRequestDto requestDto, HttpServletRequest request){
        validateRequestParam(requestDto);
        Project project = new Project();
        BeanUtils.copyProperties(requestDto , project);
        //设置队伍关联的用户
        String phone = userService.getCurrentUser(request);
        project.setPhone(phone);
        teamRepository.save(project);
        return ResultDto.builder().build();
    }

    @GetMapping
    public ResultDto get(HttpServletRequest request){
        String phone = userService.getCurrentUser(request);
        if(StringUtils.isEmpty(phone)){
            return ResultDto.builder().data(null).build();
        }else{
            List<Project> projects = teamRepository.findAll().parallelStream().filter(project -> phone.equals(project.getPhone())).collect(Collectors.toList());
            return ResultDto.builder().data(projects).build();
        }
    }

    private void validateRequestParam(TeamRequestDto requestDto) {
        if(requestDto == null || requestDto.getId() != null){
            throw new IllegalArgumentException("添加队伍失败,参数校验异常");
        }
        if(requestDto.getClass1Id() == null){
            throw new IllegalArgumentException("添加队伍失败,项目大类必填");
        }
        if(requestDto.getClass2Id() == null){
            throw new IllegalArgumentException("添加队伍失败,项目小类必填");
        }
        if(requestDto.getGroupType() == null){
            throw new IllegalArgumentException("添加队伍失败,组别必填");
        }
        if(StringUtils.isEmpty(requestDto.getTeamName())){
            throw new IllegalArgumentException("添加队伍失败,队名必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember1Name())){
            throw new IllegalArgumentException("添加队伍失败,队员1姓名必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember1Sex())){
            throw new IllegalArgumentException("添加队伍失败,队员1性别必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember1Id())){
            throw new IllegalArgumentException("添加队伍失败,队员1身份证必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember1Size())){
            throw new IllegalArgumentException("添加队伍失败,队员1尺码必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember2Name())){
            throw new IllegalArgumentException("添加队伍失败,队员2姓名必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember2Sex())){
            throw new IllegalArgumentException("添加队伍失败,队员2性别必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember2Id())){
            throw new IllegalArgumentException("添加队伍失败,队员2身份证必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember2Size())){
            throw new IllegalArgumentException("添加队伍失败,队员2尺码必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember3Name())){
            throw new IllegalArgumentException("添加队伍失败,队员3姓名必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember3Sex())){
            throw new IllegalArgumentException("添加队伍失败,队员3性别必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember3Id())){
            throw new IllegalArgumentException("添加队伍失败,队员3身份证必填");
        }
        if(StringUtils.isEmpty(requestDto.getMember3Size())){
            throw new IllegalArgumentException("添加队伍失败,队员3尺码必填");
        }
        if(StringUtils.isEmpty(requestDto.getFuDao1Name())){
            throw new IllegalArgumentException("添加队伍失败,辅导老师1姓名必填");
        }
        if(StringUtils.isEmpty(requestDto.getFuDao1Id())){
            throw new IllegalArgumentException("添加队伍失败,辅导老师1身份证必填");
        }
        if(StringUtils.isEmpty(requestDto.getFuDao2Name())){
            throw new IllegalArgumentException("添加队伍失败,辅导老师2姓名必填");
        }
        if(StringUtils.isEmpty(requestDto.getFuDao2Id())){
            throw new IllegalArgumentException("添加队伍失败,辅导老师2身份证必填");
        }


        //特殊类别校验　属性在大类上
        ProjectClass projectClass = projectClassRepository.findById(requestDto.getClass1Id()).get();


        if(projectClass.getSpecial() == null){
            throw new IllegalArgumentException("添加队伍失败,队伍选定的大类未绑定特殊属性值");
        }

        //特殊属性值　三张图片以及word或第四张图片必填
//        if(projectClass.getSpecial() == 1){
//            if(StringUtils.isEmpty(requestDto.getImg1())){
//                throw new IllegalArgumentException("添加队伍失败,辅导老师2身份证必填");
//            }
//        }
    }

}
