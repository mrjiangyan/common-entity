package com.touchbiz.common.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author steven
 */
@Data
public class BaseDTO {

    @ApiModelProperty("项目Id")
    private Long projectId;
}
