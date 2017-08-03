package com.base.util.paging;

/**
 * Created by houjun on 2016-12-12.
 */
public class Paging {
    /**
     * 当前页码,从1开始
     */
    private int page = 1;
    /**
     * 分页大小 [0,100],0表示不分页
     */
    private int pageSize = 20;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Paging(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Paging() {

    }
}
