package com.leyou.common.vo;

import java.util.List;

/**
 * Created by jingxingqiang on 2020/1/4 0:04
 */
public class PageResult<T> {
    /**总条数*/
    private Long total;
    /**总页数*/
    private Integer totalPage;
    /**当前页数据*/
    private List<T> dataObject;

    public PageResult() {
    }

    /**
     * 总数和总记录数
     * @param total
     * @param dataObject
     */
    public PageResult(Long total, List<T> dataObject) {
        this.total = total;
        this.dataObject = dataObject;
    }

    public PageResult(Long total, Integer totalPage, List<T> dataObject) {
        this.total = total;
        this.totalPage = totalPage;
        this.dataObject = dataObject;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataObject() {
        return dataObject;
    }

    public void setDataObject(List<T> dataObject) {
        this.dataObject = dataObject;
    }
}
