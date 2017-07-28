# 权限管理数据初始化数据插入
USE `shiro_db`;

INSERT INTO t_user (user_name, login_name, password, salt, enabled, create_by, create_time, modify_by, modify_time, edition)
VALUES ('houjun','houjun','0865074dc31d5007d5eeebdff992ef7c','8636940f3297a0fb08e564b38a6a2253',1 ,'sys',now(),'sys',now(),1);

INSERT INTO t_role (role_name, description, super_admin, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('superAdmin','超级管理员',1,1 ,'sys',now(),'sys',now(),1);

INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('UserInfo','用户操作','control','控制权','用户操作.控制权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('Role','角色管理','control','控制权','角色管理.控制权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('CheckDef','任务定义','control','控制权','任务定义.控制权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('CheckPlan','任务计划','control','控制权','任务计划.控制权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('CheckResult','任务结果','control','控制权','任务结果.控制权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('DiffHandler','差异处理','control','控制权','差异处理.控制权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('ExtractData','数据抽取','maintain','维护权','数据抽取.维护权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('ExtractData','数据抽取','view','查看权','数据抽取.查看权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('ExtractData','数据抽取','extract','抽取权','数据抽取.抽取权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('JOBCheck','Job检查','control','控制权','Job检查.控制权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('DbConfig','数据库配置','control','控制权','Job检查.控制权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('RedisRefresh','缓存刷新','maintain','维护权','缓存刷新.维护权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('RedisRefresh','缓存刷新','view','查看权','缓存刷新.查看权',1,'sys',now(),'sys',now(),1);
INSERT INTO t_permission (module_code, module_name, perm_code, perm_name, description, available, create_by, create_time, modify_by, modify_time, edition)
VALUES ('RedisRefresh','缓存刷新','refresh','刷新权','缓存刷新.刷新权',1,'sys',now(),'sys',now(),1);

INSERT INTO t_user_role (user_id, role_id, create_by, create_time) VALUES (1,1,'sys',now());