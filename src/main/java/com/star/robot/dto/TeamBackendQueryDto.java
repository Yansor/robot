package com.star.robot.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamBackendQueryDto extends PageRequestDto{

    private Long provinceId;

    private Long cityId;

    private Long areaId;

    private String teamMemberName; //队员姓名

    private String teamMemberIdCard;//队员身份证

    private Long companyId;//单位ID

    private String teamName;//队伍名称

    private Integer companyType;//单位性质 1学校　２　机构

    //时间格式　2019-01-03 2019-01-04
    private String baoMingDateStart;

    private String baoMingDateEnd;

    private Long class1Id;//大类

    private Long class2Id;//小类

    private Integer groupType; //组别 1小学组　2中学组　3大学组


}
