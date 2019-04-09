package com.star.robot.dto;
import com.star.robot.entity.Company;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
public class CompanyRequestDto extends Company {

    @ApiModelProperty(value = "请求来源:1后台,2前台")
    private Integer requestSource; // 请求来源 1 后台　2 前台

}
