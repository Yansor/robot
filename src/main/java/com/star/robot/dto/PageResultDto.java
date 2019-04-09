package com.star.robot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResultDto<T>{
    @Builder.Default
    private String code ="0";

    private Long count; //总条数

    private List<T> data;

    private String msg;


}
