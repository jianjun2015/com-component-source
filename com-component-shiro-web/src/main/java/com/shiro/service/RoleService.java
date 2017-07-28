package com.shiro.service;


import com.shiro.entity.entity.Role;
import com.shiro.entity.entity.UserRole;

import java.util.List;
import java.util.Set;

/**
 * Created by wangjianjun on 2017/5/31.
 */
public interface RoleService {

    public void addRole(Role role);

    public int deleteRole(Role role);

    public int updateRole(Role role);

    public void addUserRole(String loginName, List<Role> role);

    public List<UserRole> getAllUsersByRoleId(Long roleId);

    public int deleteUserRole(Long userId);

    public List<Role> getAllRoles();

    public List<Role> getAllRolesByLoginName(String loginName);

    public List<Role> getAllRolesByRolename(List<String> roleNames);

    public Set<String> getAllRoleNameByLoginName(String loginName);

    public List<Role> getRolesByIds(List<Long> ids);

    public Role getRoleByRolename(String roleName);
}
