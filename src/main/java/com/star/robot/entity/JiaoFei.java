package com.star.robot.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 队伍缴费　（省级）　
 */
@Entity
@Table(name = "jiaoFei")
public class JiaoFei {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date createTime;

    @Column
    private Float value;//缴费金额

    @OneToOne
    private Team team;
}
