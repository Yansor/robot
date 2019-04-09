package com.star.robot.controller;

import com.star.robot.dto.ResultDto;
import com.star.robot.dto.TeamRequestDto;
import com.star.robot.entity.Team;
import com.star.robot.entity.TeamClass;
import com.star.robot.repository.ProjectClassRepository;
import com.star.robot.repository.TeamRepository;
import com.star.robot.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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
        Team team = new Team();
        BeanUtils.copyProperties(requestDto , team);
        //设置队伍关联的用户
        String phone = userService.getCurrentUser(request);
        team.setPhone(phone);
        teamRepository.save(team);
        return ResultDto.builder().build();
    }

    @GetMapping
    public ResultDto get(HttpServletRequest request){
        String phone = userService.getCurrentUser(request);
        if(StringUtils.isEmpty(phone)){
            return ResultDto.builder().data(null).build();
        }else{
            List<Team> teams = teamRepository.findAll().parallelStream().filter(team -> phone.equals(team.getPhone())).collect(Collectors.toList());
            return ResultDto.builder().data(teams).build();
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
        if(CollectionUtils.isEmpty(requestDto.getTeamMembers())){
            throw new IllegalArgumentException("添加队伍失败,队员至少一个");
        }
        if(CollectionUtils.isEmpty(requestDto.getTeamLeaders())){
            throw new IllegalArgumentException("添加队伍失败,辅导老师至少一个");
        }

        //特殊类别校验　属性在大类上
        TeamClass teamClass = projectClassRepository.findById(requestDto.getClass1Id()).get();


        if(teamClass.getSpecial() == null){
            throw new IllegalArgumentException("添加队伍失败,队伍选定的大类未绑定特殊属性值");
        }

        //特殊属性值　三张图片以及word或第四张图片必填
//        if(teamClass.getSpecial() == 1){
//            if(StringUtils.isEmpty(requestDto.getImg1())){
//                throw new IllegalArgumentException("添加队伍失败,辅导老师2身份证必填");
//            }
//        }
    }

}
