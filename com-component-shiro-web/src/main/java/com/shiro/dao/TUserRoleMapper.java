package com.shiro.dao;

import com.shiro.entity.module.TUserRole;
import java.util.List;

public interface TUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    int deleteByUserId(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int insert(TUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    TUserRole selectByPrimaryKey(Long id);

    List<TUserRole> selectByRoleId(Long roleId);

    List<TUserRole> selectByUserid(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    List<TUserRole> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TUserRole record);
}