-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `RoomId` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `Username` varchar(45) NOT NULL,
  PRIMARY KEY (`RoomId`,`StartDate`),
  KEY `FKrbobnptxf02ecxyv1ap2hlefs` (`Username`),
  CONSTRAINT `FKrbobnptxf02ecxyv1ap2hlefs` FOREIGN KEY (`Username`) REFERENCES `users` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (11,'2017-10-04','2017-10-05','batman@batman.com'),(11,'2017-10-12','2017-10-13','batman@batman.com'),(11,'2017-11-01','2017-11-02','user1@user.com'),(11,'2017-11-02','2017-11-04','user1@user.com'),(11,'2017-11-08','2017-11-09','user1@user.com'),(11,'2017-11-10','2017-11-09','user1@user.com'),(11,'2017-11-19','2017-11-20','user1@user.com'),(11,'2017-11-20','2017-11-21','user1@user.com'),(11,'2017-11-22','2017-11-23','user1@user.com'),(11,'2017-12-01','2017-12-02','user2@user.com'),(11,'2017-12-12','2017-12-12','user1@user.com'),(11,'2017-12-18','2017-12-19','user2@user.com'),(11,'2017-12-20','2017-12-21','user1@user.com'),(11,'2017-12-29','2017-12-29','user1@user.com'),(21,'2017-10-04','2017-10-05','batman@batman.com'),(21,'2017-10-12','2017-10-13','batman@batman.com'),(21,'2017-11-01','2017-11-02','user1@user.com'),(21,'2017-11-02','2017-11-04','user1@user.com'),(21,'2017-11-10','2017-11-11','user1@user.com'),(21,'2017-12-01','2017-12-02','user2@user.com'),(21,'2017-12-18','2017-12-19','user2@user.com'),(22,'2017-11-19','2017-11-20','user1@user.com'),(31,'2017-10-04','2017-10-05','batman@batman.com'),(31,'2017-11-01','2017-11-02','user1@user.com'),(31,'2017-11-10','2017-11-11','user1@user.com'),(31,'2017-12-18','2017-12-19','user2@user.com'),(33,'2017-11-22','2017-11-25','user1@user.com');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photos`
--

DROP TABLE IF EXISTS `photos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photos` (
  `PhotoId` int(11) NOT NULL AUTO_INCREMENT,
  `PhotoName` varchar(45) NOT NULL,
  PRIMARY KEY (`PhotoId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photos`
--

LOCK TABLES `photos` WRITE;
/*!40000 ALTER TABLE `photos` DISABLE KEYS */;
INSERT INTO `photos` VALUES (1,'hotel-1.jpg'),(2,'hotel-2.jpg'),(3,'hotel-3.jpg');
/*!40000 ALTER TABLE `photos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'user'),(2,'admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rooms` (
  `RoomId` int(11) NOT NULL,
  `RoomTypesId` int(11) NOT NULL,
  `Occupied` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`RoomId`),
  KEY `RoomTypesId` (`RoomTypesId`),
  CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`RoomTypesId`) REFERENCES `roomtypes` (`RoomTypesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (11,1,1),(21,2,0),(31,3,0);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomtypes`
--

DROP TABLE IF EXISTS `roomtypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roomtypes` (
  `RoomTypesId` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(45) DEFAULT NULL,
  `NumberOfBeds` int(11) DEFAULT '2',
  PRIMARY KEY (`RoomTypesId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomtypes`
--

LOCK TABLES `roomtypes` WRITE;
/*!40000 ALTER TABLE `roomtypes` DISABLE KEYS */;
INSERT INTO `roomtypes` VALUES (1,'bathroom, tv',1),(2,'bathroom, tv',2),(3,'bathroom, tv',3),(4,'tv',1),(5,'tv',2);
/*!40000 ALTER TABLE `roomtypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinformation`
--

DROP TABLE IF EXISTS `userinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinformation` (
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Phone` int(10) NOT NULL,
  `Email` varchar(45) NOT NULL,
  PRIMARY KEY (`Email`),
  CONSTRAINT `userinformation_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `users` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinformation`
--

LOCK TABLES `userinformation` WRITE;
/*!40000 ALTER TABLE `userinformation` DISABLE KEYS */;
INSERT INTO `userinformation` VALUES ('Sheldon','Cooper','Los Robles',987654321,'admin@admin.com'),('Bat','Man','',1111111111,'batman@batman.com'),('Leonard','Hofstadter','Los Robles',1234567890,'user1@user.com'),('User','Two','',1111111111,'user2@user.com');
/*!40000 ALTER TABLE `userinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `Username` varchar(45) NOT NULL,
  `Password` varchar(64) NOT NULL,
  `RoleId` int(11) NOT NULL,
  PRIMARY KEY (`Username`),
  KEY `FKntreoimw86ojl0fnss8bh0h9j` (`RoleId`),
  CONSTRAINT `FKntreoimw86ojl0fnss8bh0h9j` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`RoleId`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin@admin.com','pass2',2),('batman@batman.com','asdeasde',1),('user1@user.com','pass1',1),('user2@user.com','6fe5464bd69ee00d525ae8a2b30c6cba',1);
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

-- Dump completed on 2017-11-28 21:40:33
