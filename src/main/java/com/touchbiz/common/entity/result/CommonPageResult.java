package com.touchbiz.common.entity.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 通用的分页查询响应类.
 *
 * @param <T> 记录类型
 * @author steven
 */
@Data
@ApiModel("分页的查询结果")
public class CommonPageResult<T> implements Serializable {
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", required = true)
    private Integer pageNow;
    /**
     * 分页记录数量
     */
    @ApiModelProperty(value = "分页记录数量", required = true)
    private Integer pageCount;

    /**
     * 每页的数据条数
     */
    @ApiModelProperty(value = "每页的数据条数", required = true)
    private Integer pageSize;
    /**
     * 记录条数
     */
    @ApiModelProperty(value = "总的记录数", required = true)
    private Integer count;
    /**
     * 记录列表
     */
    @ApiModelProperty(value = "记录列表", required = true)
    private List<T> list;

    public static <T> CommonPageResult<T> empty(int pageSize) {
        CommonPageResult<T> result = new CommonPageResult();
        result.setList(Collections.emptyList());
        result.setPageCount(0);
        result.setCount(0);
        result.setPageSize(pageSize);
        result.setPageNow(DEFAULT_PAGE_NOW);
        return result;
    }

    private static final int DEFAULT_PAGE_NOW = 1;
    private static final int DEFAULT_PAGE_SIZE = 20;

    public CommonPageResult() {
        this.pageNow = DEFAULT_PAGE_NOW;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public CommonPageResult(int pageNow, int pageSize) {
        if (pageNow < DEFAULT_PAGE_NOW) {
            pageNow = DEFAULT_PAGE_NOW;
        }
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageNow = pageNow;
        this.pageSize = pageSize;
    }


    public Integer getOffset() {
        return (this.getPageNow() - 1) * this.getPageSize();
    }

    public static <T> CommonPageResult<T> page(int count, int pageSize, int pageNow, List<T> results) {
        CommonPageResult<T> commonPageResult = new CommonPageResult<>();
        commonPageResult.setList(results);
        commonPageResult.setCount(count);
        commonPageResult.setPageSize(pageSize);
        commonPageResult.setPageNow(pageNow);
        // 计算总页数
        int pageCount = (pageSize == 0 || count == 0) ? 1 : (int) Math.ceil((double) count / (double) pageSize);
        commonPageResult.setPageCount(pageCount);
        return commonPageResult;
    }


    public static <T, R> CommonPageResult<R> converter(CommonPageResult<T> result, Function<T, R> converter) {
        List<T> results = result.getList();
        List<R> data = Objects.isNull(results) ?
                Collections.emptyList() : results.stream().map(converter).collect(Collectors.toList());
        return page(result.getCount(), result.getPageSize(), result.getPageNow(), data);

    }
}

