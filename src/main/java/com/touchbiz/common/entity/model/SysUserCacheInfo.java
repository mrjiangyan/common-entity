package com.touchbiz.common.entity.model;

import com.touchbiz.common.entity.annotation.SensitiveField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class SysUserCacheInfo {

    private String sysUserCode;

    private String sysUserName;

    private String sysOrgCode;

    private List<String> sysMultiOrgCode;

    private boolean oneDepart;

    /**
     * 登录人id
     */
    @SensitiveField
    private String id;

    /**
     * 登录人账号
     */
    @SensitiveField
    private String username;

    /**
     * 登录人名字
     */
    @SensitiveField
    private String realname;

    /**
     * 当前登录部门code
     */
    private String orgCode;
    /**
     * 头像
     */
    @SensitiveField
    private String avatar;

    /**
     * 电子邮件
     */
    @SensitiveField
    private String email;


    /**
     *  身份（1 普通员工 2 上级）
     */
    private Integer userIdentity;

    /**
     * 管理部门ids
     */
    private String departIds;

    /**设备id uniapp推送用*/
    private String clientId;
}
