package com.soft1851.springboot.quartz.controller.Dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * @author wl
 * @ClassNamesad
 * @description: 修改cron表达式的dto类
 * @description: 修改cron表达式的dto类
 * @Date 2020/5/18
 * @Version 1.0
 */
@Data
public class ModifyCronDto {
    @NotNull(message = "the job id cannot be null")
    private Integer id;

    @NotEmpty(message = "the cron cannot be empty")
    private String cron;
}
