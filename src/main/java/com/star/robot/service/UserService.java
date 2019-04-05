package com.star.robot.service;

import com.star.robot.constant.Constant;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {
    /**
     *
     * @return　手机号
     */
    public String getCurrentUser(HttpServletRequest request){
        Object currentUserSession = request.getSession().getAttribute(Constant.CURRENTUSER);
        return currentUserSession  == null ? null : currentUserSession.toString();
    }
}
