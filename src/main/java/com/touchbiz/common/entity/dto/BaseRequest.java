package com.touchbiz.common.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author steven
 */
@Data
@ApiModel("基础请求对象")
public class BaseRequest {

    @ApiModelProperty("用户信息")
    private User user;

    @ApiModelProperty("渠道id")
    private Long channelId;

    @ApiModelProperty("第三方公司Id")
    private Long corpId;

    @Data
    @AllArgsConstructor
    public static class User{

        @ApiModelProperty("用户id")
        private Long userId;

        @ApiModelProperty("用户姓名")
        private String name;

        @ApiModelProperty("为true为前端用户，为false为后台用户")
        private Boolean external;

    }
}
