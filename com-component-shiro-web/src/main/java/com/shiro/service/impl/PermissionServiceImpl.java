package com.shiro.service.impl;

import com.shiro.dao.TPermissionMapper;
import com.shiro.dao.TRoleMapper;
import com.shiro.dao.TRolePermissionMapper;
import com.shiro.entity.cond.PermissionCond;
import com.shiro.entity.entity.Permission;
import com.shiro.entity.entity.RolePermission;
import com.shiro.entity.module.TPermission;
import com.shiro.entity.module.TRole;
import com.shiro.entity.module.TRolePermission;
import com.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by wangjianjun on 2017/5/31.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private TPermissionMapper permissionMapper;

    @Autowired
    private TRoleMapper roleMapper;

    @Autowired
    private TRolePermissionMapper rolePermissionMapper;

    @Override
    public List<Permission> getAllPermissions() {

        List<TPermission> tPermissions = permissionMapper.selectAll();

        return writePermissions(tPermissions);
    }

    @Override
    public int deleteRolePermissionByRoleId(Long roleId) {
        return rolePermissionMapper.deleteByRoleId(roleId);
    }

    @Override
    public List<RolePermission> getRolePermissionsByRoleId(Long roleId) {
//        List<TRolePermission> tRolePermissions = rolePermissionMapper.
        return null;
    }

    @Override
    public List<Permission> getPermsByRoleName(String roleName) {

        List<TPermission> tPermissions = permissionMapper.selectAllByRoleName(roleName);

        return writePermissions(tPermissions);
    }

    @Override
    public Set<String> getPermNameByLoginName(String loginName, String type) {

        List<TPermission> tPermissions = null;
        List<TRole> tRoles = roleMapper.selectAllRoleByLoginName(loginName);
        //如果拥有超级管理员的角色，则默认获取所有的权限
        for (TRole tRole:tRoles){
            if (Boolean.TRUE.equals(tRole.getSuperAdmin())){
                tPermissions = permissionMapper.selectAll();
                break;
            }
        }

        if (tPermissions == null)
            tPermissions = permissionMapper.selectPermByLoginName(loginName);

        List<Permission> permissions = writePermissions(tPermissions);
        Set<String> permNames = new HashSet<>();

        for (Permission p : permissions) {
            String permName;
            if (type!=null && type.equals("name")) {
                permName = p.getModuleName() + ":" + p.getPermName();
            }else {
                permName = p.getModuleCode() + ":" + p.getPermCode();
            }
            permNames.add(permName);
        }

        return permNames;
    }

    @Override
    public List<Permission> getPermissionsByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<Permission> getPermissionsByPermConds(List<PermissionCond> permConds) {

        List<TPermission> tPermissions = permissionMapper.selectAll();
        List<TPermission> permissionsByCond = new ArrayList<>();
        for (PermissionCond cond:permConds){
            for (TPermission tPermission:tPermissions){
                if (tPermission.getModuleName().equals(cond.getModuleName())
                        &&tPermission.getPermName().equals(cond.getPermName()))
                    permissionsByCond.add(tPermission);
            }
        }

        return writePermissions(permissionsByCond);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRolePermission(Long roleId, List<Long> rolePermissionIds) {

        rolePermissionMapper.deleteByRoleId(roleId);
        TRolePermission tRolePermission;

        for (Long permId:rolePermissionIds){
            tRolePermission = new TRolePermission();
            tRolePermission.setRoleId(roleId);
            tRolePermission.setPermissionId(permId);
            tRolePermission.setCreateBy("sys");
            tRolePermission.setCreateTime(new Date());

            rolePermissionMapper.insert(tRolePermission);
        }

    }

    @Override
    public int delRolePermissionByRoleId(Long roleId) {

        return rolePermissionMapper.deleteByRoleId(roleId);
    }

    private List<Permission> writePermissions(List<TPermission> tPermissions){

        List<Permission> permissions = new ArrayList<>();
        Permission permission;
        for (TPermission tp:tPermissions){
            permission = new Permission();
            permissions.add(permission);

            permission.setId(tp.getId());
            permission.setModuleCode(tp.getModuleCode());
            permission.setModuleName(tp.getModuleName());
            permission.setPermCode(tp.getPermCode());
            permission.setPermName(tp.getPermName());
            permission.setAvailable(tp.getAvailable());
            permission.setDescription(tp.getDescription());
            permission.setCreateBy(tp.getCreateBy());
            permission.setCreateTime(tp.getCreateTime());
            permission.setModifyBy(tp.getModifyBy());
            permission.setModifyTime(tp.getModifyTime());
        }

        return permissions;
    }
}
