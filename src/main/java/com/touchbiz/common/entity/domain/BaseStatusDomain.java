package com.touchbiz.common.entity.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseStatusDomain extends BaseDomain {

    /**
     * 启用状态：0：禁用 1：启用
     */
    private Boolean status;
}
