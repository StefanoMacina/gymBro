-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gymbro
-- ------------------------------------------------------
-- Server version	9.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `body_group`
--

DROP TABLE IF EXISTS `body_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `body_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Gruppo muscolare. Usato per classificare gli esercizi.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body_group`
--

LOCK TABLES `body_group` WRITE;
/*!40000 ALTER TABLE `body_group` DISABLE KEYS */;
INSERT INTO `body_group` VALUES (1,'2025-05-28 12:02:10.684000','2025-05-28 12:02:10.684000',NULL,'Gran dorsale'),(2,'2025-05-28 12:02:10.723000','2025-05-28 12:02:10.723000',NULL,'Estensori'),(3,'2025-05-28 12:02:10.738000','2025-05-28 12:02:10.738000',NULL,'Bicipite brachiale'),(4,'2025-05-28 12:02:10.752000','2025-05-28 12:02:10.752000',NULL,'Avambracci'),(5,'2025-05-28 12:02:10.766000','2025-05-28 12:02:10.766000',NULL,'Deltoidi'),(6,'2025-05-28 12:02:10.779000','2025-05-28 12:02:10.779000',NULL,'Tibiale anteriore'),(7,'2025-05-28 12:02:10.794000','2025-05-28 12:02:10.794000',NULL,'Erettori spinali'),(8,'2025-05-28 12:02:10.808000','2025-05-28 12:02:10.808000',NULL,'Gastrocnemio'),(9,'2025-05-28 12:02:10.822000','2025-05-28 12:02:10.822000',NULL,'Brachiale'),(10,'2025-05-28 12:02:10.837000','2025-05-28 12:02:10.837000',NULL,'Lombari'),(11,'2025-05-28 12:02:10.852000','2025-05-28 12:02:10.852000',NULL,'Tricipiti'),(12,'2025-05-28 12:02:10.866000','2025-05-28 12:02:10.866000',NULL,'Dentato anteriore'),(13,'2025-05-28 12:02:10.879000','2025-05-28 12:02:10.879000',NULL,'Semimembranoso'),(14,'2025-05-28 12:02:10.894000','2025-05-28 12:02:10.894000',NULL,'Retto addominale'),(15,'2025-05-28 12:02:10.907000','2025-05-28 12:02:10.907000',NULL,'Deltoide anteriore'),(16,'2025-05-28 12:02:10.920000','2025-05-28 12:02:10.920000',NULL,'Flessori dell\'anca'),(17,'2025-05-28 12:02:10.934000','2025-05-28 12:02:10.934000',NULL,'Vasto mediale'),(18,'2025-05-28 12:02:10.944000','2025-05-28 12:02:10.944000',NULL,'Trapezio'),(19,'2025-05-28 12:02:10.955000','2025-05-28 12:02:10.955000',NULL,'Pettorale minore'),(20,'2025-05-28 12:02:10.969000','2025-05-28 12:02:10.969000',NULL,'Bicipiti'),(21,'2025-05-28 12:02:10.982000','2025-05-28 12:02:10.982000',NULL,'Schiena'),(22,'2025-05-28 12:02:10.996000','2025-05-28 12:02:10.996000',NULL,'Deltoide posteriore'),(23,'2025-05-28 12:02:11.008000','2025-05-28 12:02:11.008000',NULL,'Vasto laterale'),(24,'2025-05-28 12:02:11.019000','2025-05-28 12:02:11.019000',NULL,'Piccolo gluteo'),(25,'2025-05-28 12:02:11.031000','2025-05-28 12:02:11.031000',NULL,'Capo laterale tricipite'),(26,'2025-05-28 12:02:11.043000','2025-05-28 12:02:11.043000',NULL,'Quadricipiti'),(27,'2025-05-28 12:02:11.054000','2025-05-28 12:02:11.054000',NULL,'Capo mediale tricipite'),(28,'2025-05-28 12:02:11.069000','2025-05-28 12:02:11.069000',NULL,'Capo lungo tricipite'),(29,'2025-05-28 12:02:11.082000','2025-05-28 12:02:11.082000',NULL,'Vasto intermedio'),(30,'2025-05-28 12:02:11.096000','2025-05-28 12:02:11.096000',NULL,'Retto femorale'),(31,'2025-05-28 12:02:11.110000','2025-05-28 12:02:11.110000',NULL,'Soleo'),(32,'2025-05-28 12:02:11.123000','2025-05-28 12:02:11.123000',NULL,'Semitendinoso'),(33,'2025-05-28 12:02:11.135000','2025-05-28 12:02:11.135000',NULL,'Scaleni'),(34,'2025-05-28 12:02:11.146000','2025-05-28 12:02:11.146000',NULL,'Addominali'),(35,'2025-05-28 12:02:11.159000','2025-05-28 12:02:11.159000',NULL,'Obliqui'),(36,'2025-05-28 12:02:11.170000','2025-05-28 12:02:11.170000',NULL,'Flessori'),(37,'2025-05-28 12:02:11.182000','2025-05-28 12:02:11.182000',NULL,'Petto'),(38,'2025-05-28 12:02:11.193000','2025-05-28 12:02:11.193000',NULL,'Intercostali'),(39,'2025-05-28 12:02:11.203000','2025-05-28 12:02:11.203000',NULL,'Sartorio'),(40,'2025-05-28 12:02:11.214000','2025-05-28 12:02:11.214000',NULL,'Ileopsoas'),(41,'2025-05-28 12:02:11.224000','2025-05-28 12:02:11.224000',NULL,'Abduttori'),(42,'2025-05-28 12:02:11.234000','2025-05-28 12:02:11.234000',NULL,'Trapezio superiore'),(43,'2025-05-28 12:02:11.245000','2025-05-28 12:02:11.245000',NULL,'Polpacci'),(44,'2025-05-28 12:02:11.258000','2025-05-28 12:02:11.258000',NULL,'Adduttori'),(45,'2025-05-28 12:02:11.271000','2025-05-28 12:02:11.271000',NULL,'Femorali'),(46,'2025-05-28 12:02:11.283000','2025-05-28 12:02:11.283000',NULL,'Grande gluteo'),(47,'2025-05-28 12:02:11.295000','2025-05-28 12:02:11.295000',NULL,'Romboidi'),(48,'2025-05-28 12:02:11.306000','2025-05-28 12:02:11.306000',NULL,'Bicipite femorale'),(49,'2025-05-28 12:02:11.319000','2025-05-28 12:02:11.319000',NULL,'Glutei'),(50,'2025-05-28 12:02:11.332000','2025-05-28 12:02:11.332000',NULL,'Quadrato dei lombi'),(51,'2025-05-28 12:02:11.344000','2025-05-28 12:02:11.344000',NULL,'Trasverso dell\'addome'),(52,'2025-05-28 12:02:11.357000','2025-05-28 12:02:11.357000',NULL,'Brachioradiale'),(53,'2025-05-28 12:02:11.370000','2025-05-28 12:02:11.370000',NULL,'Pettorale maggiore'),(54,'2025-05-28 12:02:11.382000','2025-05-28 12:02:11.382000',NULL,'Cuffia dei rotatori'),(55,'2025-05-28 12:02:11.393000','2025-05-28 12:02:11.393000',NULL,'Serratus'),(56,'2025-05-28 12:02:11.402000','2025-05-28 12:02:11.402000',NULL,'Deltoide laterale'),(57,'2025-05-28 12:02:11.412000','2025-05-28 12:02:11.412000',NULL,'Spalle'),(58,'2025-05-28 12:02:11.422000','2025-05-28 12:02:11.422000',NULL,'Medio gluteo');
/*!40000 ALTER TABLE `body_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `body_group_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKerqrw1auk16an3nuiwmtljqlg` (`body_group_id`),
  CONSTRAINT `FKerqrw1auk16an3nuiwmtljqlg` FOREIGN KEY (`body_group_id`) REFERENCES `body_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Esercizio singolo. Può essere inserito da app o creato da utente';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'2025-05-28 12:02:11.450000','2025-05-28 12:02:11.450000','Distesi su una panca, sollevare il bilanciere dal rack fino a distendere completamente le braccia','barbellChestPress',37),(2,'2025-05-28 12:02:11.468000','2025-05-28 12:02:11.468000','Come la panca piana ma con la panca inclinata a 30-45 gradi','Panca inclinata',37),(3,'2025-05-28 12:02:11.485000','2025-05-28 12:02:11.485000','Variante con panca inclinata negativamente','Panca declinata',37),(4,'2025-05-28 12:02:11.502000','2025-05-28 12:02:11.502000','Aperture laterali su panca per isolare il petto','Crocifisso con manubri',53),(5,'2025-05-28 12:02:11.518000','2025-05-28 12:02:11.518000','Croci ai cavi per enfasi sul petto','Cable crossover',19),(6,'2025-05-28 12:02:11.533000','2025-05-28 12:02:11.533000','Piegamenti alle parallele con enfasi sul petto','Dips parallele',37),(7,'2025-05-28 12:02:11.549000','2025-05-28 12:02:11.549000','Trazioni alla sbarra con presa larga','Pull-up',1),(8,'2025-05-28 12:02:11.563000','2025-05-28 12:02:11.563000','Simulatore di trazioni con carico regolabile','Lat machine',1),(9,'2025-05-28 12:02:11.578000','2025-05-28 12:02:11.578000','Piegati in avanti, tirare il bilanciere verso l\'addome','Rematore con bilanciere',21),(10,'2025-05-28 12:02:11.592000','2025-05-28 12:02:11.592000','Variante del rematore con bilanciere','T-Bar row',21),(11,'2025-05-28 12:02:11.605000','2025-05-28 12:02:11.605000','Stacco da terra completo','Deadlift',7),(12,'2025-05-28 12:02:11.617000','2025-05-28 12:02:11.617000','Alzate delle spalle per i trapezi','Shrugs con bilanciere',42),(13,'2025-05-28 12:02:11.630000','2025-05-28 12:02:11.630000','Esercizio per deltoidi posteriori e trapezi','Face pull',18),(14,'2025-05-28 12:02:11.644000','2025-05-28 12:02:11.644000','Alzate frontali con bilanciere','Military press',5),(15,'2025-05-28 12:02:11.658000','2025-05-28 12:02:11.658000','Con manubri, sollevare le braccia lateralmente','Alzate laterali',5),(16,'2025-05-28 12:02:11.672000','2025-05-28 12:02:11.672000','Shoulder press con rotazione','Arnold press',5),(17,'2025-05-28 12:02:11.689000','2025-05-28 12:02:11.689000','Spinta del bilanciere dietro la testa','Lento dietro',57),(18,'2025-05-28 12:02:11.705000','2025-05-28 12:02:11.705000','Rotazioni esterne per la cuffia dei rotatori','External rotation',54),(19,'2025-05-28 12:02:11.721000','2025-05-28 12:02:11.721000','Piegamenti delle braccia con bilanciere','Curl con bilanciere',20),(20,'2025-05-28 12:02:11.736000','2025-05-28 12:02:11.736000','Curl con presa neutra','Hammer curl',20),(21,'2025-05-28 12:02:11.752000','2025-05-28 12:02:11.752000','Estensioni del bilanciere dietro la testa','French press',11),(22,'2025-05-28 12:02:11.767000','2025-05-28 12:02:11.767000','Macchina per dip assistiti','Dip machine',11),(23,'2025-05-28 12:02:11.781000','2025-05-28 12:02:11.781000','Curl per avambracci','Wrist curl',4),(24,'2025-05-28 12:02:11.794000','2025-05-28 12:02:11.794000','Piegamenti del busto da supini','Crunch',34),(25,'2025-05-28 12:02:11.807000','2025-05-28 12:02:11.807000','Rotazioni del busto con peso','Russian twist',35),(26,'2025-05-28 12:02:11.820000','2025-05-28 12:02:11.820000','Estensioni del busto per la zona lombare','Hyperextension',10),(27,'2025-05-28 12:02:11.834000','2025-05-28 12:02:11.834000','Tenuta isometrica in posizione di push-up','Plank',34),(28,'2025-05-28 12:02:11.849000','2025-05-28 12:02:11.849000','Piegamento delle gambe con bilanciere','Squat',26),(29,'2025-05-28 12:02:11.864000','2025-05-28 12:02:11.864000','Spinta del carico con le gambe','Leg press',26),(30,'2025-05-28 12:02:11.880000','2025-05-28 12:02:11.880000','Piegamenti delle gambe alla macchina','Leg curl',45),(31,'2025-05-28 12:02:11.894000','2025-05-28 12:02:11.894000','Spinta del bacino con bilanciere','Hip thrust',49),(32,'2025-05-28 12:02:11.910000','2025-05-28 12:02:11.910000','Sollevamenti sulle punte','Calf raise',43),(33,'2025-05-28 12:02:11.925000','2025-05-28 12:02:11.925000','Estensioni delle gambe alla macchina','Leg extension',26),(34,'2025-05-28 12:02:11.939000','2025-05-28 12:02:11.939000','Squat su una gamba sola','Bulgarian split squat',26),(35,'2025-05-28 12:02:11.957000','2025-05-28 12:02:11.957000','Macchina per adduttori','Adductor machine',44),(36,'2025-05-28 12:02:11.972000','2025-05-28 12:02:11.972000','Macchina per abduttori','Abductor machine',41),(43,'2025-05-28 12:43:53.805000','2025-05-28 14:54:57.167000','Classic push-up exercise','Push-ups',3),(48,'2025-05-28 16:07:00.007000','2025-05-28 16:07:22.143000','Classic push-up exercise','Push-ups 2',3),(49,'2025-06-17 10:50:08.830000','2025-06-17 10:50:08.830000','Distesi su una panca, sollevare il bilanciere dal rack fino a distendere completamente le braccia','Panca piana',37);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_app`
--

DROP TABLE IF EXISTS `user_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_app` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Utente dell app. Può creare uno o più piani di allenamento.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_app`
--

LOCK TABLES `user_app` WRITE;
/*!40000 ALTER TABLE `user_app` DISABLE KEYS */;
INSERT INTO `user_app` VALUES (1,'2025-05-28 12:02:11.986000','2025-05-28 12:02:11.986000','def@email.com','default','password1234');
/*!40000 ALTER TABLE `user_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_day`
--

DROP TABLE IF EXISTS `workout_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_day` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `sequence` smallint NOT NULL,
  `workout_plan_id` bigint DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsgaupql56jotq0brl5o9nlbc7` (`workout_plan_id`),
  CONSTRAINT `FKsgaupql56jotq0brl5o9nlbc7` FOREIGN KEY (`workout_plan_id`) REFERENCES `workout_plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Un esercizio svolto in un certo giorno. Contiene set, ripetizioni e note.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_day`
--

LOCK TABLES `workout_day` WRITE;
/*!40000 ALTER TABLE `workout_day` DISABLE KEYS */;
INSERT INTO `workout_day` VALUES (17,'2025-06-14 12:14:31.556000','2025-06-14 12:14:31.556000',1,12,'Petto e bicipiti'),(18,'2025-06-14 12:14:31.562000','2025-06-14 21:00:22.970000',2,12,'Gambe'),(19,'2025-06-14 12:14:31.565000','2025-06-14 21:00:44.036000',3,12,'Dorso e tricpiti'),(20,'2025-06-14 21:01:25.368000','2025-06-14 21:01:25.368000',4,12,'Deltoidi');
/*!40000 ALTER TABLE `workout_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_day_exercise`
--

DROP TABLE IF EXISTS `workout_day_exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_day_exercise` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `reps` int NOT NULL,
  `sequence` smallint NOT NULL,
  `sets` int NOT NULL,
  `exercise_id` bigint DEFAULT NULL,
  `workout_day_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKthv2jcvlt1e94dbw8hr3dowp5` (`exercise_id`),
  KEY `FK1dtoyri5qpv53sushiuvbkcgk` (`workout_day_id`),
  CONSTRAINT `FK1dtoyri5qpv53sushiuvbkcgk` FOREIGN KEY (`workout_day_id`) REFERENCES `workout_day` (`id`),
  CONSTRAINT `FKthv2jcvlt1e94dbw8hr3dowp5` FOREIGN KEY (`exercise_id`) REFERENCES `exercise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Un esercizio svolto in un certo giorno. Contiene set, ripetizioni e note.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_day_exercise`
--

LOCK TABLES `workout_day_exercise` WRITE;
/*!40000 ALTER TABLE `workout_day_exercise` DISABLE KEYS */;
INSERT INTO `workout_day_exercise` VALUES (14,'2025-06-14 12:16:24.211000','2025-06-14 13:12:24.245000','Carico Moderato',10,1,8,2,17),(17,'2025-06-14 12:19:10.690000','2025-06-14 12:19:10.690000','Riscaldamento leggero',10,1,4,10,19),(18,'2025-06-14 12:19:10.698000','2025-06-14 12:19:10.698000','Carico moderato',12,2,3,11,19),(19,'2025-06-14 13:11:40.155000','2025-06-14 13:12:44.550000','scialla',10,2,4,1,17),(20,'2025-06-14 21:17:56.285000','2025-06-14 21:18:23.456000',NULL,10,3,5,2,17);
/*!40000 ALTER TABLE `workout_day_exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_plan`
--

DROP TABLE IF EXISTS `workout_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_plan` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_built_from_user` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhvhnginrv0gep8807ds6vfqk3` (`user_id`),
  CONSTRAINT `FKhvhnginrv0gep8807ds6vfqk3` FOREIGN KEY (`user_id`) REFERENCES `user_app` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Scheda di allenamento dell utente. Contiene i giorni e gli esercizi.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_plan`
--

LOCK TABLES `workout_plan` WRITE;
/*!40000 ALTER TABLE `workout_plan` DISABLE KEYS */;
INSERT INTO `workout_plan` VALUES (12,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano massa muscolare',1,'2025-09-14','2025-06-14',_binary '',_binary ''),(13,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano B',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(14,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(15,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(16,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(17,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(18,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(19,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(20,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(21,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(22,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(23,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(24,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(25,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(26,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0'),(27,'2025-06-14 12:14:05.993000','2025-06-14 18:40:02.618000','Piano C',1,'2025-09-14','2025-06-14',_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `workout_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gymbro'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-17 12:55:26
