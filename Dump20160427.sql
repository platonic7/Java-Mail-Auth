CREATE DATABASE  IF NOT EXISTS `loginEmail` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `loginEmail`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: loginEmail
-- ------------------------------------------------------
-- Server version	5.7.9

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
-- Table structure for table `fakeUser`
--

DROP TABLE IF EXISTS `fakeUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fakeUser` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `lastname` varchar(20) DEFAULT NULL,
  `firstname` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `role` varchar(10) DEFAULT 'ROLE_READY',
  `createtime` datetime DEFAULT NULL,
  `authentication` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fakeUser`
--

LOCK TABLES `fakeUser` WRITE;
/*!40000 ALTER TABLE `fakeUser` DISABLE KEYS */;
INSERT INTO `fakeUser` VALUES (2,'LEE','JINSEO','jinseo8406@naver.com','1234','JIN','ROLE_READY','2016-04-27 10:16:53','8205e5dc');
/*!40000 ALTER TABLE `fakeUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `lastname` varchar(50) DEFAULT NULL COMMENT 'ユーザー名字',
  `firstname` varchar(50) DEFAULT NULL COMMENT 'ユーザー名前',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT 'ユーザーメール',
  `nickname` varchar(50) DEFAULT NULL COMMENT 'ユーザーニックネーム',
  `password` varchar(255) DEFAULT NULL COMMENT 'ユーザーパスワード',
  `createtime` datetime DEFAULT NULL COMMENT '登録時間',
  `updatedtime` datetime DEFAULT NULL COMMENT '修正時間',
  `role` varchar(10) DEFAULT 'ROLE_READY' COMMENT 'ユーザ権限 [‘ROLE_USER, ROLE_READY, ROLE_ADMIN''デフォルトは’ROLE_READY'']',
  `imagepath` varchar(255) DEFAULT NULL COMMENT 'イメージファイルのアドレス',
  `authentication` varchar(255) DEFAULT NULL COMMENT '認証トークン',
  `idCheck` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('LEE','JINSEO','jinseo8406@naver.com','JIN','1234','2016-04-27 10:50:56',NULL,'ROLE_USER',NULL,'8205e5dc',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-27 11:34:57
