/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : helper

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2015-07-25 10:11:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_appointment`
-- ----------------------------
DROP TABLE IF EXISTS `t_appointment`;
CREATE TABLE `t_appointment` (
  `id` int(10) NOT NULL auto_increment,
  `start_time` date NOT NULL,
  `end_time` date default NULL,
  `is_cacel` char(1) NOT NULL default 'N',
  `is_break` char(1) NOT NULL default 'N',
  `user_id` int(10) NOT NULL,
  `other_user_id` int(10) default NULL,
  `pay_key` char(10) default NULL,
  `time` date NOT NULL,
  `gender` int(4) NOT NULL default '1',
  `substance` varchar(50) NOT NULL,
  `description` varchar(500) default NULL,
  `meal_id` int(10) NOT NULL,
  `examine` char(1) NOT NULL default 'N',
  `response` char(1) NOT NULL default 'N',
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  KEY `other_user_id` (`other_user_id`),
  KEY `meal_id` (`meal_id`),
  CONSTRAINT `t_appointment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_appointment_ibfk_2` FOREIGN KEY (`other_user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_appointment_ibfk_3` FOREIGN KEY (`meal_id`) REFERENCES `t_meal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_appointment
-- ----------------------------
INSERT INTO t_appointment VALUES ('10', '2015-07-23', null, 'N', 'N', '1', '3', '15582', '2015-04-01', '1', '看电影,', null, '1', 'Y', 'Y');
INSERT INTO t_appointment VALUES ('11', '2015-07-23', null, 'N', 'N', '1', '3', '61331', '2015-07-08', '3', '看电影,唱歌,', '欢迎', '2', 'Y', 'Y');
INSERT INTO t_appointment VALUES ('12', '2015-07-23', null, 'N', 'N', '1', '3', '68401', '2015-07-08', '2', '吃饭,看电影,', '123456', '1', 'Y', 'Y');
INSERT INTO t_appointment VALUES ('13', '2015-07-25', null, 'N', 'N', '4', '1', '75886', '2015-04-01', '1', '吃饭,', '123', '1', 'Y', 'Y');
INSERT INTO t_appointment VALUES ('14', '2015-07-25', null, 'N', 'N', '2', null, null, '2014-04-04', '1', '吃饭,', '122', '1', 'N', 'N');
INSERT INTO t_appointment VALUES ('15', '2015-07-25', null, 'N', 'N', '2', null, null, '2514-07-08', '2', '看电影,', '', '1', 'N', 'N');
INSERT INTO t_appointment VALUES ('16', '2015-07-25', null, 'N', 'N', '2', null, null, '2015-04-04', '2', '吃饭,', '', '1', 'N', 'N');

-- ----------------------------
-- Table structure for `t_meal`
-- ----------------------------
DROP TABLE IF EXISTS `t_meal`;
CREATE TABLE `t_meal` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `num` int(10) default NULL,
  `priferemential` varchar(100) default NULL,
  `price` double(12,2) default NULL,
  `store_id` int(10) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `t_meal_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `t_store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_meal
-- ----------------------------
INSERT INTO t_meal VALUES ('1', '南娱半价', '2015-07-01', '2015-09-01', '100', '全场半价', '54.10', '1');
INSERT INTO t_meal VALUES ('2', '联峰山免费', '2015-07-16', '2015-07-20', '51', '免费', '0.00', '2');

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(10) NOT NULL auto_increment,
  `user` int(10) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `appointment_id` int(10) default NULL,
  `other_user` int(10) default NULL,
  PRIMARY KEY  (`id`),
  KEY `appointment_id` (`appointment_id`),
  KEY `t_message_ibfk_1` (`user`),
  KEY `t_message_ibfk_3_idx` (`other_user`),
  CONSTRAINT `t_message_ibfk_3` FOREIGN KEY (`other_user`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `t_message_ibfk_1` FOREIGN KEY (`user`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_message_ibfk_2` FOREIGN KEY (`appointment_id`) REFERENCES `t_appointment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO t_message VALUES ('16', '1', '您的编号为  10 的约会，管理员已审核通过。消费码为： 6 。凭此码享受服务。', '10', '2');
INSERT INTO t_message VALUES ('17', '3', '您的编号为  10 的约会，管理员已审核通过。消费码为： 6 。凭此码享受服务。', '10', '2');
INSERT INTO t_message VALUES ('19', '3', '您的申请约会编号为  3 的约会对方已同意，正在等待管理员审核。', '12', '1');
INSERT INTO t_message VALUES ('21', '3', '您的编号为  12 的约会，管理员已审核通过。消费码为： 1 。凭此码享受服务。', '12', '2');
INSERT INTO t_message VALUES ('22', '4', '张三回应了您的约会编号为  13 的约会请求', '13', '1');
INSERT INTO t_message VALUES ('23', '1', '您的申请约会编号为  1 的约会对方已同意，正在等待管理员审核。', '13', '4');
INSERT INTO t_message VALUES ('24', '4', '您的编号为  13 的约会，管理员已审核通过。消费码为： 7 。凭此码享受服务。', '13', '2');
INSERT INTO t_message VALUES ('25', '1', '您的编号为  13 的约会，管理员已审核通过。消费码为： 7 。凭此码享受服务。', '13', '2');
INSERT INTO t_message VALUES ('26', '1', '您的编号为  11 的约会，管理员已审核通过。消费码为： 61331 。凭此码享受服务。', '11', '2');
INSERT INTO t_message VALUES ('27', '3', '您的编号为  11 的约会，管理员已审核通过。消费码为： 61331 。凭此码享受服务。', '11', '2');

-- ----------------------------
-- Table structure for `t_responser`
-- ----------------------------
DROP TABLE IF EXISTS `t_responser`;
CREATE TABLE `t_responser` (
  `id` int(10) NOT NULL auto_increment,
  `appointment_id` int(10) NOT NULL,
  `response_user_id` int(10) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `appointment_id` (`appointment_id`),
  KEY `response_user_id` (`response_user_id`),
  CONSTRAINT `t_responser_ibfk_1` FOREIGN KEY (`appointment_id`) REFERENCES `t_appointment` (`id`),
  CONSTRAINT `t_responser_ibfk_2` FOREIGN KEY (`response_user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of t_responser
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `permision` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO t_role VALUES ('1', '超级管理员', '1');
INSERT INTO t_role VALUES ('2', '管理员', '2');
INSERT INTO t_role VALUES ('3', '商家', '3');
INSERT INTO t_role VALUES ('4', '用户', '4');

-- ----------------------------
-- Table structure for `t_store`
-- ----------------------------
DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `type` varchar(20) NOT NULL,
  `picture` varchar(100) default NULL,
  `introduce` varchar(1000) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_store
-- ----------------------------
INSERT INTO t_store VALUES ('1', '南娱', '南戴河娱乐中心', '213123123', '游乐场', '', '南戴河娱乐中心');
INSERT INTO t_store VALUES ('2', '联峰山', '联峰山', '123654', '景点', '', '联峰山景点');
INSERT INTO t_store VALUES ('4', '商家1', '地址1', '123', '商家', '', '123');
INSERT INTO t_store VALUES ('5', '商家2', '地址2', '456', '商家', '', '');
INSERT INTO t_store VALUES ('6', '商家3', '地址3', '123', '商家', '', '');
INSERT INTO t_store VALUES ('7', '商家4', '地址4', '123', '商家', '', '');
INSERT INTO t_store VALUES ('8', '商家', '商家', '123', '商家', '', '');
INSERT INTO t_store VALUES ('9', '商家', '商家', '123', '商家', '', '');
INSERT INTO t_store VALUES ('10', '商家', '商家', '123', '商家', '', '');
INSERT INTO t_store VALUES ('11', '商家', '商家', '123', '商家', '', '');
INSERT INTO t_store VALUES ('12', '商家', '商家', '123', '商家', '', '');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) default NULL,
  `sex` char(1) default NULL,
  `age` int(3) default NULL,
  `tel` varchar(10) default NULL,
  `QQ` varchar(20) default NULL,
  `email` varchar(40) NOT NULL,
  `role` int(10) NOT NULL default '4',
  `location` varchar(50) default NULL,
  `description` varchar(500) default NULL,
  `picture` varchar(500) default 'img/img.jpg',
  PRIMARY KEY  (`id`),
  KEY `role` (`role`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES ('1', 'zhangsan', 'zhangsan', '张三', 'M', '20', '123456', '123456', 'zhangsan@123.com', '4', '秦皇岛', '我是张三', 'img/img.jpg');
INSERT INTO t_user VALUES ('2', 'admin', 'admin', 'admin', 'M', '21', '5235234123', '43534634534', 'admin@123.com', '1', '秦皇岛', 'aaa', 'img/img.jpg');
INSERT INTO t_user VALUES ('3', 'lisi', 'lisi', '李四', 'F', '22', '123456', '123456', 'lisi@123.com', '4', null, null, 'img/img.jpg');
INSERT INTO t_user VALUES ('4', null, '123', 'song', 'M', '0', null, null, 'song@123.com', '4', 'null', 'song', 'img/img.jpg');
