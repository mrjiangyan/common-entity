package com.touchbiz.common.entity.model;

import lombok.Data;

import java.util.List;

@Data
public class SysUserCacheInfo {

    private String sysUserCode;

    private String sysUserName;

    private String sysOrgCode;

    private List<String> sysMultiOrgCode;

    private boolean oneDepart;

    /**
     * 用户使用的租户ID
     */
    private Long tenanId;
}
