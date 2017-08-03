/**
 * 版权所有(C)，洛哈网络，2015，所有权利保留。
 * <p>
 * 项目名：	yqc-api
 * 文件名：	YqcPageInfo.java
 * 模块说明：
 * 修改历史：
 * 2015-8-5 - houjun - 创建。
 */
package com.base.util.paging;

/**
 * @author houjun
 *
 */
public class PagingInfo extends Paging {

    private int pageCount = 0;
    private long recordCount = 0;
    private boolean hasMore = false;

    /** 查询结果总页数 */
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /** 查询结果总记录数 */
    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    /** 指示是否还有下一页,该指示是根据分页大小和结果数来判断，某些情况下可能会不准确 */
    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public PagingInfo() {

    }


    public PagingInfo(Paging paging) {
        if (paging == null)
            return;
        setPage(paging.getPage());
        setPageSize(paging.getPageSize());
    }
}
