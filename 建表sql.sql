-- 创建数据库, 用户数据库, 简易记事本数据库
CREATE DATABASE mininote_user;
CREATE DATABASE mininote_notepad;
CREATE DATABASE mininote_oauth;

-- 创建表
-- 1. 用户表
USE mininote_user;
CREATE TABLE tb_user(
	username VARCHAR(20) NOT NULL COMMENT '用户名',
	PASSWORD VARCHAR(100) NOT NULL COMMENT '密码',
	age INT NOT NULL COMMENT '用户年龄',
	address VARCHAR(20) NOT NULL COMMENT '用户地址',
	PRIMARY KEY (`username`),
	UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表'

--  插入测试用户数据
INSERT INTO `mininote_user`.`tb_user` (username,PASSWORD,age,address) 
VALUES
  (
    'lisi',
    '$2a$10$BSLcqgwBjl3SbdakiVBolu924YZVykbl8NQacJ4Q7B8oEsCI2a4t2',
    '22',
    'sh'
  ) ;
INSERT INTO `mininote_user`.`tb_user` (username,PASSWORD,age,address) 
VALUES
  (
    'zhangsan',
    '$2a$10$BSLcqgwBjl3SbdakiVBolu924YZVykbl8NQacJ4Q7B8oEsCI2a4t2',
    '22',
    'sz'
  ) ;

-- 2. 记事本 表
USE mininote_notepad;
CREATE TABLE tb_notepad(
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '笔记id',
	username VARCHAR(20) NOT NULL COMMENT '用户名',
	create_date DATE COMMENT '创建时间', -- 创建时间
	update_date DATE COMMENT '更新时间', -- 更新时间, 最近修改时间
	title varchar(255) COMMENT '标题',
	context TEXT COMMENT '记录内容' -- 内容
)COMMENT='表注释';
-- 插入测试数据
INSERT INTO `tb_notepad` VALUES(NULL,'zhangsan','2020-02-26','2020-02-26','世界','我的世界') ;
INSERT INTO `tb_notepad` VALUES(NULL,'zhangsan','2020-02-26','2020-02-26','你猜','猜这是什么') ;
INSERT INTO `tb_notepad` VALUES(NULL,'zhangsan','2020-02-27','2020-02-28','me','我的世界') ;
INSERT INTO `tb_notepad` VALUES(NULL,'zhangsan','2020-02-27','2020-02-28','python','我是python') ;
INSERT INTO `tb_notepad` VALUES(NULL,'lisi','2020-02-26','2020-02-26','java','我是java') ;
INSERT INTO `tb_notepad` VALUES(NULL,'lisi','2020-02-26','2020-02-27','世界','我的java世界') ;
INSERT INTO `tb_notepad` VALUES(NULL,'lisi','2020-02-26','2020-02-27','hello','你好') ;
INSERT INTO `tb_notepad` VALUES(NULL,'lisi','2020-02-27','2020-02-28','me','我的世界') ;



-- 3. oauth登入认证数据库与表
USE mininote_oauth;
CREATE TABLE `oauth_client_details` (
  `client_id` VARCHAR(48) NOT NULL COMMENT '客户端ID，主要用于标识对应的应用',
  `resource_ids` VARCHAR(256) DEFAULT NULL,
  `client_secret` VARCHAR(256) DEFAULT NULL COMMENT '客户端秘钥，BCryptPasswordEncoder加密算法加密',
  `scope` VARCHAR(256) DEFAULT NULL COMMENT '对应的范围',
  `authorized_grant_types` VARCHAR(256) DEFAULT NULL COMMENT '认证模式',
  `web_server_redirect_uri` VARCHAR(256) DEFAULT NULL COMMENT '认证后重定向地址',
  `authorities` VARCHAR(256) DEFAULT NULL,
  `access_token_validity` INT(11) DEFAULT NULL COMMENT '令牌有效期',
  `refresh_token_validity` INT(11) DEFAULT NULL COMMENT '令牌刷新周期',
  `additional_information` VARCHAR(4096) DEFAULT NULL,
  `autoapprove` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- oauth认证表 插入数据
INSERT INTO `oauth_client_details` VALUES 
('mininote', NULL, '$2a$10$lvXk0gXa1jXUKxssS/p81uXsP6eoyeCPbzlXdQgi8heS/2EhTetMe', 'app', 'authorization_code,password,refresh_token,client_credentials', 'http://localhost', NULL, '432000000', '432000000', NULL, NULL);

SELECT id,username,create_date,update_date,title,context FROM tb_notepad WHERE ( username = 'lisi' AND context LIKE '%java%' OR title LIKE '%java%' )

