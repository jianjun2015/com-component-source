package org.seckill.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.seckill.module.TSeckill;

public interface TSeckillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seckill
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long seckillId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seckill
     *
     * @mbggenerated
     */
    int insert(TSeckill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seckill
     *
     * @mbggenerated
     */
    TSeckill selectByPrimaryKey(Long seckillId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seckill
     *
     * @mbggenerated
     */
    List<TSeckill> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seckill
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TSeckill record);

    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime")Date killTime);

    List<TSeckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     *
     * @param paramMap
     */
    void killByProcedure(Map<String, Object> paramMap);
}