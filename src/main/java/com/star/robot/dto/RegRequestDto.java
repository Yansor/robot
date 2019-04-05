package com.star.robot.dto;

import com.star.robot.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegRequestDto extends User {
    private String verfiCode;//验证码
}
