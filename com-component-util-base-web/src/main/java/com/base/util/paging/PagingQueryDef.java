package com.base.util.paging;

import java.io.Serializable;

/**
 * Created by houjun on 2016-12-12.
 */
public class PagingQueryDef extends Paging implements Serializable {
    private static final long serialVersionUID = -4183117673539790990L;

    private  String orderBy;
    private QueryOrderDirection direction = QueryOrderDirection.asc;

    public QueryOrderDirection getDirection() {
        return direction;
    }

    public void setDirection(QueryOrderDirection direction) {
        this.direction = direction;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public PagingQueryDef(int page, int pageSize) {
        setPage(page);
        setPageSize(pageSize);
    }

    public PagingQueryDef() {
    }
}
