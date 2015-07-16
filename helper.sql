/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : helper

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2015-07-16 17:43:24
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
INSERT INTO t_appointment VALUES ('1', '2015-07-08', '2015-07-14', 'N', 'N', '1', '3', '123', '2015-07-14', '1', '', null, '1');

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
INSERT INTO t_role VALUES ('4', '用户', '5');

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
  `pricture` varchar(100) default NULL,
  `introduce` varchar(1000) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_store
-- ----------------------------
INSERT INTO t_store VALUES ('1', '南娱', '南戴河', '321654', '游乐场', '', '南戴河娱乐中心');
INSERT INTO t_store VALUES ('2', '联峰山', '联峰山', '123654', '景点', '', '联峰山景点');

-- ----------------------------
-- Table structure for `t_store_collect`
-- ----------------------------
DROP TABLE IF EXISTS `t_store_collect`;
CREATE TABLE `t_store_collect` (
  `store_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY  (`store_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_store_collect_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `t_store` (`id`),
  CONSTRAINT `t_store_collect_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_store_collect
-- ----------------------------
INSERT INTO t_store_collect VALUES ('1', '3');

-- ----------------------------
-- Table structure for `t_tag`
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `tag_id` int(10) NOT NULL,
  `ower_id` int(10) NOT NULL,
  `type` int(4) NOT NULL,
  PRIMARY KEY  (`tag_id`,`ower_id`,`type`),
  CONSTRAINT `t_tag_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `t_tag_message` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_tag
-- ----------------------------

-- ----------------------------
-- Table structure for `t_tag_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_tag_message`;
CREATE TABLE `t_tag_message` (
  `id` int(10) NOT NULL,
  `message` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_tag_message
-- ----------------------------

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
  PRIMARY KEY  (`id`),
  KEY `role` (`role`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES ('1', 'zhangsan', 'zhangsan', '张三', 'M', '20', '123456', '123456', 'zhangsan@123.com', '4', '秦皇岛', '我是张三，你好。');
INSERT INTO t_user VALUES ('2', 'admin', 'admin', 'admin', 'M', '21', '123456', '123456', 'admin@123.com', '1', null, null);
INSERT INTO t_user VALUES ('3', 'lisi', 'lisi', '李四', 'F', '22', '123456', '123456', 'lisi@123.com', '4', null, null);

-- ----------------------------
-- Table structure for `t_user_friend`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_friend`;
CREATE TABLE `t_user_friend` (
  `id` int(10) NOT NULL auto_increment,
  `user_id` int(10) NOT NULL,
  `other_user_id` int(10) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  KEY `other_user_id` (`other_user_id`),
  CONSTRAINT `t_user_friend_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_user_friend_ibfk_2` FOREIGN KEY (`other_user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_user_friend
-- ----------------------------
INSERT INTO t_user_friend VALUES ('1', '1', '3');
