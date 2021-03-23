package com.touchbiz.common.entity.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseCorpDomain extends BaseDomain {

    /**
     * 第三方公司id
     */
    private Long corpId;
}
