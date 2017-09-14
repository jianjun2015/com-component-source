# drop table if exists tablename

# ALTER TABLE test  MODIFY COLUMN user_age int(4) COMMENT '年龄';

# add data
# LOCK TABLES `test` WRITE;
# INSERT INTO `test` VALUES (3,'jack',20,now(),100,0);
# UNLOCK TABLES;

ALTER TABLE test add COLUMN version_ int(4) DEFAULT 0 COMMENT '版本号-乐观锁机制';