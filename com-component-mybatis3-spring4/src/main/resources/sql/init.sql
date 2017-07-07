DROP DATABASE IF EXISTS mybatis;
CREATE DATABASE mybatis DEFAULT CHARSET=utf8;

USE mybatis;

DROP TABLE IF EXISTS t_user;
CREATE TABLE `t_user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `user_birthday` date DEFAULT NULL,
  `user_salary` double DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';