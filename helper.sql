/*
SQLyog Ultimate v8.32 
MySQL - 5.6.11 : Database - helper
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`helper` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `helper`;

/*Table structure for table `t_appointment` */

DROP TABLE IF EXISTS `t_appointment`;

CREATE TABLE `t_appointment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `start_time` date NOT NULL,
  `end_time` date DEFAULT NULL,
  `is_cacel` char(1) NOT NULL DEFAULT 'N',
  `is_break` char(1) NOT NULL DEFAULT 'N',
  `user_id` int(10) NOT NULL,
  `other_user_id` int(10) DEFAULT NULL,
  `pay_key` char(10) DEFAULT NULL,
  `time` date NOT NULL,
  `gender` int(4) NOT NULL DEFAULT '1',
  `substance` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `meal_id` int(10) NOT NULL,
  `examine` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `other_user_id` (`other_user_id`),
  KEY `meal_id` (`meal_id`),
  CONSTRAINT `t_appointment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_appointment_ibfk_2` FOREIGN KEY (`other_user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_appointment_ibfk_3` FOREIGN KEY (`meal_id`) REFERENCES `t_meal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

/*Data for the table `t_appointment` */

insert  into `t_appointment`(`id`,`start_time`,`end_time`,`is_cacel`,`is_break`,`user_id`,`other_user_id`,`pay_key`,`time`,`gender`,`substance`,`description`,`meal_id`,`examine`) values (1,'2015-07-08','2015-07-14','N','N',1,3,'123','2015-07-14',1,'吃饭，运动',NULL,1,'N'),(2,'2015-07-16','2015-07-29','N','N',2,1,'789','2015-07-17',2,'看电影',NULL,2,'N'),(5,'2015-07-17',NULL,'N','N',1,NULL,NULL,'2015-04-01',1,'吃饭,看电影,','',1,'N'),(6,'2015-07-17',NULL,'N','N',1,NULL,NULL,'2015-05-01',1,'吃饭,','ihd ',1,'N');

/*Table structure for table `t_meal` */

DROP TABLE IF EXISTS `t_meal`;

CREATE TABLE `t_meal` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `num` int(10) DEFAULT NULL,
  `priferemential` varchar(100) DEFAULT NULL,
  `price` double(12,2) DEFAULT NULL,
  `store_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `t_meal_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `t_store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

/*Data for the table `t_meal` */

insert  into `t_meal`(`id`,`name`,`start_time`,`end_time`,`num`,`priferemential`,`price`,`store_id`) values (1,'南娱半价','2015-07-01','2015-09-01',100,'全场半价',54.10,1),(2,'联峰山免费','2015-07-16','2015-07-20',51,'免费',0.00,2);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `permision` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`name`,`permision`) values (1,'超级管理员',1),(2,'管理员',2),(3,'商家',3),(4,'用户',4);

/*Table structure for table `t_store` */

DROP TABLE IF EXISTS `t_store`;

CREATE TABLE `t_store` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `type` varchar(20) NOT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `introduce` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

/*Data for the table `t_store` */

insert  into `t_store`(`id`,`name`,`address`,`tel`,`type`,`picture`,`introduce`) values (1,'南娱','南戴河','321654','游乐场','','南戴河娱乐中心'),(2,'联峰山','联峰山','123654','景点','','联峰山景点');

/*Table structure for table `t_store_collect` */

DROP TABLE IF EXISTS `t_store_collect`;

CREATE TABLE `t_store_collect` (
  `store_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`store_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_store_collect_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `t_store` (`id`),
  CONSTRAINT `t_store_collect_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `t_store_collect` */

insert  into `t_store_collect`(`store_id`,`user_id`) values (1,3);

/*Table structure for table `t_tag` */

DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag` (
  `tag_id` int(10) NOT NULL,
  `ower_id` int(10) NOT NULL,
  `type` int(4) NOT NULL,
  PRIMARY KEY (`tag_id`,`ower_id`,`type`),
  CONSTRAINT `t_tag_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `t_tag_message` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `t_tag` */

/*Table structure for table `t_tag_message` */

DROP TABLE IF EXISTS `t_tag_message`;

CREATE TABLE `t_tag_message` (
  `id` int(10) NOT NULL,
  `message` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `t_tag_message` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `tel` varchar(10) DEFAULT NULL,
  `QQ` varchar(20) DEFAULT NULL,
  `email` varchar(40) NOT NULL,
  `role` int(10) NOT NULL DEFAULT '4',
  `location` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role` (`role`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`name`,`sex`,`age`,`tel`,`QQ`,`email`,`role`,`location`,`description`) values (1,'zhangsan','zhangsan','张三','M',20,'123456','123456','zhangsan@123.com',4,'秦皇岛','我是张三，你好。'),(2,'admin','admin','admin','M',21,'123456','123456','admin@123.com',1,'null','null'),(3,'lisi','lisi','李四','F',22,'123456','123456','lisi@123.com',4,NULL,NULL);

/*Table structure for table `t_user_friend` */

DROP TABLE IF EXISTS `t_user_friend`;

CREATE TABLE `t_user_friend` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `other_user_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `other_user_id` (`other_user_id`),
  CONSTRAINT `t_user_friend_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_user_friend_ibfk_2` FOREIGN KEY (`other_user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

/*Data for the table `t_user_friend` */

insert  into `t_user_friend`(`id`,`user_id`,`other_user_id`) values (1,1,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
