package com.star.robot.entity;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    private Team team;
}
