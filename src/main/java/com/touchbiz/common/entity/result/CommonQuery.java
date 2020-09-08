package com.touchbiz.common.entity.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommonQuery {

	@ApiModelProperty(hidden=true, value = "调用方项目六位编码", example="000000")
	private String channelCode;

	@ApiModelProperty(hidden=true, value = "调用方项目id", example="1")
	private Integer tlProjectId;
}
