package com.star.robot.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> {

    public static String DEFAULT_MESSAGE = "非法操作";
    @Builder.Default
    private Boolean success=Boolean.TRUE;

    private T data;

    private String message;
}
