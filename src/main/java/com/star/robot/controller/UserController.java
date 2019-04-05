package com.star.robot.controller;

import com.star.robot.constant.Constant;
import com.star.robot.dto.RegRequestDto;
import com.star.robot.dto.ResultDto;
import com.star.robot.entity.User;
import com.star.robot.repository.UserRepositoty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepositoty userRepositoty;

    @ApiOperation(value = "用户注册",notes="用户注册")
    @PostMapping(value = "/reg")
    public ResultDto reg(@RequestBody  RegRequestDto requestDto, HttpServletRequest request){
        validateParam(requestDto,request);

        User user = new User();
        BeanUtils.copyProperties(requestDto , user);
        user.setPasswd(user.getPasswd());
        userRepositoty.save(user);
        return ResultDto.builder().build();
    }

    @ApiOperation(value = "用户登录",notes="")
    @PostMapping(value = "/login")
    public ResultDto login(@RequestBody  RegRequestDto requestDto , HttpServletRequest request){
        validLoginParam(requestDto);
        User user = userRepositoty.findByPhoneAndPasswd(requestDto.getPhone() , requestDto.getPasswd());
        if(user != null){
            //session绑定手机号
            request.getSession().setAttribute(Constant.CURRENTUSER, requestDto.getPhone());
            return ResultDto.builder().build();
        }else{
            return ResultDto.builder().success(Boolean.FALSE).build();
        }

    }

    private void validLoginParam(RegRequestDto requestDto) {
        //手机号必填
        if(StringUtils.isEmpty(requestDto.getPhone())){
            throw new IllegalArgumentException("手机号必填");
        }
        //密码必填
        if(StringUtils.isEmpty(requestDto.getPasswd())){
            throw new IllegalArgumentException("密码必填");
        }
    }

    private void validateParam(RegRequestDto requestDto , HttpServletRequest request) {
        if(requestDto == null){
            throw new IllegalArgumentException("注册参数必填");
        }
        if(StringUtils.isEmpty(requestDto.getVerfiCode())){
            throw new IllegalArgumentException("验证码必填");
        }
        if(request.getSession().getAttribute("VERIFYCODE") == null
                || request.getSession().getAttribute("VERIFYCODE").equals(requestDto.getVerfiCode())){
            throw new IllegalArgumentException("短信验证码不正确");
        }
        //手机号必填
        if(StringUtils.isEmpty(requestDto.getPhone())){
            throw new IllegalArgumentException("手机号必填");
        }
        //验证码必填
        if(StringUtils.isEmpty(requestDto.getVerfiCode())){
            throw new IllegalArgumentException("验证码必填");
        }
        //密码必填
        if(StringUtils.isEmpty(requestDto.getPasswd())){
            throw new IllegalArgumentException("密码必填");
        }
        //区必填
        if(StringUtils.isEmpty(requestDto.getAreaId())){
            throw new IllegalArgumentException("区必填");
        }
        //单位必填
        if(requestDto.getCompanyId() == null){
            throw new IllegalArgumentException("单位必填");
        }

    }

}
