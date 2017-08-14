-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: LibraryDB
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.17.04.1

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_title` varchar(150) COLLATE utf8_bin NOT NULL,
  `b_author` varchar(255) COLLATE utf8_bin NOT NULL,
  `b_genre` varchar(150) COLLATE utf8_bin NOT NULL,
  `b_year` varchar(4) COLLATE utf8_bin NOT NULL,
  `b_quantity` smallint(5) NOT NULL,
  `b_status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'MyBook','Action','Vasya_Pupkin','2017',2,0),(2,'MyBook','Action','Vasya_Pupkin','2017',2,0),(3,'MyBook','Action','Vasya_Pupkin','2017',2,0),(4,'MyBook','Action','Vasya_Pupkin','2017',2,0),(5,'MyBook','Action','Vasya_Pupkin','2017',2,0),(6,'MyBook','Action','Vasya_Pupkin','2017',2,0),(7,'MyBook','Action','Vasya_Pupkin','2017',2,0),(8,'MyBook','Action','Vasya_Pupkin','2017',2,0),(9,'MyBook','Action','Vasya_Pupkin','2017',2,0),(10,'MyBook','Action','Vasya_Pupkin','2017',2,0),(11,'MyBook','Action','Vasya_Pupkin','2017',2,0),(12,'MyBook','Action','Vasya_Pupkin','2017',2,0),(13,'MyBook','Action','Vasya_Pupkin','2017',2,0),(14,'MyBook','Action','Vasya_Pupkin','2017',2,0),(15,'MyBook','Action','Petya_Pupkin','2017',2,0),(16,'MyBook','Action','Vasya_Pupkin','2017',2,0),(17,'MyBook','Action','Vasya_Pupkin','2017',2,0),(18,'MyBook','Action','Vasya_Pupkin','2017',2,0),(19,'MyBook','Action','Vasya_Pupkin','2017',2,0),(20,'MyBook','Action','Vasya_Pupkin','2017',2,0),(21,'MyBook','Action','Vasya_Pupkin','2017',2,0),(22,'MyBook','Action','Vasya_Pupkin','2017',2,0),(23,'MyBook','Action','Vasya_Pupkin','2017',2,0),(24,'MyBook','Action','Vasya_Pupkin','2017',2,0),(25,'MyBook','Action','Vasya_Pupkin','2017',2,0),(26,'MyBook','Action','Vasya_Pupkin','2017',2,0),(27,'MyBook','Action','Vasya_Pupkin','2017',2,0),(28,'MyBook','Action','Vasya_Pupkin','2017',2,0),(29,'MyBook','Action','Vasya_Pupkin','2017',2,0),(30,'MyBook','Action','Vasya_Pupkin','2017',2,0),(31,'MyBook','Action','Vasya_Pupkin','2017',2,0),(32,'MyBook','Action','Vasya_Pupkin','2017',2,0),(33,'MyBook','Action','Vasya_Pupkin','2017',2,0),(34,'MyBook','Action','Vasya_Pupkin','2017',2,0),(35,'MyBook','Action','Vasya_Pupkin','2017',2,0),(36,'MyBook','Action','Vasya_Pupkin','2017',2,0),(37,'MyBook','Action','Vasya_Pupkin','2017',2,0),(38,'MyBook','Action','Vasya_Pupkin','2017',2,0),(39,'MyBook','Action','Vasya_Pupkin','2017',2,0),(40,'MyBook','Action','Vasya_Pupkin','2017',2,0),(41,'MyBook','Action','Vasya_Pupkin','2017',2,0),(42,'MyBook','Action','Vasya_Pupkin','2017',2,0),(43,'MyBook','Action','Vasya_Pupkin','2017',2,0),(44,'MyBook','Action','Vasya_Pupkin','2017',2,0),(45,'MyBook','Action','Vasya_Pupkin','2017',2,0),(46,'MyBook','Action','Vasya_Pupkin','2017',2,0),(47,'MyBook','Action','Vasya_Pupkin','2017',2,0),(48,'MyBook','Action','Vasya_Pupkin','2017',2,0),(49,'MyBook','Action','Vasya_Pupkin','2017',2,0),(50,'MyBook','Action','Vasya_Pupkin','2017',2,0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rent` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `b_id` int(11) NOT NULL,
  `r_start` date NOT NULL,
  `r_end` date NOT NULL,
  `r_status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`r_id`),
  KEY `fk_rent_user1_idx` (`u_id`),
  KEY `fk_rent_book1_idx` (`b_id`),
  CONSTRAINT `fk_rent_book1` FOREIGN KEY (`b_id`) REFERENCES `book` (`b_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rent_user1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_login` varchar(150) COLLATE utf8_bin NOT NULL,
  `u_password` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'???????_??????','-1861353340'),(2,'???????_??????','-1861353340'),(3,'???????_??????','-1861353340'),(4,'???????_??????','-1861353340'),(5,'???????_??????','-1861353340'),(6,'???????_??????','-1861353340'),(7,'???????_??????','-1861353340'),(8,'???????_??????','-1861353340'),(9,'???????_??????','-1861353340'),(10,'???????_??????','-1861353340'),(11,'???????_??????','-1861353340'),(12,'???????_??????','-1861353340'),(13,'???????_??????','-1861353340'),(14,'???????_??????','-1861353340'),(15,'???????_??????','-1861353340'),(16,'???????_??????','-1861353340'),(17,'???????_??????','-1861353340'),(18,'???????_??????','-1861353340'),(19,'???????_??????','-1861353340'),(20,'???????_??????','-1861353340'),(21,'???????_??????','-1861353340'),(22,'???????_??????','-1861353340'),(23,'???????_??????','-1861353340'),(24,'???????_??????','-1861353340'),(25,'???????_??????','-1861353340'),(26,'???????_??????','-1861353340'),(27,'???????_??????','-1861353340'),(28,'???????_??????','-1861353340'),(29,'???????_??????','-1861353340'),(30,'???????_??????','-1861353340'),(31,'???????_??????','-1861353340'),(32,'???????_??????','-1861353340'),(33,'???????_??????','-1861353340'),(34,'???????_??????','-1861353340'),(35,'???????_??????','-1861353340'),(36,'???????_??????','-1861353340'),(37,'???????_??????','-1861353340'),(38,'???????_??????','-1861353340'),(39,'???????_??????','-1861353340'),(40,'???????_??????','-1861353340'),(41,'???????_??????','-1861353340'),(42,'???????_??????','-1861353340'),(43,'???????_??????','-1861353340'),(44,'???????_??????','-1861353340'),(45,'???????_??????','-1861353340'),(46,'???????_??????','-1861353340'),(47,'???????_??????','-1861353340'),(48,'???????_??????','-1861353340'),(49,'???????_??????','-1861353340'),(50,'???????_??????','-1861353340'),(51,'???????_??????','-1861353340'),(52,'???????_??????','-1861353340'),(53,'???????_??????','-1861353340'),(54,'???????_??????','-1861353340'),(55,'???????_??????','-1861353340'),(56,'???????_??????','-1861353340'),(57,'???????_??????','-1861353340'),(58,'???????_??????','-1861353340'),(59,'???????_??????','-1861353340'),(60,'???????_??????','-1861353340'),(61,'???????_??????','-1861353340'),(62,'???????_??????','-1861353340'),(63,'???????_??????','-1861353340'),(64,'???????_??????','-1861353340'),(65,'???????_??????','-1861353340');
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

-- Dump completed on 2017-08-14 11:10:17
