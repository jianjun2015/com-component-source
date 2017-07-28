# 添加权限相关表
drop DATABASE IF EXISTS `shiro_db`;
CREATE DATABASE `shiro_db`;
USE `shiro_db`;

drop table if exists `t_user`;
drop table if exists `t_role`;
drop table if exists `t_permission`;
drop table if exists `t_user_login_info`;
drop table if exists `t_user_role`;
drop table if exists `t_role_permission`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `login_name` varchar(100) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐',
  `enabled` tinyint(1) DEFAULT NULL DEFAULT '0' COMMENT '账号有效',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_by` varchar(32) DEFAULT NULL COMMENT '最近修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '最近修改时间',
  `edition` int(4) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_login_username` (`login_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `super_admin` tinyint(1) DEFAULT NULL DEFAULT '0' COMMENT '是否超级管理员',
  `available` tinyint(1) DEFAULT NULL DEFAULT '1' COMMENT '是否有效',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_by` varchar(32) DEFAULT NULL COMMENT '最近修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '最近修改时间',
  `edition` int(4) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_role_role` (`role_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `module_code` varchar(100) DEFAULT NULL COMMENT '模块编号',
  `module_name` varchar(100) DEFAULT NULL COMMENT '模块名称',
  `perm_code` varchar(100) DEFAULT NULL COMMENT '权限编号',
  `perm_name` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(100) DEFAULT NULL COMMENT '权限描述',
  `available` tinyint(1) DEFAULT NULL DEFAULT '0' COMMENT '是否有效',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_by` varchar(32) DEFAULT NULL COMMENT '最近修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '最近修改时间',
  `edition` int(4) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_permission` (`module_code`,`perm_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限表';

CREATE TABLE `t_user_login_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `login_name` varchar(100) DEFAULT NULL COMMENT '登录名',
  `token` varchar(255) DEFAULT NULL COMMENT 'token',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录信息表';

CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_user_role` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_roles_permissions` (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';