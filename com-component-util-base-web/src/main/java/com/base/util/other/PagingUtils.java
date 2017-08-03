package com.base.util.other;


import com.base.util.converter.Converter;
import com.base.util.paging.PagingQueryDef;
import com.base.util.paging.PagingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by houjun on 2016-2-16.
 */
public class PagingUtils {
    private PagingUtils() {

    }

    public static Map<String, Object> toMap4Query(PagingQueryDef queryDef) {
        Map<String, Object> params = new HashMap<>();
        params.put("orderBy", queryDef.getOrderBy());
        params.put("startRow", (Math.max(queryDef.getPage() - 1, 0)) * queryDef.getPageSize());
        params.put("fetchRows", queryDef.getPageSize());
        return params;
    }


    /**
     * 转换QueryResult的对象类型
     *
     * @param sourceResult
     * @param converter
     * @return
     */
    public static <S, T> PagingResult<T> typedQueryResult(PagingResult<S> sourceResult,
                                                          Converter<S, T> converter) {
        Args.notNull(converter, "converter");
        if (sourceResult == null)
            return null;
        PagingResult<T> result = new PagingResult<>(sourceResult);
        result.setRecords(ConverterUtil.convert(sourceResult.getRecords(), converter));
        return result;
    }

    /**
     * 计算分页信息
     *
     * @param result
     * @param totalCnt
     */
    public static <T> void assignPagingResult(PagingResult<T> result, int totalCnt, List<T> objs) {
        Args.notNull(result, "result");
        result.setRecords(objs);
        if (result.getPageSize() == 0)// 不分页
        {
            result.setRecordCount(objs.size());
            result.setPageCount(1);
        } else {
            result.setRecordCount(totalCnt);
            result.setPageCount(totalCnt % result.getPageSize() == 0 ? totalCnt / result.getPageSize()
                    : (totalCnt / result.getPageSize() + 1));
        }
        result.setHasMore(result.getPageCount() > (result.getPage() + 1));
    }

}
