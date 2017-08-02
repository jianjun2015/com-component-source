create DATABASE `my_sso`;

CREATE  TABLE  `t_user` (

  `id`  bigint(15)   NOT  NULL  COMMENT'主键',

  `account`  varchar(30)  DEFAULT  NULL  COMMENT'账号',

  `password` varchar(255)  DEFAULT  NULL  COMMENT'密码',

  `valid` tinyint(1)  DEFAULT  NULL COMMENT  '是否有效',

  PRIMARY  KEY(`id`)

) ENGINE=InnoDB   DEFAULT  CHARSET=utf8;

insert  into `t_user`(`id`,`account`,`password`,`valid`) values (25019377879351296,'cj','123456',1),

  (25019377879351297,'zhangsan','123456',1);