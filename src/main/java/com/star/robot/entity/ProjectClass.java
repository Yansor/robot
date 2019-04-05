package com.star.robot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 项目类别
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel
public class ProjectClass {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name; //类别名称

    @Column
    private Integer level ; //层级　1层大类　2层小类

    @Column
    private Long parentId;

    @ApiModelProperty(value = "当前类别是否是特殊属性的类别")
    @Column
    private Integer special;//0 普通大类　1 特殊大类　是否显示三张图片
}
