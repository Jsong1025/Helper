-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: helper
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_appointment`
--

DROP TABLE IF EXISTS `t_appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `response` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `other_user_id` (`other_user_id`),
  KEY `meal_id` (`meal_id`),
  CONSTRAINT `t_appointment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_appointment_ibfk_2` FOREIGN KEY (`other_user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_appointment_ibfk_3` FOREIGN KEY (`meal_id`) REFERENCES `t_meal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_appointment`
--

LOCK TABLES `t_appointment` WRITE;
/*!40000 ALTER TABLE `t_appointment` DISABLE KEYS */;
INSERT INTO `t_appointment` VALUES (1,'2015-07-08','2015-07-14','N','N',1,3,'123','2015-07-14',1,'吃饭，运动',NULL,1,'Y','N'),(2,'2015-07-16','2015-07-29','N','N',2,1,'3','2015-07-17',2,'看电影',NULL,2,'Y','N'),(5,'2015-07-17',NULL,'N','N',1,NULL,NULL,'2015-04-01',1,'吃饭,看电影,','',1,'N','N'),(6,'2015-07-17',NULL,'N','N',1,NULL,NULL,'2015-05-01',1,'吃饭,','ihd ',1,'N','N'),(7,'2015-04-01',NULL,'N','N',2,NULL,NULL,'2015-04-05',1,'吃饭,',NULL,1,'N','N'),(8,'2015-07-20',NULL,'N','N',1,NULL,NULL,'2015-05-01',1,'吃饭,看电影,','你好',1,'N','N'),(9,'2015-07-22',NULL,'N','N',2,NULL,NULL,'2015-07-23',1,'吃饭,','da',1,'N','N');
/*!40000 ALTER TABLE `t_appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_meal`
--

DROP TABLE IF EXISTS `t_meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_meal`
--

LOCK TABLES `t_meal` WRITE;
/*!40000 ALTER TABLE `t_meal` DISABLE KEYS */;
INSERT INTO `t_meal` VALUES (1,'南娱半价','2015-07-01','2015-09-01',100,'全场半价',54.10,1),(2,'联峰山免费','2015-07-16','2015-07-20',51,'免费',0.00,2);
/*!40000 ALTER TABLE `t_meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_message`
--

DROP TABLE IF EXISTS `t_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_message` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user` int(10) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `appointment_id` int(10) DEFAULT NULL,
  `other_user` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `appointment_id` (`appointment_id`),
  KEY `t_message_ibfk_1` (`user`),
  KEY `t_message_ibfk_3_idx` (`other_user`),
  CONSTRAINT `t_message_ibfk_3` FOREIGN KEY (`other_user`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `t_message_ibfk_1` FOREIGN KEY (`user`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_message_ibfk_2` FOREIGN KEY (`appointment_id`) REFERENCES `t_appointment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_message`
--

LOCK TABLES `t_message` WRITE;
/*!40000 ALTER TABLE `t_message` DISABLE KEYS */;
INSERT INTO `t_message` VALUES (2,1,'123',1,NULL),(6,1,'李四回应了您的约会请求',1,3);
/*!40000 ALTER TABLE `t_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_responser`
--

DROP TABLE IF EXISTS `t_responser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_responser` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `appointment_id` int(10) NOT NULL,
  `response_user_id` int(10) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `appointment_id` (`appointment_id`),
  KEY `response_user_id` (`response_user_id`),
  CONSTRAINT `t_responser_ibfk_1` FOREIGN KEY (`appointment_id`) REFERENCES `t_appointment` (`id`),
  CONSTRAINT `t_responser_ibfk_2` FOREIGN KEY (`response_user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_responser`
--

LOCK TABLES `t_responser` WRITE;
/*!40000 ALTER TABLE `t_responser` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_responser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `permision` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'超级管理员',1),(2,'管理员',2),(3,'商家',3),(4,'用户',4);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_store`
--

DROP TABLE IF EXISTS `t_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_store` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `type` varchar(20) NOT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `introduce` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_store`
--

LOCK TABLES `t_store` WRITE;
/*!40000 ALTER TABLE `t_store` DISABLE KEYS */;
INSERT INTO `t_store` VALUES (1,'南娱','南戴河娱乐中心','213123123','游乐场','','南戴河娱乐中心'),(2,'联峰山','联峰山','123654','景点','','联峰山景点');
/*!40000 ALTER TABLE `t_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tag`
--

DROP TABLE IF EXISTS `t_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_tag` (
  `tag_id` int(10) NOT NULL,
  `ower_id` int(10) NOT NULL,
  `type` int(4) NOT NULL,
  PRIMARY KEY (`tag_id`,`ower_id`,`type`),
  CONSTRAINT `t_tag_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `t_tag_message` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tag`
--

LOCK TABLES `t_tag` WRITE;
/*!40000 ALTER TABLE `t_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tag_message`
--

DROP TABLE IF EXISTS `t_tag_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_tag_message` (
  `id` int(10) NOT NULL,
  `message` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tag_message`
--

LOCK TABLES `t_tag_message` WRITE;
/*!40000 ALTER TABLE `t_tag_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_tag_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `picture` varchar(500) DEFAULT 'img/img.jpg',
  PRIMARY KEY (`id`),
  KEY `role` (`role`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'zhangsan','zhangsan','张三','M',20,'123456','123456','zhangsan@123.com',4,'秦皇岛','我是张三','img/img.jpg'),(2,'admin','admin','admin','M',21,'5235234123','43534634534','admin@123.com',1,'null','aaa','img/img.jpg'),(3,'lisi','lisi','李四','F',22,'123456','123456','lisi@123.com',4,NULL,NULL,'img/img.jpg');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_friend`
--

DROP TABLE IF EXISTS `t_user_friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_friend`
--

LOCK TABLES `t_user_friend` WRITE;
/*!40000 ALTER TABLE `t_user_friend` DISABLE KEYS */;
INSERT INTO `t_user_friend` VALUES (1,1,3);
/*!40000 ALTER TABLE `t_user_friend` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-22 16:45:33
