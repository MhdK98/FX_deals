-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.24 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for fx_deals
CREATE DATABASE IF NOT EXISTS `fx_deals` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fx_deals`;

-- Dumping structure for table fx_deals.fx_currencies
CREATE TABLE IF NOT EXISTS `fx_currencies` (
  `currency_id` int(11) NOT NULL AUTO_INCREMENT,
  `currency_desc` varchar(10) NOT NULL,
  `currency_value` double NOT NULL,
  PRIMARY KEY (`currency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table fx_deals.fx_currencies: ~4 rows (approximately)
/*!40000 ALTER TABLE `fx_currencies` DISABLE KEYS */;
INSERT INTO `fx_currencies` (`currency_id`, `currency_desc`, `currency_value`) VALUES
	(1, 'JOD', 1.3),
	(2, 'USD', 1),
	(3, 'EUR', 1.1),
	(4, 'AED', 0.27);
/*!40000 ALTER TABLE `fx_currencies` ENABLE KEYS */;

-- Dumping structure for table fx_deals.fx_deals
CREATE TABLE IF NOT EXISTS `fx_deals` (
  `deal_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `from_curr` int(11) NOT NULL,
  `to_curr` int(11) NOT NULL,
  `deal_time` datetime NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`deal_id`),
  KEY `fx_deals_ibfk_1` (`user_id`),
  KEY `fx_deals_ibfk_2` (`from_curr`),
  KEY `fx_deals_ibfk_3` (`to_curr`),
  CONSTRAINT `fx_deals_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `fx_users` (`user_id`),
  CONSTRAINT `fx_deals_ibfk_2` FOREIGN KEY (`from_curr`) REFERENCES `fx_currencies` (`currency_id`),
  CONSTRAINT `fx_deals_ibfk_3` FOREIGN KEY (`to_curr`) REFERENCES `fx_currencies` (`currency_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table fx_deals.fx_deals: ~0 rows (approximately)
/*!40000 ALTER TABLE `fx_deals` DISABLE KEYS */;
/*!40000 ALTER TABLE `fx_deals` ENABLE KEYS */;

-- Dumping structure for view fx_deals.fx_deals_view
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `fx_deals_view` (
	`deal_id` INT(11) NOT NULL,
	`user_id` INT(11) NOT NULL,
	`from_curr` INT(11) NOT NULL,
	`to_curr` INT(11) NOT NULL,
	`deal_time` DATETIME NOT NULL,
	`amount` DOUBLE NOT NULL,
	`user_name` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`fromISO` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	`toISO` VARCHAR(255) NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;

-- Dumping structure for table fx_deals.fx_users
CREATE TABLE IF NOT EXISTS `fx_users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_pass` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table fx_deals.fx_users: ~1 rows (approximately)
/*!40000 ALTER TABLE `fx_users` DISABLE KEYS */;
INSERT INTO `fx_users` (`user_id`, `user_name`, `user_pass`) VALUES
	(1, 'test_user', '123');
/*!40000 ALTER TABLE `fx_users` ENABLE KEYS */;

-- Dumping structure for function fx_deals.get_currency_ISO
DELIMITER //
CREATE FUNCTION `get_currency_ISO`(p_curr_id int(11)) RETURNS varchar(255) CHARSET utf8
BEGIN

    DECLARE v_curr_desc varchar(100) CHARSET utf8 DEFAULT "";
      SET v_curr_desc = NULL;

	select currency_desc into v_curr_desc from fx_currencies where currency_id=p_curr_id;
	RETURN v_curr_desc;
END//
DELIMITER ;

-- Dumping structure for view fx_deals.fx_deals_view
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `fx_deals_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `fx_deals_view` AS select `deal`.`deal_id` AS `deal_id`,`deal`.`user_id` AS `user_id`,`deal`.`from_curr` AS `from_curr`,`deal`.`to_curr` AS `to_curr`,`deal`.`deal_time` AS `deal_time`,`deal`.`amount` AS `amount`,`u`.`user_name` AS `user_name`,`get_currency_ISO`(`deal`.`from_curr`) AS `fromISO`,`get_currency_ISO`(`deal`.`to_curr`) AS `toISO` from (`fx_deals` `deal` join `fx_users` `u`) where (`deal`.`deal_id` = `u`.`user_id`);

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
