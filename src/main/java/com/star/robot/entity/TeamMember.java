package com.star.robot.entity;

import com.star.robot.enums.TeamClotherSizeEnum;

import javax.persistence.*;

@Entity
@Table(name = "team_member")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer sex;

    @Column
    private String idCard; //身份证

    @Column
    private TeamClotherSizeEnum size;

    @Column
    private String school;//所在学校

    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    private Team team;
}
