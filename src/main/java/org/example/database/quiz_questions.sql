-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: quiz
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(255) NOT NULL,
  `correct_answer` varchar(45) NOT NULL,
  `wrong_answer1` varchar(45) NOT NULL,
  `wrong_answer2` varchar(45) NOT NULL,
  `wrong_answer3` varchar(45) NOT NULL,
  `sub_category_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`question_id`),
  KEY `fk_questions_sub_categories_idx` (`sub_category_id`),
  KEY `fk_questions_categories1_idx` (`category_id`),
  CONSTRAINT `fk_questions_categories` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_questions_sub_categories` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_categories` (`sub_category_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (3,'Which creature serves as the steed of the Nazgûl and is often associated with their presence?','Fell Beasts','Wargs','Eagles','Trolls',1,1),(4,'What is the capital city of Gondor, the largest kingdom of Men in Middle-earth?','Minas Tirith','Rivendell','Minas Morgul','Lothlórien',1,1),(5,'Kdo se jako první v Roklince přidal k Frodovi poté, co se nabídl, že odnese prsten do Mordoru? ','Gandalf','Legolas','Aragorn','Sam',1,1),(6,'Na úsvitu kolikátého dne dorazil Gandalf s Eomerem do Helmove Žlebu?','Pátého','Šestého','Druhého','Třetího',1,1),(7,'Jaký druh tvora byl Sméagol (Gollum) předtím, než se zmocnil Jednoho prstenu?','Hobit','Skřet','Elf','Trpaslík',1,1),(8,'Jaký je titul prvního dílu trilogie Pán prstenů, kde začíná dobrodružství s Prstenem?','Společenstvo prsten','Dvě věže','Návrat krále','Bitva pěti armád',1,1),(9,'V jakém roce byl vydán film s názvem Pán prstenů: Společenstvo prstenu?','2001','2004','1999','1997',1,1),(10,'Kdo se v Roklince řízne úlomkem Narsilu, jenž uťal ruku Sauronovi?','Boromir','Aragorn','Gimli','Legolas',1,1),(11,'Který herec se ve skutečnosti setkal s Tolkienem?','Christopher Lee','Ian McKellen','Hugo Weaving','Ian Holm',1,1),(12,'Kdo ze společenstva byl nositelem meče Glamdring?','Gandalf','Aragorn','Boromir','Frodo',1,1),(13,'Kolik šípů Boromira zasáhne než umře?','Tři','Dva','Čtyři','Pět',1,1),(14,'U kterého města se odehrála bitva na Pelennorských polích?','Minas Tirith','Helmův žleb','Edoras','Minas Morgul',1,1),(15,'Jak říká Geralt každému svému koni?','Klepna','Stínovlas','Kelpie','Renfri',3,2),(16,'Jak se nazývá zaklínači ovládané znamení, které vyvolá telekinetický náboj odhazující nepřátele?','Aard','Yrden','Igni','Axie',3,2),(17,'Jak se jmenoval generál Divokého Honu, který zabil Vesemira??','Imlerith','Eredin','Caranthir','Avallac\'h',3,2),(18,'Rozšíření O víně a krví pro Zaklínače 3 přidalo pátou hratelnou frakci v Gwintu. Jakou?','Skellige','Wild Hunt','Mahakam','Toussaint',3,2),(19,'Seřaďte následující kategorie od nejkratšího závodu po nejdelší.','Sprint, Super, Beast, Ultra','Super, Sprint, Beast, Ultra','Beast, Ultra, Sprint, Super','Sprint, Beast, Super, Ultra',5,3),(20,'Jak se jmenuje klobouk, který žáky rozzařuje do kolejí?','Moudrý klobouk','Nadaný klobouk','Starý klobouk','Chytrý klobouk',2,1),(21,'Kdo jako jediný dokázal vyrobit kámen mudrců?','Nikolas Flamel','Lord Voldemort','Profesor Snape','Albus Brumbál',2,1),(22,'Jakou část oblečení najde Dobby v deníku, který mu podá  Lucius Malfoy ve druhém díle? ','Ponožku','Kravatu','Šálu','Kapesník',2,1),(23,'Kdo zradil Lily a Jamese Potterovi a prozradil je Lordu Voldemortovi? ','Peter Pettigrew','Tom Raddle','Remus Lupin','Lucius Malfoy',2,1),(24,'Kolik let musí dovršit kouzelník, aby se mohl zúčastnit turnaje Tří kouzelníků?','17','21','25','15',2,1),(25,'S kým si dá Harry v pátém díle pusu pod jmelím?','s Cho','s Ginny','S Hermionou','s Lunou',2,1),(26,'Dark Souls 2 má s přehledem největší počet bossů z celé série. Kolik jich ve hře - i se všemi DLC - najdeme?','41','39','32','46',4,2),(27,'Bloodborne je silně inspirované pracemi jednoho slavného spisovatele. Jak se tento spisovatel jmenuje?','Howard Philips Lovecraft','Stephen King','Edgar Allan Poe','Bram Stocker',4,2),(28,'Dark Souls 3 a Demon\'s Souls spojuje jedna významná zbraň, která vám v obou hrách pomůže s jedním bossfightem. O jakou zbraň se jedná?','Storm Ruler','Blade of Ash','King Maker','Morning Star',4,2),(29,'Navzdory faktu, že jde o jednoho z nejikoničtějších nepřátel Dark Souls, tak se Mimic v prvním díle objevuje pouze čtyřikrát. Kde ho můžeme objevit vůbec poprvé?','Sen\'s Fortress','Anor Londo','Tomb of the Giants','Undead Parish',4,2),(30,'Jaký je pokřik na Spartan Race?','Aroo','Huray','Jabadabadů','Oorah',5,3),(31,'Co se dělá na závodech za trest při nezdolání překážky?','Angličáky','Raci','Kliky','Dřepy',5,3);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-30 18:01:10
