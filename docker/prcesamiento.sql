-- MySQL dump 10.13  Distrib 5.7.44, for Linux (x86_64)
--
-- Host: localhost    Database: procesamiento_sri
-- ------------------------------------------------------
-- Server version	5.7.44

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(128) NOT NULL,
  `sri_usuario` varchar(16) NOT NULL,
  `sri_credencial` varchar(256) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_programa` varchar(128) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'dveloper_catalina_usuario','0103153425001','LCAG2019','A','2024-03-28 15:52:16','manual'),(2,'dveloper_rosa_usuario','0911774198001','ROSITA1234','X','2024-03-28 15:52:54','manual'),(3,'dveloper_indupan_facturador','1715726772001','Indupan1111@','X','2024-03-28 15:53:22','manual'),(4,'dveloper_cris','0103153425001','<NO DEFINIDO>','X','2024-03-28 15:53:22','manual');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametros` (
  `id_parametro` int(11) NOT NULL AUTO_INCREMENT,
  `indice` int(11) NOT NULL,
  `nombre` varchar(128) NOT NULL,
  `descripcion` varchar(256) NOT NULL,
  `texto_a` varchar(1024) DEFAULT NULL,
  `texto_b` varchar(1024) DEFAULT NULL,
  `numero_a` double DEFAULT '-1',
  `numero_b` double DEFAULT '-1',
  `estado` varchar(8) NOT NULL,
  `usuario` varchar(128) NOT NULL DEFAULT '<NO_DEFINIDO>',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_programa` varchar(128) NOT NULL,
  PRIMARY KEY (`id_parametro`),
  UNIQUE KEY `parametros_indice_IDX` (`indice`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
INSERT INTO `parametros` VALUES (1,50,'Cliente SRI','Cliente SRI contratado campo CLIENT_ID','33nda5ed9snbl7edpgp7f3it1c',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 14:59:28','manual'),(2,51,'Cliente SRI','Cliente SRI contratado campo SECRET_ID','o0js143is9nh3rc0hdgu1uu83uluic11vvrv28h88sdh3h3nubq',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:02:35','manual'),(3,52,'Cliente SRI','Cliente SRI contratado campo GRANT_TYPE','client_credentials',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:04:12','manual'),(4,53,'Cliente SRI URL token','Cliente SRI url Token','https://auth.invoicy.app/token',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:04:12','manual'),(6,54,'Cliente SRI URL documentos_proveedores','Cliente SRI url Documentos Recibidos','https://api.invoicy.app/v1/documents',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:04:12','manual'),(7,55,'Cliente SRI URL documentos','Cliente SRI url Descarga Autorizacion','https://api.invoicy.app/v1/documents',NULL,-1,-1,'A','<NO_DEFINIDO>','2024-03-31 15:04:12','manual');
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-11  4:33:45
