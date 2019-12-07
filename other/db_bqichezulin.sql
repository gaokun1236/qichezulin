/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.28-log : Database - db_bqichezulin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_bqichezulin` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_bqichezulin`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) DEFAULT NULL,
  `adminPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`adminId`,`adminName`,`adminPassword`) values (1,'admin','admin'),(2,'gg','gg');

/*Table structure for table `t_ggtype` */

DROP TABLE IF EXISTS `t_ggtype`;

CREATE TABLE `t_ggtype` (
  `ggtypeId` int(11) NOT NULL AUTO_INCREMENT,
  `ggtypeName` varchar(255) DEFAULT NULL,
  `ggtypeMark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ggtypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_ggtype` */

insert  into `t_ggtype`(`ggtypeId`,`ggtypeName`,`ggtypeMark`) values (1,'优惠政策','优惠政策'),(2,'最新车辆','最新车辆');

/*Table structure for table `t_gonggao` */

DROP TABLE IF EXISTS `t_gonggao`;

CREATE TABLE `t_gonggao` (
  `gonggaoId` int(11) NOT NULL AUTO_INCREMENT,
  `gonggaoName` varchar(255) DEFAULT NULL,
  `gonggaoMark` varchar(255) DEFAULT NULL,
  `gonggaoImg` varchar(255) DEFAULT NULL,
  `gonggaoImgName` varchar(255) DEFAULT NULL,
  `gonggaoDate` varchar(27) DEFAULT NULL,
  `ggtypeId` int(11) DEFAULT NULL,
  `ggtypeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gonggaoId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_gonggao` */

insert  into `t_gonggao`(`gonggaoId`,`gonggaoName`,`gonggaoMark`,`gonggaoImg`,`gonggaoImgName`,`gonggaoDate`,`ggtypeId`,`ggtypeName`) values (1,'优惠政策','<div style=\"text-align:center;\">\r\n	<span style=\"font-size:medium;\">即日起租车全部车系优惠，最高达100</span>\r\n</div>',NULL,NULL,'2019-02-19 21:48:57',1,'优惠政策'),(2,'最新车辆','<div style=\"text-align:center;\">\r\n	<span style=\"font-size:medium;\">最新2019款奔驰c260L已上架，欢迎租车</span>\r\n</div>',NULL,NULL,'2019-02-19 21:49:10',2,'最新车辆');

/*Table structure for table `t_rizhi` */

DROP TABLE IF EXISTS `t_rizhi`;

CREATE TABLE `t_rizhi` (
  `rizhiId` int(11) NOT NULL AUTO_INCREMENT,
  `rizhiName` varchar(255) DEFAULT NULL,
  `dengluIp` varchar(255) DEFAULT NULL,
  `date` varchar(27) DEFAULT NULL,
  PRIMARY KEY (`rizhiId`)
) ENGINE=InnoDB AUTO_INCREMENT=239 DEFAULT CHARSET=utf8;

/*Data for the table `t_rizhi` */

insert  into `t_rizhi`(`rizhiId`,`rizhiName`,`dengluIp`,`date`) values (1,'admin','127.0.0.1','2019-02-19 21:48:02'),(2,'user1','127.0.0.1','2019-02-19 21:49:33'),(3,'yonghu1','127.0.0.1','2019-02-19 22:01:07'),(4,'admin','127.0.0.1','2019-02-19 22:04:43'),(5,'user1','127.0.0.1','2019-02-19 22:04:57'),(6,'yonghu2','127.0.0.1','2019-02-19 22:05:52'),(7,'user1','127.0.0.1','2019-02-19 22:06:22'),(8,'yonghu2','127.0.0.1','2019-02-19 22:06:40'),(9,'admin','0:0:0:0:0:0:0:1','2019-03-10 22:18:16'),(10,'user1','0:0:0:0:0:0:0:1','2019-03-10 22:18:47'),(11,'admin','127.0.0.1','2019-03-10 22:43:47'),(12,'user1','0:0:0:0:0:0:0:1','2019-03-10 22:53:03'),(13,'admin','127.0.0.1','2019-03-16 19:02:53'),(14,'zhangsan','127.0.0.1','2019-03-16 19:06:45'),(15,'zhangsan','127.0.0.1','2019-03-16 19:48:23'),(16,'user1','127.0.0.1','2019-03-16 19:49:30'),(17,'user1','127.0.0.1','2019-03-16 19:55:09'),(18,'zhangsan','127.0.0.1','2019-03-16 20:10:18'),(19,'user1','127.0.0.1','2019-03-16 20:29:45'),(20,'user1','127.0.0.1','2019-03-16 20:30:55'),(21,'user1','127.0.0.1','2019-03-17 11:52:47'),(22,'admin','127.0.0.1','2019-03-17 11:54:30'),(23,'zhangsan','127.0.0.1','2019-03-17 11:55:05'),(24,'user1','127.0.0.1','2019-03-17 11:58:55'),(25,'user1','127.0.0.1','2019-03-17 11:59:11'),(26,'admin','127.0.0.1','2019-03-17 11:59:35'),(27,'user1','127.0.0.1','2019-03-17 12:00:18'),(28,'zhangsan','127.0.0.1','2019-03-17 12:03:04'),(29,'user1','127.0.0.1','2019-03-17 12:25:13'),(30,'zhangsan','127.0.0.1','2019-03-17 12:40:07'),(31,'user1','127.0.0.1','2019-03-17 12:41:06'),(32,'zhangsan','127.0.0.1','2019-03-17 12:44:58'),(33,'user1','127.0.0.1','2019-03-17 12:47:22'),(34,'zhangsan','127.0.0.1','2019-03-17 13:01:39'),(35,'user1','127.0.0.1','2019-03-17 13:17:18'),(36,'admin','127.0.0.1','2019-03-17 13:18:05'),(37,'user1','127.0.0.1','2019-03-17 13:22:49'),(38,'zhangsan','127.0.0.1','2019-03-17 13:23:11'),(39,'admin','127.0.0.1','2019-03-17 13:26:32'),(40,'zhangsan','127.0.0.1','2019-03-17 13:30:28'),(41,'zhangsan','127.0.0.1','2019-03-17 14:09:29'),(42,'zhangsan','127.0.0.1','2019-03-17 14:12:40'),(43,'admin','127.0.0.1','2019-03-17 14:29:39'),(44,'user1','127.0.0.1','2019-03-17 14:31:04'),(45,'user1','0:0:0:0:0:0:0:1','2019-03-17 14:36:17'),(46,'user1','127.0.0.1','2019-03-17 14:38:50'),(47,'zhangsan','127.0.0.1','2019-03-17 15:06:27'),(48,'user1','127.0.0.1','2019-03-17 15:27:11'),(49,'zhangsan','127.0.0.1','2019-03-17 16:31:30'),(50,'zhangsan','127.0.0.1','2019-03-17 16:45:01'),(51,'zhangsan','127.0.0.1','2019-03-17 20:56:08'),(52,'zhangsan','127.0.0.1','2019-03-18 21:30:38'),(53,'user1','127.0.0.1','2019-03-18 21:37:37'),(54,'zhangsan','127.0.0.1','2019-03-18 21:54:11'),(55,'user1','127.0.0.1','2019-03-18 22:27:57'),(56,'admin','127.0.0.1','2019-03-18 22:35:44'),(57,'zhangsan','127.0.0.1','2019-03-18 22:43:51'),(58,'user1','127.0.0.1','2019-03-18 23:06:34'),(59,'user1','127.0.0.1','2019-03-19 00:24:40'),(60,'admin','127.0.0.1','2019-03-19 00:24:53'),(61,'zhangsan','127.0.0.1','2019-03-19 00:36:51'),(62,'zhangsan','127.0.0.1','2019-03-19 20:36:47'),(63,'user1','127.0.0.1','2019-03-19 20:38:57'),(64,'zhangsan','127.0.0.1','2019-03-19 20:41:03'),(65,'user1','127.0.0.1','2019-03-19 20:41:30'),(66,'zhangsan','127.0.0.1','2019-03-19 20:41:59'),(67,'user1','127.0.0.1','2019-03-19 20:42:43'),(68,'user1','127.0.0.1','2019-03-19 20:43:48'),(69,'user1','127.0.0.1','2019-03-19 20:45:35'),(70,'admin','127.0.0.1','2019-03-19 20:46:06'),(71,'admin','127.0.0.1','2019-03-19 20:55:26'),(72,'user1','127.0.0.1','2019-03-19 21:08:08'),(73,'zhangsan','127.0.0.1','2019-03-19 21:09:44'),(74,'user1','127.0.0.1','2019-03-19 21:12:11'),(75,'zhangsan','127.0.0.1','2019-03-19 21:34:20'),(76,'user1','127.0.0.1','2019-03-19 21:35:28'),(77,'zhangsan','127.0.0.1','2019-03-19 21:36:36'),(78,'zhangsan','127.0.0.1','2019-03-19 21:41:08'),(79,'user1','127.0.0.1','2019-03-19 21:41:34'),(80,'user1','127.0.0.1','2019-03-19 21:53:20'),(81,'zhangsan','127.0.0.1','2019-03-19 21:59:17'),(82,'user1','127.0.0.1','2019-03-19 22:00:10'),(83,'user1','127.0.0.1','2019-03-19 22:04:58'),(84,'zhangsan','127.0.0.1','2019-03-19 22:05:56'),(85,'user1','127.0.0.1','2019-03-19 23:04:11'),(86,'zhangsan','127.0.0.1','2019-03-19 23:04:45'),(87,'zhangsan','127.0.0.1','2019-03-19 23:09:08'),(88,'zhangsan','127.0.0.1','2019-03-19 23:10:53'),(89,'zhangsan','127.0.0.1','2019-03-19 23:13:36'),(90,'user1','127.0.0.1','2019-03-19 23:19:22'),(91,'zhangsan','127.0.0.1','2019-03-19 23:31:56'),(92,'zhangsan','127.0.0.1','2019-03-21 23:07:44'),(93,'zhangsan','127.0.0.1','2019-03-21 23:10:58'),(94,'zhangsan','127.0.0.1','2019-03-21 23:20:55'),(95,'zhangsan','127.0.0.1','2019-03-21 23:28:12'),(96,'admin','127.0.0.1','2019-03-21 23:44:52'),(97,'user1','127.0.0.1','2019-03-21 23:47:32'),(98,'zhangsan','127.0.0.1','2019-03-21 23:50:37'),(99,'zhangsan','127.0.0.1','2019-03-21 23:54:25'),(100,'admin','127.0.0.1','2019-03-21 23:54:44'),(101,'user1','127.0.0.1','2019-03-21 23:54:59'),(102,'zhangsan','127.0.0.1','2019-03-21 23:55:31'),(103,'zhangsan','127.0.0.1','2019-03-22 00:06:03'),(104,'zhangsan','127.0.0.1','2019-03-22 00:06:10'),(105,'zhangsan','127.0.0.1','2019-03-22 00:08:20'),(106,'user1','127.0.0.1','2019-03-22 00:10:53'),(107,'user1','127.0.0.1','2019-03-22 00:14:07'),(108,'zhangsan','127.0.0.1','2019-03-22 21:47:04'),(109,'zhangsan','127.0.0.1','2019-03-22 22:40:16'),(110,'user1','127.0.0.1','2019-03-23 00:02:19'),(111,'zhangsan','127.0.0.1','2019-03-23 00:08:39'),(112,'zhangsan','127.0.0.1','2019-03-23 01:30:17'),(113,'zhangsan','127.0.0.1','2019-03-23 01:37:16'),(114,'user1','127.0.0.1','2019-03-23 01:51:45'),(115,'zhangsan','127.0.0.1','2019-03-23 01:52:24'),(116,'zhangsan','127.0.0.1','2019-03-23 01:54:30'),(117,'zhangsan','127.0.0.1','2019-03-23 01:54:45'),(118,'user1','127.0.0.1','2019-03-23 02:12:37'),(119,'user1','127.0.0.1','2019-03-23 02:14:27'),(120,'user1','127.0.0.1','2019-03-23 02:15:12'),(121,'zhangsan','127.0.0.1','2019-03-23 02:19:19'),(122,'user1','127.0.0.1','2019-03-23 02:22:31'),(123,'zhangsan','127.0.0.1','2019-03-23 02:25:37'),(124,'user1','127.0.0.1','2019-03-23 03:02:03'),(125,'zhangsan','127.0.0.1','2019-03-23 03:02:15'),(126,'user1','127.0.0.1','2019-03-23 03:05:53'),(127,'zhangsan','127.0.0.1','2019-03-23 03:14:28'),(128,'user1','127.0.0.1','2019-03-23 03:18:46'),(129,'zhangsan','127.0.0.1','2019-03-23 03:26:51'),(130,'user1','127.0.0.1','2019-03-23 03:40:46'),(131,'zhangsan','127.0.0.1','2019-03-23 03:44:30'),(132,'user1','127.0.0.1','2019-03-23 03:44:51'),(133,'admin','127.0.0.1','2019-03-23 12:30:04'),(134,'user1','127.0.0.1','2019-03-23 12:58:50'),(135,'zhangsan','127.0.0.1','2019-03-23 15:11:57'),(136,'user1','127.0.0.1','2019-03-23 15:12:40'),(137,'admin','127.0.0.1','2019-03-23 15:13:24'),(138,'zhangsan','127.0.0.1','2019-03-23 17:26:39'),(139,'admin','127.0.0.1','2019-03-23 21:48:50'),(140,'zhangsan','127.0.0.1','2019-03-23 21:59:08'),(141,'user1','127.0.0.1','2019-03-23 22:29:33'),(142,'user1','127.0.0.1','2019-03-26 20:07:30'),(143,'user1','127.0.0.1','2019-03-26 20:07:56'),(144,'user1','127.0.0.1','2019-03-26 20:13:02'),(145,'lisilisi','127.0.0.1','2019-03-26 20:18:33'),(146,'user1','127.0.0.1','2019-03-26 20:18:57'),(147,'user1','127.0.0.1','2019-03-26 20:19:23'),(148,'admin','127.0.0.1','2019-03-26 20:20:07'),(149,'user2','127.0.0.1','2019-03-26 20:21:20'),(150,'user2','127.0.0.1','2019-03-26 20:21:41'),(151,'user2','127.0.0.1','2019-03-26 20:29:16'),(152,'user2','127.0.0.1','2019-03-26 20:58:58'),(153,'lisilisi','127.0.0.1','2019-03-26 21:16:21'),(154,'user1','127.0.0.1','2019-03-26 21:16:43'),(155,'user1','127.0.0.1','2019-03-26 21:51:31'),(156,'user1','127.0.0.1','2019-03-26 21:53:07'),(157,'admin','127.0.0.1','2019-03-26 21:54:21'),(158,'user1','127.0.0.1','2019-03-26 21:54:55'),(159,'user1','127.0.0.1','2019-03-26 21:58:16'),(160,'admin','127.0.0.1','2019-03-26 22:41:29'),(161,'admin','127.0.0.1','2019-03-26 22:42:41'),(162,'user1','127.0.0.1','2019-03-26 22:46:10'),(163,'user1','127.0.0.1','2019-03-26 23:13:25'),(164,'user1','127.0.0.1','2019-03-26 23:18:53'),(165,'user1','127.0.0.1','2019-03-26 23:22:00'),(166,'user1','127.0.0.1','2019-03-26 23:27:18'),(167,'user1','127.0.0.1','2019-03-26 23:32:57'),(168,'user1','127.0.0.1','2019-03-27 07:39:08'),(169,'user1','127.0.0.1','2019-03-27 07:52:16'),(170,'user1','127.0.0.1','2019-03-27 22:56:58'),(171,'zhangsan','127.0.0.1','2019-03-27 22:59:46'),(172,'zhangsan','127.0.0.1','2019-03-30 17:03:01'),(173,'user1','127.0.0.1','2019-03-30 17:08:50'),(174,'zhangsan','127.0.0.1','2019-04-21 17:20:59'),(175,'user1','127.0.0.1','2019-04-21 17:22:17'),(176,'admin','127.0.0.1','2019-04-21 17:22:36'),(177,'zhangsan','127.0.0.1','2019-04-25 10:32:41'),(178,'zhangsan','127.0.0.1','2019-04-25 10:54:54'),(179,'zhangsan','127.0.0.1','2019-04-25 18:03:31'),(180,'user1','127.0.0.1','2019-04-25 18:06:56'),(181,'user1','127.0.0.1','2019-04-25 18:08:34'),(182,'user1','127.0.0.1','2019-04-25 18:10:30'),(183,'admin','127.0.0.1','2019-04-25 18:11:11'),(184,'admin','127.0.0.1','2019-04-25 18:11:31'),(185,'user1','127.0.0.1','2019-04-25 18:11:44'),(186,'zhangsan','127.0.0.1','2019-04-25 18:12:14'),(187,'zhangsan','127.0.0.1','2019-04-26 10:49:09'),(188,'zhangsan','127.0.0.1','2019-04-26 12:04:54'),(189,'user1','127.0.0.1','2019-04-26 12:06:15'),(190,'admin','127.0.0.1','2019-04-26 12:07:48'),(191,'zhangsan','127.0.0.1','2019-04-26 12:08:29'),(192,'user1','127.0.0.1','2019-04-26 12:36:35'),(193,'zhangsan','127.0.0.1','2019-04-26 12:41:33'),(194,'zhangsan','127.0.0.1','2019-04-26 16:41:45'),(195,'user1','127.0.0.1','2019-04-26 16:42:21'),(196,'zhangsan','127.0.0.1','2019-04-26 16:42:45'),(197,'zhangsan','127.0.0.1','2019-04-26 17:18:17'),(198,'zhangsan','127.0.0.1','2019-04-26 17:31:40'),(199,'zhangsan','127.0.0.1','2019-04-26 21:37:10'),(200,'lisilisi','127.0.0.1','2019-04-26 21:39:02'),(201,'user1','127.0.0.1','2019-04-26 21:39:46'),(202,'zhangsan','127.0.0.1','2019-04-26 21:40:16'),(203,'lisilisi','127.0.0.1','2019-04-26 21:40:32'),(204,'zhangsan','127.0.0.1','2019-04-26 21:42:21'),(205,'user1','127.0.0.1','2019-04-26 21:46:25'),(206,'zhangsan','127.0.0.1','2019-04-26 21:47:19'),(207,'lisilisi','127.0.0.1','2019-04-26 22:10:00'),(208,'zhangsan','127.0.0.1','2019-04-26 22:10:57'),(209,'lisilisi','127.0.0.1','2019-04-26 22:12:17'),(210,'zhangsan','127.0.0.1','2019-04-26 22:12:38'),(211,'zhangsan','127.0.0.1','2019-04-27 08:04:18'),(212,'zhangsan','127.0.0.1','2019-04-27 08:51:50'),(213,'zhangsan','127.0.0.1','2019-04-27 08:51:56'),(214,'user1','127.0.0.1','2019-04-27 08:52:43'),(215,'admin','127.0.0.1','2019-04-27 08:53:12'),(216,'zhangsan','127.0.0.1','2019-04-27 08:55:27'),(217,'zhangsan','127.0.0.1','2019-04-27 09:41:10'),(218,'zhangsan','127.0.0.1','2019-04-27 09:41:18'),(219,'user1','127.0.0.1','2019-04-27 09:41:54'),(220,'zhangsan','127.0.0.1','2019-04-27 09:43:42'),(221,'zhangsan','127.0.0.1','2019-04-27 09:45:24'),(222,'zhangsan','127.0.0.1','2019-04-27 09:46:35'),(223,'zhangsan','127.0.0.1','2019-04-27 09:47:18'),(224,'zhangsan','127.0.0.1','2019-04-27 14:00:46'),(225,'zhangsan','127.0.0.1','2019-04-27 14:05:51'),(226,'zhangsan','127.0.0.1','2019-04-27 14:34:10'),(227,'zhangsan','127.0.0.1','2019-04-27 16:09:08'),(228,'user1','127.0.0.1','2019-04-27 16:10:21'),(229,'zhangsan','127.0.0.1','2019-04-27 16:10:56'),(230,'zhangsan','127.0.0.1','2019-04-27 16:14:45'),(231,'zhangsan','0:0:0:0:0:0:0:1','2019-05-16 17:07:34'),(232,'zhangsan','0:0:0:0:0:0:0:1','2019-07-19 14:50:42'),(233,'zhangsan','0:0:0:0:0:0:0:1','2019-10-29 17:19:25'),(234,'zhangsan','0:0:0:0:0:0:0:1','2019-11-05 16:43:45'),(235,'zhangsan','0:0:0:0:0:0:0:1','2019-11-25 22:17:10'),(236,'zhangsan','0:0:0:0:0:0:0:1','2019-12-07 12:03:44'),(237,'admin','0:0:0:0:0:0:0:1','2019-12-07 12:04:33'),(238,'user1','0:0:0:0:0:0:0:1','2019-12-07 12:05:14');

/*Table structure for table `t_shangpin` */

DROP TABLE IF EXISTS `t_shangpin`;

CREATE TABLE `t_shangpin` (
  `shangpinId` int(11) NOT NULL AUTO_INCREMENT,
  `shangpinName` varchar(255) NOT NULL,
  `shangpinMark` varchar(255) DEFAULT NULL,
  `shangpinMark1` varchar(255) DEFAULT NULL,
  `shangpinMark2` varchar(255) DEFAULT NULL,
  `shangpinMark3` varchar(255) DEFAULT NULL,
  `shangpinDate` varchar(27) DEFAULT NULL,
  `shangpinDate1` varchar(27) DEFAULT NULL,
  `shangpinZong` int(11) DEFAULT NULL,
  `shangpinJin` double DEFAULT NULL,
  `shangpinXiao` double DEFAULT NULL,
  `shangpinLirun` double DEFAULT NULL,
  `shangpinType` int(11) DEFAULT NULL,
  `shangpinType1` int(11) DEFAULT NULL,
  `shangpinImg` varchar(255) DEFAULT NULL,
  `shangpinImgName` varchar(255) DEFAULT NULL,
  `sptypeId` int(11) DEFAULT NULL,
  `sptypeName` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shangpinId`,`shangpinName`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `t_shangpin` */

insert  into `t_shangpin`(`shangpinId`,`shangpinName`,`shangpinMark`,`shangpinMark1`,`shangpinMark2`,`shangpinMark3`,`shangpinDate`,`shangpinDate1`,`shangpinZong`,`shangpinJin`,`shangpinXiao`,`shangpinLirun`,`shangpinType`,`shangpinType1`,`shangpinImg`,`shangpinImgName`,`sptypeId`,`sptypeName`,`userId`,`userName`,`bumenId`,`bumenName`,`roleId`,`roleName`) values (7,'宝马320i M','2019款宝马320i M','320i M',NULL,NULL,'2019-03-17 12:28:46',NULL,NULL,300,0,NULL,0,NULL,'/file/宝马 320i M.jpg','宝马 320i M.jpg',2,'宝马',NULL,NULL,NULL,NULL,NULL,NULL),(8,'宝马530Li','2019款宝马530Li','530Li',NULL,NULL,'2019-03-17 12:30:01',NULL,NULL,400,0,NULL,0,NULL,'/file/宝马 530Li.jpg','宝马 530Li.jpg',2,'宝马',NULL,NULL,NULL,NULL,NULL,NULL),(9,'宝马X3','2019款宝马X3','X3',NULL,NULL,'2019-03-17 12:30:54',NULL,NULL,400,0,NULL,0,NULL,'/file/宝马 X3.jpg','宝马 X3.jpg',2,'宝马',NULL,NULL,NULL,NULL,NULL,NULL),(10,'宝马X1','2019款宝马X1','X1',NULL,NULL,'2019-03-17 12:31:37',NULL,NULL,400,0,NULL,0,NULL,'/file/宝马X1.jpg','宝马X1.jpg',2,'宝马',NULL,NULL,NULL,NULL,NULL,NULL),(11,'奔驰c260','2019款奔驰c260','c260',NULL,NULL,'2019-03-17 12:32:40',NULL,NULL,350,0,NULL,0,NULL,'/file/奔驰 c260L.jpg','奔驰 c260L.jpg',1,'奔驰',NULL,NULL,NULL,NULL,NULL,NULL),(12,'奔驰E300L','2019款奔驰E300L','E300L',NULL,NULL,'2019-03-17 12:33:35',NULL,NULL,450,0,NULL,0,NULL,'/file/奔驰E300L.jpg','奔驰E300L.jpg',1,'奔驰',NULL,NULL,NULL,NULL,NULL,NULL),(13,'奔驰GLA','2019款奔驰GLA','GLA',NULL,NULL,'2019-03-17 12:34:12',NULL,NULL,400,0,NULL,0,NULL,'/file/奔驰 GLA 200.jpg','奔驰 GLA 200.jpg',1,'奔驰',NULL,NULL,NULL,NULL,NULL,NULL),(14,'奔驰GLC','2019款奔驰GLC','GLC',NULL,NULL,'2019-03-17 12:35:12',NULL,NULL,450,0,NULL,0,NULL,'/file/奔驰GLC 260.jpg','奔驰GLC 260.jpg',1,'奔驰',NULL,NULL,NULL,NULL,NULL,NULL),(15,'本田飞度','2019款本田飞度','飞度',NULL,NULL,'2019-03-17 12:36:23',NULL,NULL,200,0,NULL,0,NULL,'/file/本田 飞度.jpg','本田 飞度.jpg',4,'本田',NULL,NULL,NULL,NULL,NULL,NULL),(16,'本田思域','2019款本田思域','思域',NULL,NULL,'2019-03-17 12:37:10',NULL,NULL,300,0,NULL,0,NULL,'/file/本田 思域.jpg','本田 思域.jpg',4,'本田',NULL,NULL,NULL,NULL,NULL,NULL),(17,'本田CR-V','2019款本田CR-V','CR-V',NULL,NULL,'2019-03-17 12:38:56',NULL,NULL,300,0,NULL,0,NULL,'/file/本田CR-V.jpg','本田CR-V.jpg',4,'本田',NULL,NULL,NULL,NULL,NULL,NULL),(23,'本田冠道','2019款本田冠道','冠道',NULL,NULL,'2019-03-17 12:51:04',NULL,NULL,300,0,NULL,0,NULL,'/file/本田 冠道.jpg','本田 冠道.jpg',4,'本田',NULL,NULL,NULL,NULL,NULL,NULL),(24,'大众朗逸','2019款大众朗逸','朗逸',NULL,NULL,'2019-03-17 12:52:26',NULL,NULL,200,0,NULL,0,NULL,'/file/大众 朗逸.jpg','大众 朗逸.jpg',3,'大众',NULL,NULL,NULL,NULL,NULL,NULL),(25,'大众帕萨特','2019款大众帕萨特','帕萨特',NULL,NULL,'2019-03-17 12:53:09',NULL,NULL,300,0,NULL,0,NULL,'/file/大众 帕萨特330TSI.jpg','大众 帕萨特330TSI.jpg',3,'大众',NULL,NULL,NULL,NULL,NULL,NULL),(26,'大众途昂','2019款大众途昂','途昂',NULL,NULL,'2019-03-17 12:53:51',NULL,NULL,300,0,NULL,0,NULL,'/file/大众 途昂.jpg','大众 途昂.jpg',3,'大众',NULL,NULL,NULL,NULL,NULL,NULL),(27,'大众途岳','2019款大众途岳','途岳',NULL,NULL,'2019-03-17 12:55:12',NULL,NULL,300,0,NULL,0,NULL,'/file/大众 途岳.jpg','大众 途岳.jpg',3,'大众',NULL,NULL,NULL,NULL,NULL,NULL),(28,'丰田卡罗拉','2019款丰田卡罗拉','卡罗拉',NULL,NULL,'2019-03-17 12:56:08',NULL,NULL,200,0,NULL,0,NULL,'/file/丰田 卡罗拉.jpg','丰田 卡罗拉.jpg',5,'丰田',NULL,NULL,NULL,NULL,NULL,NULL),(29,'丰田亚狮龙','2019款丰田亚狮龙','亚狮龙',NULL,NULL,'2019-03-17 12:56:51',NULL,NULL,200,0,NULL,0,NULL,'/file/丰田 亚狮龙.jpg','丰田 亚狮龙.jpg',5,'丰田',NULL,NULL,NULL,NULL,NULL,NULL),(30,'丰田汉兰达','2019款丰田汉兰达','汉兰达',NULL,NULL,'2019-03-17 12:57:33',NULL,NULL,300,0,NULL,0,NULL,'/file/丰田 汉兰达.jpg','丰田 汉兰达.jpg',5,'丰田',NULL,NULL,NULL,NULL,NULL,NULL),(31,'丰田普拉多','2019款丰田普拉多','普拉多',NULL,NULL,'2019-03-17 12:58:11',NULL,NULL,300,0,NULL,0,NULL,'/file/丰田 普拉多.jpg','丰田 普拉多.jpg',5,'丰田',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_spchongzhi` */

DROP TABLE IF EXISTS `t_spchongzhi`;

CREATE TABLE `t_spchongzhi` (
  `spchongzhiId` int(11) NOT NULL AUTO_INCREMENT,
  `spchongzhiName` varchar(255) DEFAULT NULL,
  `spchongzhiMark` varchar(255) DEFAULT NULL,
  `spchongzhiMark1` varchar(255) DEFAULT NULL,
  `spchongzhiMark2` varchar(255) DEFAULT NULL,
  `spchongzhiMark3` varchar(255) DEFAULT NULL,
  `spchongzhiDate` varchar(27) DEFAULT NULL,
  `spchongzhiDate1` varchar(27) DEFAULT NULL,
  `spchongzhiZong` int(11) DEFAULT NULL,
  `spchongzhiJine` double DEFAULT NULL,
  `spchongzhiZe` double DEFAULT NULL,
  `spchongzhiType` int(11) DEFAULT NULL,
  `spchongzhiType1` int(11) DEFAULT NULL,
  `shangpinId` int(11) DEFAULT NULL,
  `shangpinName` varchar(255) DEFAULT NULL,
  `sptypeId` int(11) DEFAULT NULL,
  `sptypeName` varchar(255) DEFAULT NULL,
  `yonghuId` int(11) DEFAULT NULL,
  `yonghuName` varchar(255) DEFAULT NULL,
  `yhroleId` int(11) DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  `yhbumenId` int(11) DEFAULT NULL,
  `yhbumenName` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `spchongzhiImg` varchar(255) DEFAULT NULL,
  `spchongzhiImgName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`spchongzhiId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `t_spchongzhi` */

insert  into `t_spchongzhi`(`spchongzhiId`,`spchongzhiName`,`spchongzhiMark`,`spchongzhiMark1`,`spchongzhiMark2`,`spchongzhiMark3`,`spchongzhiDate`,`spchongzhiDate1`,`spchongzhiZong`,`spchongzhiJine`,`spchongzhiZe`,`spchongzhiType`,`spchongzhiType1`,`shangpinId`,`shangpinName`,`sptypeId`,`sptypeName`,`yonghuId`,`yonghuName`,`yhroleId`,`yhroleName`,`yhbumenId`,`yhbumenName`,`userId`,`userName`,`bumenId`,`bumenName`,`roleId`,`roleName`,`spchongzhiImg`,`spchongzhiImgName`) values (37,NULL,NULL,NULL,NULL,NULL,'2019-03-27 22:57:21',NULL,NULL,10000,NULL,0,NULL,NULL,NULL,NULL,NULL,3,'zhangsan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,NULL,NULL,NULL,NULL,NULL,'2019-04-26 12:06:52',NULL,NULL,10000,NULL,0,NULL,NULL,NULL,NULL,NULL,3,'zhangsan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,NULL,NULL,NULL,NULL,NULL,'2019-04-26 12:37:06',NULL,NULL,10000,NULL,0,NULL,NULL,NULL,NULL,NULL,3,'zhangsan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,NULL,NULL,NULL,NULL,NULL,'2019-04-26 21:40:02',NULL,NULL,10000,NULL,0,NULL,NULL,NULL,NULL,NULL,4,'lisilisi',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,NULL,NULL,NULL,NULL,NULL,'2019-04-26 21:46:49',NULL,NULL,100000,NULL,0,NULL,NULL,NULL,NULL,NULL,3,'zhangsan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,NULL,NULL,NULL,NULL,NULL,'2019-04-26 21:46:58',NULL,NULL,100000,NULL,0,NULL,NULL,NULL,NULL,NULL,4,'lisilisi',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_spchu` */

DROP TABLE IF EXISTS `t_spchu`;

CREATE TABLE `t_spchu` (
  `spchuId` int(11) NOT NULL AUTO_INCREMENT,
  `spchuName` varchar(255) DEFAULT NULL,
  `spchuMark` varchar(255) DEFAULT NULL,
  `spchuMark1` varchar(255) DEFAULT NULL,
  `spchuMark2` varchar(255) DEFAULT NULL,
  `spchuMark3` varchar(255) DEFAULT NULL,
  `spchuDate` varchar(27) DEFAULT NULL,
  `spchuDate1` varchar(27) DEFAULT NULL,
  `spchuZong` int(11) DEFAULT NULL,
  `spchuJine` double DEFAULT NULL,
  `spchuZe` double DEFAULT NULL,
  `spchuType` int(11) DEFAULT NULL,
  `spchuType1` int(11) DEFAULT NULL,
  `shangpinId` int(11) DEFAULT NULL,
  `shangpinName` varchar(255) DEFAULT NULL,
  `sptypeId` int(11) DEFAULT NULL,
  `sptypeName` varchar(255) DEFAULT NULL,
  `yonghuId` int(11) DEFAULT NULL,
  `yonghuName` varchar(255) DEFAULT NULL,
  `yhroleId` int(11) DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  `yhbumenId` int(11) DEFAULT NULL,
  `yhbumenName` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `spchuImg` varchar(255) DEFAULT NULL,
  `spchuImgName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`spchuId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_spchu` */

insert  into `t_spchu`(`spchuId`,`spchuName`,`spchuMark`,`spchuMark1`,`spchuMark2`,`spchuMark3`,`spchuDate`,`spchuDate1`,`spchuZong`,`spchuJine`,`spchuZe`,`spchuType`,`spchuType1`,`shangpinId`,`shangpinName`,`sptypeId`,`sptypeName`,`yonghuId`,`yonghuName`,`yhroleId`,`yhroleName`,`yhbumenId`,`yhbumenName`,`userId`,`userName`,`bumenId`,`bumenName`,`roleId`,`roleName`,`spchuImg`,`spchuImgName`) values (1,NULL,NULL,NULL,NULL,NULL,'2019-02-19 21:52:34',NULL,22,11,242,0,NULL,3,'汽车3',3,'大众',1,'yonghu1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,'yonghu2','2019-02-19 21:52:34',NULL,11,11,121,1,NULL,2,'汽车2',2,'宝马',2,'yonghu2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,NULL,NULL,NULL,'zhangsan','2019-05-16 17:08:02',NULL,10,300,3000,1,NULL,7,'宝马320i M',2,'宝马',3,'zhangsan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,NULL,NULL,NULL,NULL,'zhangsan','2019-10-29 17:19:46',NULL,10,350,3500,1,NULL,11,'??c260',1,'??',3,'zhangsan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,NULL,NULL,NULL,NULL,NULL,'2019-11-25 22:17:25',NULL,10,300,3000,0,NULL,7,'??320i M',2,'??',3,'zhangsan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_sptype` */

DROP TABLE IF EXISTS `t_sptype`;

CREATE TABLE `t_sptype` (
  `sptypeId` int(11) NOT NULL AUTO_INCREMENT,
  `sptypeName` varchar(255) DEFAULT NULL,
  `sptypeMark` varchar(255) DEFAULT NULL,
  `sptypeMark1` varchar(255) DEFAULT NULL,
  `sptypeMark2` int(11) DEFAULT NULL,
  PRIMARY KEY (`sptypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_sptype` */

insert  into `t_sptype`(`sptypeId`,`sptypeName`,`sptypeMark`,`sptypeMark1`,`sptypeMark2`) values (1,'奔驰','奔驰',NULL,NULL),(2,'宝马','宝马',NULL,NULL),(3,'大众','大众',NULL,NULL),(4,'本田','本田',NULL,NULL),(5,'丰田','丰田',NULL,NULL);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `userXingming` varchar(255) DEFAULT NULL,
  `userSex` int(11) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `userPhone` varchar(255) DEFAULT NULL,
  `userMark1` varchar(255) DEFAULT NULL,
  `userMark2` varchar(255) DEFAULT NULL,
  `userMark3` varchar(255) DEFAULT NULL,
  `userMark4` varchar(255) DEFAULT NULL,
  `userDate1` varchar(27) DEFAULT NULL,
  `userDate2` varchar(27) DEFAULT NULL,
  `userType1` int(11) DEFAULT NULL,
  `userType2` int(11) DEFAULT NULL,
  `userImg` varchar(255) DEFAULT NULL,
  `userImgName` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`userId`,`userName`,`userPassword`,`userXingming`,`userSex`,`userAge`,`userPhone`,`userMark1`,`userMark2`,`userMark3`,`userMark4`,`userDate1`,`userDate2`,`userType1`,`userType2`,`userImg`,`userImgName`,`roleId`,`roleName`,`bumenId`,`bumenName`) values (1,'user1','user1','user1',0,22,'13012345678','user1','user1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'user2','user2','user2',1,22,'13012345677','uesr2','user2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_yonghu` */

DROP TABLE IF EXISTS `t_yonghu`;

CREATE TABLE `t_yonghu` (
  `yonghuId` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuName` varchar(255) DEFAULT NULL,
  `yonghuPassword` varchar(255) DEFAULT NULL,
  `yonghuXingming` varchar(255) DEFAULT NULL,
  `yonghuSex` int(11) DEFAULT NULL,
  `yonghuAge` int(11) DEFAULT NULL,
  `yonghuPhone` varchar(255) DEFAULT NULL,
  `yonghuMark1` varchar(255) DEFAULT NULL,
  `yonghuMark2` varchar(255) DEFAULT NULL,
  `yonghuMark3` varchar(255) DEFAULT NULL,
  `yonghuMark4` varchar(255) DEFAULT NULL,
  `yonghuDate1` varchar(27) DEFAULT NULL,
  `yonghuDate2` varchar(27) DEFAULT NULL,
  `yonghuType1` int(11) DEFAULT NULL,
  `yonghuType2` int(11) DEFAULT NULL,
  `yonghuImg` varchar(255) DEFAULT NULL,
  `yonghuImgName` varchar(255) DEFAULT NULL,
  `yhroleId` int(11) DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  `yhbumenId` int(11) DEFAULT NULL,
  `yhbumenName` varchar(255) DEFAULT NULL,
  `yonghuYue` double DEFAULT NULL,
  `yonghuXiaofei` double DEFAULT NULL,
  PRIMARY KEY (`yonghuId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_yonghu` */

insert  into `t_yonghu`(`yonghuId`,`yonghuName`,`yonghuPassword`,`yonghuXingming`,`yonghuSex`,`yonghuAge`,`yonghuPhone`,`yonghuMark1`,`yonghuMark2`,`yonghuMark3`,`yonghuMark4`,`yonghuDate1`,`yonghuDate2`,`yonghuType1`,`yonghuType2`,`yonghuImg`,`yonghuImgName`,`yhroleId`,`yhroleName`,`yhbumenId`,`yhbumenName`,`yonghuYue`,`yonghuXiaofei`) values (1,'yonghu1','yonghu1','yonghu1',0,22,'13012345678','yonghu1',NULL,NULL,NULL,'2019-02-19 22:01:03',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0),(2,'yonghu2','yonghu2','yonghu2',0,22,'13012345678','yonghu2',NULL,NULL,NULL,'2019-02-19 22:05:48',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,999879,121),(3,'zhangsan','zhangsan','zhangsan',0,23,'17877501231','zhangsan',NULL,NULL,NULL,'2019-03-16 19:06:33',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,74000,56000),(4,'lisilisi','lisilisi','lisilisi',0,22,'17877501231','lisilisi',NULL,NULL,NULL,'2019-03-26 20:18:15',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100000,10000);

/*Table structure for table `t_yxinxi` */

DROP TABLE IF EXISTS `t_yxinxi`;

CREATE TABLE `t_yxinxi` (
  `yxinxiId` int(11) NOT NULL AUTO_INCREMENT,
  `yxinxiName` varchar(255) DEFAULT NULL,
  `yxinxiMark` varchar(255) DEFAULT NULL,
  `yxinxiMark1` varchar(255) DEFAULT NULL,
  `yxinxiMark2` varchar(255) DEFAULT NULL,
  `yxinxiImg` varchar(255) DEFAULT NULL,
  `yxinxiImgName` varchar(255) DEFAULT NULL,
  `yxinxiDate` varchar(27) DEFAULT NULL,
  `yxinxiType` int(11) DEFAULT NULL,
  `yxinxiType1` int(11) DEFAULT NULL,
  `yxtypeId` int(11) DEFAULT NULL,
  `yxtypeName` varchar(255) DEFAULT NULL,
  `yonghuId` int(11) DEFAULT NULL,
  `yonghuName` varchar(255) DEFAULT NULL,
  `yhbumenId` int(11) DEFAULT NULL,
  `yhbumenName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`yxinxiId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_yxinxi` */

insert  into `t_yxinxi`(`yxinxiId`,`yxinxiName`,`yxinxiMark`,`yxinxiMark1`,`yxinxiMark2`,`yxinxiImg`,`yxinxiImgName`,`yxinxiDate`,`yxinxiType`,`yxinxiType1`,`yxtypeId`,`yxtypeName`,`yonghuId`,`yonghuName`,`yhbumenId`,`yhbumenName`) values (1,'期待能上架更多车型','期待能上架更多车型供人选择','好的好的',NULL,NULL,NULL,'2019-03-17 13:24:16',NULL,NULL,NULL,NULL,3,'zhangsan',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
