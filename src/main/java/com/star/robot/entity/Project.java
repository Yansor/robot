package com.star.robot.entity;

import com.star.robot.enums.ProjectClassEnum;
import com.star.robot.enums.ProjectLevelEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private ProjectClassEnum projectClassEnum;

    @Column
    private String descr;//项目简介

    @OneToMany(mappedBy = "project")
    private List<ProjectLevelEnum> projectLevelEnums;

    @Column
    private Date baoMingStartTime; //报名开始时间

    @Column
    private Date baoMingEndTime;  //报名结束时间

    @Column
    private Date projectEndTime; //项目结束时间　

    @Column
    private Boolean status;//是否有效

    @Column
    private Long cityId;

    @Column
    private Integer fuDaoCount; //辅导员人数

    @Column
    private Integer teamMemberCount; //队员人数


}
