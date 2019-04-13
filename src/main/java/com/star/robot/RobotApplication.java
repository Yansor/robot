package com.star.robot;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
@EnableSwagger2Doc
public class RobotApplication implements ApplicationListener {

    public static void main(String[] args) {
        SpringApplication.run(RobotApplication.class, args);
    }


    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        initDic();//初始化字典表

    }

    private void initDic() {

    }
}
