/**
 * 版权所有(C)，洛哈网络，2015，所有权利保留。
 * <p>
 * 项目名：	yqc-api
 * 文件名：	PagingResult.java
 * 模块说明：
 * 修改历史：
 * 2015-7-22 - houjun - 创建。
 */
package com.base.util.paging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author houjun
 *
 */
public class PagingResult<T> extends PagingInfo implements Serializable {

    private static final long serialVersionUID = -3309471999979955144L;

    private List<T> records = new ArrayList<T>();

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public PagingResult() {

    }

    public PagingResult(PagingInfo pageInfo) {
        if (pageInfo == null)
            return;
        setPage(pageInfo.getPage());
        setPageSize(pageInfo.getPageSize());
        setPageCount(pageInfo.getPageCount());
        setRecordCount(pageInfo.getRecordCount());
        setHasMore(pageInfo.isHasMore());
    }

    public PagingResult(Paging paging) {
        super(paging);
    }

}