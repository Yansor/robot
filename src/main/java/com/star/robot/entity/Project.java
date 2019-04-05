package com.star.robot.entity;

/**
 * 项目
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    private Long class1Id; //第一大类

    private Long class2Id; //第二小类

    private Integer groupType; //组别 1小学组　2中学组　3大学组

    private String teamName;//队伍名称

    private String member1Name;

    private String member1Sex; //1 男　2　女

    private String member1Id; //身份证

    private String member1Size;

    private String member2Name;

    private String member2Sex; //1 男　2　女

    private String member2Id; //身份证

    private String member2Size;

    private String member3Name;

    private String member3Sex; //1 男　2　女

    private String member3Id; //身份证

    private String member3Size;

    private String fuDao1Name;

    private String fuDao1Id;//辅导老师1身份证

    private String fuDao2Name;

    private String fuDao2Id;//辅导老师2身份证

    private Integer special;//0 普通大类　1 特殊大类　是否显示三张图片

    private String img1; //图片1

    private String img2;//图片2

    private String img3; //图片3

    private Boolean word;//研究报告或者word文档

    private String wordImg;//研究报告或者word文档预览图片

    private String phone; //关联用户
}
