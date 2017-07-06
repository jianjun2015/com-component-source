CREATE DATABASE `module` DEFAULT CHARSET=utf8;

USE `module`;

CREATE TABLE `t_class` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `pk_t_id` (`teacher_id`),
  CONSTRAINT `pk_t_id` FOREIGN KEY (`teacher_id`) REFERENCES `t_teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_teacher() VALUES ("ls_1");
INSERT INTO t_teacher() VALUES ("ls_2");

INSERT INTO t_class() VALUES ("cs_1",1);
INSERT INTO t_class() VALUES ("cs_2",2);

CREATE TABLE `t_student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(255) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `pk_c_id` (`c_id`),
  CONSTRAINT `pk_c_id` FOREIGN KEY (`c_id`) REFERENCES `t_class` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_student(s_name,c_id) VALUES ("SA",1);
INSERT INTO t_student(s_name,c_id) VALUES ("SB",1);
INSERT INTO t_student(s_name,c_id) VALUES ("SC",1);
INSERT INTO t_student(s_name,c_id) VALUES ("SD",2);

# 存储过程
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_student_count`(IN `stu_id` int,OUT `stu_count` int)
  BEGIN
    #Routine body goes here...
    IF stu_id = 1 THEN
      SELECT count(1) FROM t_student WHERE s_id = 1 INTO stu_count;
    ELSE
      SELECT count(1) FROM t_student WHERE s_id = 2 INTO stu_count;
    END IF;
  END

#     调用存储过程
#     SET @stu_count = 0;
#     CALL module.get_student_count(2, @stu_count);
#     SELECT @stu_count;