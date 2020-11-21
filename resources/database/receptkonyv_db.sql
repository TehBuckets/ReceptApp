-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.11-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for receptkonyv_db
CREATE DATABASE IF NOT EXISTS `receptkonyv_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `receptkonyv_db`;

-- Dumping structure for table receptkonyv_db.elkeszites
CREATE TABLE IF NOT EXISTS `elkeszites` (
  `elkeszites_id` int(11) NOT NULL AUTO_INCREMENT,
  `recept_id` int(11) DEFAULT NULL,
  `elkeszites_sorszam` tinyint(4) DEFAULT NULL,
  `elkeszites_leiras` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`elkeszites_id`),
  KEY `recept_id` (`recept_id`),
  CONSTRAINT `elkeszites_ibfk_1` FOREIGN KEY (`recept_id`) REFERENCES `recept` (`recept_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table receptkonyv_db.elkeszites: ~3 rows (approximately)
/*!40000 ALTER TABLE `elkeszites` DISABLE KEYS */;
REPLACE INTO `elkeszites` (`elkeszites_id`, `recept_id`, `elkeszites_sorszam`, `elkeszites_leiras`) VALUES
	(1, 1, 1, 'Teszt leiras'),
	(2, 2, 1, 'Teszt leiras #1'),
	(3, 2, 2, 'Teszt leiras #2');
/*!40000 ALTER TABLE `elkeszites` ENABLE KEYS */;

-- Dumping structure for table receptkonyv_db.fogas
CREATE TABLE IF NOT EXISTS `fogas` (
  `fogas_id` int(11) NOT NULL AUTO_INCREMENT,
  `fogas_nev` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`fogas_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table receptkonyv_db.fogas: ~2 rows (approximately)
/*!40000 ALTER TABLE `fogas` DISABLE KEYS */;
REPLACE INTO `fogas` (`fogas_id`, `fogas_nev`) VALUES
	(1, 'Teszt fogas #1'),
	(2, 'Teszt fogas #2');
/*!40000 ALTER TABLE `fogas` ENABLE KEYS */;

-- Dumping structure for table receptkonyv_db.hozzavalo
CREATE TABLE IF NOT EXISTS `hozzavalo` (
  `hozzavalo_id` int(11) NOT NULL AUTO_INCREMENT,
  `hozzavalo_nev` varchar(100) NOT NULL,
  `hozzavalo_egyseg` varchar(20) NOT NULL,
  PRIMARY KEY (`hozzavalo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table receptkonyv_db.hozzavalo: ~2 rows (approximately)
/*!40000 ALTER TABLE `hozzavalo` DISABLE KEYS */;
REPLACE INTO `hozzavalo` (`hozzavalo_id`, `hozzavalo_nev`, `hozzavalo_egyseg`) VALUES
	(1, 'Teszt hozzavalo #1', 'darab'),
	(2, 'Teszt hozzavalo #2', 'liter');
/*!40000 ALTER TABLE `hozzavalo` ENABLE KEYS */;

-- Dumping structure for table receptkonyv_db.recept
CREATE TABLE IF NOT EXISTS `recept` (
  `recept_id` int(11) NOT NULL AUTO_INCREMENT,
  `recept_nev` varchar(100) NOT NULL,
  `recept_elkeszitesi_ido` smallint(6) DEFAULT NULL,
  `recept_vegetarianus` tinyint(1) DEFAULT NULL,
  `fogas_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`recept_id`),
  KEY `fogas_id` (`fogas_id`),
  CONSTRAINT `recept_ibfk_1` FOREIGN KEY (`fogas_id`) REFERENCES `fogas` (`fogas_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table receptkonyv_db.recept: ~1 rows (approximately)
/*!40000 ALTER TABLE `recept` DISABLE KEYS */;
REPLACE INTO `recept` (`recept_id`, `recept_nev`, `recept_elkeszitesi_ido`, `recept_vegetarianus`, `fogas_id`) VALUES
	(1, 'Teszt recept #1', 30, 1, 1),
	(2, 'Teszt recept #2', 60, 0, 2);
/*!40000 ALTER TABLE `recept` ENABLE KEYS */;

-- Dumping structure for table receptkonyv_db.recepthozzavalo
CREATE TABLE IF NOT EXISTS `recepthozzavalo` (
  `recept_id` int(11) NOT NULL,
  `hozzavalo_id` int(11) NOT NULL,
  `mennyiseg` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`recept_id`,`hozzavalo_id`),
  KEY `hozzavalo_id` (`hozzavalo_id`),
  CONSTRAINT `recepthozzavalo_ibfk_1` FOREIGN KEY (`recept_id`) REFERENCES `recept` (`recept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recepthozzavalo_ibfk_2` FOREIGN KEY (`hozzavalo_id`) REFERENCES `hozzavalo` (`hozzavalo_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table receptkonyv_db.recepthozzavalo: ~3 rows (approximately)
/*!40000 ALTER TABLE `recepthozzavalo` DISABLE KEYS */;
REPLACE INTO `recepthozzavalo` (`recept_id`, `hozzavalo_id`, `mennyiseg`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(2, 2, 5);
/*!40000 ALTER TABLE `recepthozzavalo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
