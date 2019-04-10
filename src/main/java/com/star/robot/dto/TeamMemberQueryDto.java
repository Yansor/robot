package com.star.robot.dto;

import com.star.robot.enums.TeamClotherSizeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamMemberQueryDto extends  TeamBackendQueryDto {

    //队员衣服
    private TeamClotherSizeEnum sizeEnum;


}
