package com.star.robot.entity;

import com.star.robot.enums.AdminTypeEnum;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column
    private String username;

    @Column
    private String passwd;

    @Column
    private Boolean status;

    @Column
    private Long provinceId;

    @Column
    private Long cityId;

    @Column
    private AdminTypeEnum adminTypeEnum; //省级查看全数据　市级查市　
}
