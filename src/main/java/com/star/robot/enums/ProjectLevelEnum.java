package com.star.robot.enums;

import com.star.robot.entity.Project;

import javax.persistence.*;

@Table(name = "project_level")
@Entity
public enum ProjectLevelEnum {
    PROVINCELEVEL(1,"省级别") , CITYLEVEL(2,"市级别");
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



    private String name;


    ProjectLevelEnum(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "project_id",referencedColumnName = "id")
    private Project project;
}
