package com.shiro.service;

import com.shiro.entity.cond.PermissionCond;
import com.shiro.entity.entity.Permission;
import com.shiro.entity.entity.RolePermission;

import java.util.List;
import java.util.Set;

/**
 * Created by wangjianjun on 2017/5/31.
 */
public interface PermissionService {

    public List<Permission> getAllPermissions();

    public int deleteRolePermissionByRoleId(Long roleId);

    public List<RolePermission> getRolePermissionsByRoleId(Long roleId);

    public List<Permission> getPermsByRoleName(String roleName);

    public Set<String> getPermNameByLoginName(String loginName, String type);

    public List<Permission> getPermissionsByIds(List<Long> ids);

    public List<Permission> getPermissionsByPermConds(List<PermissionCond> permConds);

    public void addRolePermission(Long roleId, List<Long> rolePermissionIds);
    public int delRolePermissionByRoleId(Long roleId);
}
