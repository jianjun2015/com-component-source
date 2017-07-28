package com.shiro.service.impl;

import com.shiro.dao.TRoleMapper;
import com.shiro.dao.TRolePermissionMapper;
import com.shiro.dao.TUserMapper;
import com.shiro.dao.TUserRoleMapper;
import com.shiro.entity.entity.Role;
import com.shiro.entity.entity.UserRole;
import com.shiro.entity.module.TRole;
import com.shiro.entity.module.TUser;
import com.shiro.entity.module.TUserRole;
import com.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by wangjianjun on 2017/5/31.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Autowired
    private TRoleMapper roleMapper;

    @Autowired
    private TRolePermissionMapper rolePermissionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRole(Role role){

        TRole tRole = writeTRole(role);
        try{
            roleMapper.insert(tRole);
        } catch (DuplicateKeyException e) {
            System.out.println("请勿重复提交");
        }
    }

    @Override
    public int deleteRole(Role role) {
        return roleMapper.deleteByPrimaryKey(role.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRole(Role role){

        TRole tRole = writeTRole(role);
        int count=0;
        try{
            count = roleMapper.updateByPrimaryKey(tRole);
        } catch (DuplicateKeyException e) {
            System.out.println("请勿重复提交");
        }

        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserRole(String loginName, List<Role> roles) {
        TUser tUser = userMapper.selectByLoginName(loginName);
        Long userId = tUser.getId();

        //获取用户拥有角色的应对关系
        List<TUserRole> tUserRoles = userRoleMapper.selectByUserid(tUser.getId());
        for (TUserRole t:tUserRoles){
            userRoleMapper.deleteByPrimaryKey(t.getId());
        }

        TUserRole tUserRole;
        for (Role role:roles){
            tUserRole = new TUserRole();
            tUserRole.setUserId(userId);
            tUserRole.setRoleId(role.getId());
            tUserRole.setCreateTime(new Date());
            tUserRole.setCreateBy("sys");

            userRoleMapper.insert(tUserRole);
        }
    }

    @Override
    public List<UserRole> getAllUsersByRoleId(Long roleId) {
        List<TUserRole> tUserRoles = userRoleMapper.selectByRoleId(roleId);
        List<UserRole> userRoles = writeUserRole(tUserRoles);
        return userRoles;
    }


    @Override
    @Transactional
    public int deleteUserRole(Long userId) {
        int result = userRoleMapper.deleteByUserId(userId);
        return result;
    }

    @Override
    public List<Role> getAllRoles() {
        List<TRole> tRoles = roleMapper.selectAll();

        TRole tRoleTmp=null;
        for (TRole tRole:tRoles){
            //过滤超级管理员角色-只能初始化给超级管理员用户
            if (tRole.getRoleName().equalsIgnoreCase("superAdmin"))
                tRoleTmp = tRole;
        }

        if (tRoleTmp != null)
            tRoles.remove(tRoleTmp);
        List<Role> roles = writeRole(tRoles);

        return roles;
    }

    @Override
    public List<Role> getAllRolesByLoginName(String loginName) {
        List<TRole> tRoles = roleMapper.selectAllRoleByLoginName(loginName);
        List<Role> roles = writeRole(tRoles);

        return roles;
    }

    @Override
    public List<Role> getAllRolesByRolename(List<String> roleNames) {

        List<TRole> tRoles = roleMapper.selectAllRoleByRoleNames(roleNames);
        List<Role> roles = writeRole(tRoles);
        return roles;
    }

    @Override
    public Set<String> getAllRoleNameByLoginName(String loginName){

        List<TRole> tRoles = roleMapper.selectAllRoleByLoginName(loginName);
        List<Role> roles = writeRole(tRoles);
        Set<String> roleNames = new HashSet<>();

        if (roles == null || roles.size()==0)
            return roleNames;

        for (Role role:roles)
            roleNames.add(role.getRoleName());

        return roleNames;
    }

    @Override
    public List<Role> getRolesByIds(List<Long> ids) {
        return null;
    }

    @Override
    public Role getRoleByRolename(String roleName) {

        TRole tRole = roleMapper.selectByRoleName(roleName);
        if (tRole == null)
            return null;

        List<TRole> tRoles = new ArrayList<>();
        tRoles.add(tRole);

        Role role = writeRole(tRoles).get(0);
        return role;
    }

    private List<Role> writeRole(List<TRole> tRoles){

        List<Role> roles = null;
        if (tRoles == null || tRoles.size() == 0)
            return roles;

        roles = new ArrayList<>();
        Role role;
        for (TRole tRole:tRoles){

            role = new Role();
            roles.add(role);

            role.setId(tRole.getId());
            role.setRoleName(tRole.getRoleName());
            role.setDescription(tRole.getDescription());
            role.setAvailable(tRole.getAvailable());
            role.setSuperAdmin(tRole.getSuperAdmin());
            role.setEdition(tRole.getEdition());
            role.setCreateBy(tRole.getCreateBy());
            role.setCreateTime(tRole.getCreateTime());
            role.setModifyBy(tRole.getModifyBy());
            role.setModifyTime(tRole.getModifyTime());
        }

        return roles;
    }

    private TRole writeTRole(Role role){

        TRole tRole = new TRole();

        if (role.getId() != null)
            tRole.setId(role.getId());
        tRole.setRoleName(role.getRoleName());
        tRole.setDescription(role.getDescription());
        tRole.setAvailable(role.getAvailable());
        tRole.setSuperAdmin(role.getSuperAdmin());
        tRole.setEdition(1);
        tRole.setCreateBy("sys");
        tRole.setCreateTime(new Date());
        tRole.setModifyBy("sys");
        tRole.setModifyTime(new Date());

        return tRole;
    }

    private List<UserRole> writeUserRole(List<TUserRole> tUserRoles){
        if (tUserRoles == null || tUserRoles.size()==0){
            return new ArrayList<>();
        }

        List<UserRole> userRoles = new ArrayList<>();
        UserRole userRole = null;
        for (TUserRole tUserRole:tUserRoles){
            userRole = new UserRole();
            userRoles.add(userRole);

            userRole.setUserId(tUserRole.getUserId());
            userRole.setRoleId(tUserRole.getRoleId());
        }

        return userRoles;
    }
}
