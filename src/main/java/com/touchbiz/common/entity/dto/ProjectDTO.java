package com.touchbiz.common.entity.dto;

import lombok.Data;

/**
 * @author steven
 */
@Data
public class ProjectDTO {

    private Long projectId;

    private String projectName;

    private String projectCode;

    private String secret;
}
