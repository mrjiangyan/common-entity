package com.touchbiz.common.entity.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author steven
 */
@Data
@ApiModel("基础分页查询信息")
public class BaseQuery implements Serializable {

    private static final int DEFAULT_PAGE_INDEX = 1;
    private static final int DEFAULT_PAGE_SIZE = 20;

    public BaseQuery() {
        this.pageIndex = DEFAULT_PAGE_INDEX;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }


    @ApiModelProperty("关键字")
    private String keyword;

    @NotNull(message = "每页数据条数不能为空")
    @Min(1)
    @Max(value = 1000,message = "单页查询数据量不能大于1000条")
    @ApiModelProperty("每页数据量")
    private Integer pageSize;

    @NotNull(message = "查询第几页数据不能为空")
    @Min(1)

    @ApiModelProperty("查询第几页数据")
    private Integer pageIndex;

    @ApiModelProperty("开始时间")
    private LocalDateTime startDate;

    @ApiModelProperty("结束时间")
    private LocalDateTime endDate;

    private Boolean export;

    @ApiModelProperty("正序还是倒序")
    private SortTypeEnum sortType;

    @ApiModelProperty("排序字段")
    private String sortField;

    @ApiModelProperty("渠道ID")
    private Integer channelId;

    @ApiModelProperty("上下架状态，0是下架1是上架")
    private Integer status;

    public Integer getOffset() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }

    public enum SortTypeEnum{
        /**
         * 正序，由小到大
         */
        ASC,
        /**
         * 倒序，由大到小
         */
        DESC,
        /**
         * 未指定
         */
        NONE
    }
}

