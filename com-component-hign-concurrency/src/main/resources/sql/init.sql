DROP DATABASE IF EXISTS high_concurrency;
CREATE DATABASE high_concurrency DEFAULT CHARSET=utf8;

USE high_concurrency;

DROP TABLE IF EXISTS t_user;
CREATE TABLE `t_user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `user_age` int(3) DEFAULT NULL COMMENT '用户年龄',
  `user_birthday` date DEFAULT NULL,
  `user_salary` double DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';