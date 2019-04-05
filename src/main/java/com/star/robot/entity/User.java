package com.star.robot.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String phone ;

    @Column
    private String passwd;

    @Column
    private Integer provinceId;

    @Column
    private Integer cityId;

    @Column
    private Integer areaId;

    @Column
    private Long companyId;
}
