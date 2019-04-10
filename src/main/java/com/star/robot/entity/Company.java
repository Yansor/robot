package com.star.robot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.star.robot.dto.PageRequestDto;
import com.star.robot.enums.CompanyTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 单位管理，包含学校　和　机构
 */

@Entity
@Data
@NoArgsConstructor
public class Company extends PageRequestDto {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String zhiZhao; //营业执照名称

    @Column
    private String provinceId;

    @Column
    private String cityId;

    @Column
    private String areaId;

    @Column
    private CompanyTypeEnum companyType; // 1 学校　2　机构

    @Column
    private Boolean status;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;

    @Column
    private String invoiceHeader ; //发票抬头

    @Column
    private String invoiceTaxNo;//发票税号
}
