CREATE DATABASE  IF NOT EXISTS `flight_search_system` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `flight_search_system`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: flight_search_system
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `flight_details`
--

DROP TABLE IF EXISTS `flight_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight_details` (
  `flightNumber` varchar(10) NOT NULL,
  `flightOwnerID` int(11) NOT NULL,
  `departureLocationCode` varchar(3) NOT NULL,
  `arrivalLocationCode` varchar(3) NOT NULL,
  `lastValidDate` date NOT NULL,
  `departureTime` int(11) NOT NULL,
  `durationInMinutes` int(11) NOT NULL,
  `fare` float NOT NULL,
  `isSeatAvailable` bit(1) NOT NULL,
  `flightClass` char(2) NOT NULL,
  PRIMARY KEY (`flightNumber`),
  UNIQUE KEY `flightNumber` (`flightNumber`),
  KEY `flightOwnerID` (`flightOwnerID`),
  CONSTRAINT `flightOwnerID` FOREIGN KEY (`flightOwnerID`) REFERENCES `flight_owners` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_details`
--

LOCK TABLES `flight_details` WRITE;
/*!40000 ALTER TABLE `flight_details` DISABLE KEYS */;
INSERT INTO `flight_details` VALUES ('6E370',2,'DEL','BGR','2013-12-19',730,288,7500,'\0','EB'),('6E375',2,'DEL','BGR','2013-12-27',1330,285,8300,'','EB'),('6E377',2,'DEL','MUB','2013-12-05',500,250,5100,'\0','E'),('6E378',2,'DEL','MUB','2013-12-25',1830,265,5300,'','EB'),('6E379',2,'DEL','MUB','2013-12-12',930,250,5500,'\0','EB'),('6E385',2,'DEL','BGR','2013-12-31',1130,290,8100,'','EB'),('6E389',2,'DEL','MUB','2013-12-17',1230,240,6650,'\0','E'),('6E395',2,'DEL','BGR','2013-12-31',630,255,9000,'','EB'),('9W370',3,'DEL','BGR','2013-12-19',1430,285,8500,'\0','EB'),('9W375',3,'DEL','BGR','2013-12-12',1330,285,8300,'','E'),('9W377',3,'DEL','MUB','2013-12-06',600,250,5500,'\0','EB'),('9W378',3,'DEL','MUB','2013-12-17',1830,260,5300,'','EB'),('9W379',3,'DEL','MUB','2013-12-15',630,270,4900,'','E'),('9W385',3,'DEL','BGR','2013-12-27',1330,290,8100,'','EB'),('9W389',3,'DEL','MUB','2013-12-17',830,240,5650,'\0','E'),('9W395',3,'DEL','BGR','2013-12-31',1930,255,9000,'','EB'),('AI270',1,'DEL','BGR','2013-12-12',1430,285,8500,'\0','B'),('AI275',1,'DEL','BGR','2013-12-15',1330,285,8300,'','EB'),('AI277',1,'DEL','MUB','2013-12-05',600,250,5500,'\0','B'),('AI278',1,'DEL','MUB','2013-12-17',1830,260,5300,'','E'),('AI279',1,'DEL','MUB','2013-12-10',630,270,4900,'\0','E'),('AI285',1,'DEL','BGR','2013-12-17',1330,290,8100,'','EB'),('AI289',1,'DEL','MUB','2013-12-10',830,240,5650,'\0','B'),('AI295',1,'DEL','BGR','2013-12-25',1930,255,9000,'','EB');
/*!40000 ALTER TABLE `flight_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_owners`
--

DROP TABLE IF EXISTS `flight_owners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight_owners` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ownerName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `ownerName` (`ownerName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_owners`
--

LOCK TABLES `flight_owners` WRITE;
/*!40000 ALTER TABLE `flight_owners` DISABLE KEYS */;
INSERT INTO `flight_owners` VALUES (1,'Air India'),(2,'Indigo'),(3,'Jet Air');
/*!40000 ALTER TABLE `flight_owners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `userName` (`userName`),
  CONSTRAINT `userName` FOREIGN KEY (`userName`) REFERENCES `users` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (2,'ashish','ROLE_USER'),(3,'ola','ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `emailId` varchar(80) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userName`),
  UNIQUE KEY `userName` (`userName`),
  UNIQUE KEY `emailId` (`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('ashish','ashish','jindal1991@gmail.com',1),('ola','ola','ola@ola.com',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-19 12:42:51
