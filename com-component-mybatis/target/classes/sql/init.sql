CREATE DATABASE `com-component` DEFAULT CHARSET=utf8;

USE `com-component`;

CREATE TABLE `t_test_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `inspection_name` varchar(64) NOT NULL COMMENT '检查名称',
  `order_no` int(3) unsigned NOT NULL COMMENT '执行顺序号',
  `expect_result` varchar(64) NOT NULL COMMENT '期望结果',
  `msg_on_unexpected` varchar(256) DEFAULT NULL COMMENT '不符合期望时的提示消息',
  `inspection_sql` varchar(4096) NOT NULL COMMENT '检查sql，符合jdbc的prepare sql的语法',
  `parameters` varchar(2048) DEFAULT NULL COMMENT '参数，json格式',
  `remark` varchar(128)  NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
   KEY `idx_inspection_rule_1` (`inspection_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '测试';


