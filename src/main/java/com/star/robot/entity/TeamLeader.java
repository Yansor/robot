package com.star.robot.entity;

import javax.persistence.*;

/**
 * 辅导老师
 */
@Entity
@Table(name = "team_leader")
public class TeamLeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String idCard;//身份证

    @Column
    private String phone;//辅导老师手机号

    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    private Team team;
}
