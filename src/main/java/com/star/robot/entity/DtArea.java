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
@Table(name = "dt_area")
public class DtArea {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "area_parent_id")
    private Long areaParentId;


}
