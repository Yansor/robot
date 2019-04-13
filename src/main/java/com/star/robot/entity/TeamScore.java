package com.star.robot.entity;

import javax.persistence.*;

/**
 * 队伍成绩　
 */
@Table(name = "team_score")
@Entity
public class TeamScore {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Float score;//成绩

    @Column
    private Integer lunCi;//轮次

    @Column
    private Boolean status;//fabu

    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    private Team team;

}
