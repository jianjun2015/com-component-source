package com.base.util.mybatis;

import java.util.Date;
import java.util.List;

public interface TFinancialWorkingDaysMapper {
    /**
     * 根据主键删除数据库的记录,t_ins_fwd
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新写入数据库记录,t_ins_fwd
     *
     * @param record
     */
    int insert(TFinancialWorkingDays record);

    /**
     * 根据指定主键获取一条数据库记录,t_ins_fwd
     *
     * @param id
     */
    TFinancialWorkingDays selectByPrimaryKey(Long id);

    /**
     * ,t_ins_fwd
     */
    List<TFinancialWorkingDays> selectAll();

    /**
     * 根据主键来更新符合条件的数据库记录,t_ins_fwd
     *
     * @param record
     */
    int updateByPrimaryKey(TFinancialWorkingDays record);

    /**
     * 判断指定日期是否为金融工作日，如果不是，那么获取前一个最近的金融工作日日期
     *
     * @return
     */
    Date getFWDB(Date basicDate);

    /**
     * 判断指定日期是否为金融工作日，如果不是，那么获取接下来最近的一个金融工作日日期
     *
     * @return
     */
    Date getFWDE(Date basicDate);
}