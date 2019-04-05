package com.star.robot.repository;

import com.star.robot.entity.DtArea;
import com.star.robot.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoty extends CrudRepository<User, Long> {

    public User findByPhoneAndPasswd(String username , String passwd);
}
