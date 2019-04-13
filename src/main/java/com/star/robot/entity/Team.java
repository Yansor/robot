package com.star.robot.entity;

/**
 * 项目
 */
import com.star.robot.enums.TeamGroupTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private Long provinceId;

    private Long cityId;

    private Long areaId;

    @OneToOne
    private Company company;

    private Long class1Id; //第一大类

//    private Long class2Id; //第二小类

    private TeamGroupTypeEnum groupType; //组别 1小学组　2中学组　3大学组

    private String teamName;//队伍名称

    @OneToOne
    private Project project;

    @OneToMany(mappedBy = "team")
    private List<TeamMember> teamMembers;

    @OneToMany(mappedBy = "team")
    private List<TeamLeader> teamLeaders;

//    private Integer special;//0 普通大类　1 特殊大类　是否显示三张图片
//
//    private String img1; //图片1
//
//    private String img2;//图片2
//
//    private String img3; //图片3

//    private Boolean word;//研究报告或者word文档
//
//    private String wordImg;//研究报告或者word文档预览图片

    private String phone; //关联用户

    private Date createTime;//创建时间

    private Boolean xuanBa;//是否选拔赛

    private Long templateId;//队伍模板id

    @OneToOne
    private JiaoFei jiaoFei;

    @Column
    private Boolean confirmStatus;// 是否确认过报名

    @OneToMany(mappedBy = "team")
    private List<TeamScore> teamScores;

}
