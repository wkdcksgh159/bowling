-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.4.6-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- bowling 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `bowling` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bowling`;

-- 테이블 bowling.admin 구조 내보내기
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` varchar(50) NOT NULL,
  `admin_pw` varchar(50) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.admin:~0 rows (대략적) 내보내기
DELETE FROM `admin`;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- 테이블 bowling.ball 구조 내보내기
CREATE TABLE IF NOT EXISTS `ball` (
  `pound` int(11) NOT NULL,
  PRIMARY KEY (`pound`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.ball:~0 rows (대략적) 내보내기
DELETE FROM `ball`;
/*!40000 ALTER TABLE `ball` DISABLE KEYS */;
/*!40000 ALTER TABLE `ball` ENABLE KEYS */;

-- 테이블 bowling.captain 구조 내보내기
CREATE TABLE IF NOT EXISTS `captain` (
  `team_name` varchar(50) NOT NULL,
  `captain_start` date NOT NULL,
  `captain_end` date NOT NULL,
  `player_no` int(11) NOT NULL,
  PRIMARY KEY (`team_name`),
  KEY `FK_captain_player` (`player_no`),
  CONSTRAINT `FK_captain_player` FOREIGN KEY (`player_no`) REFERENCES `team_player_contract` (`player_no`),
  CONSTRAINT `FK_captain_team` FOREIGN KEY (`team_name`) REFERENCES `team_player_contract` (`team_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.captain:~0 rows (대략적) 내보내기
DELETE FROM `captain`;
/*!40000 ALTER TABLE `captain` DISABLE KEYS */;
/*!40000 ALTER TABLE `captain` ENABLE KEYS */;

-- 테이블 bowling.country 구조 내보내기
CREATE TABLE IF NOT EXISTS `country` (
  `country_name` varchar(50) NOT NULL,
  PRIMARY KEY (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.country:~2 rows (대략적) 내보내기
DELETE FROM `country`;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`country_name`) VALUES
	('나이지리아'),
	('대한민국');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;

-- 테이블 bowling.game 구조 내보내기
CREATE TABLE IF NOT EXISTS `game` (
  `game_no` int(11) NOT NULL,
  `hteam_name` varchar(50) NOT NULL,
  `stadium_name` varchar(50) NOT NULL,
  `ateam_name` varchar(50) NOT NULL,
  `game_date` date NOT NULL,
  PRIMARY KEY (`game_no`),
  KEY `FK_game_stadium` (`stadium_name`),
  KEY `FK_game_team` (`hteam_name`),
  KEY `FK_game_team_2` (`ateam_name`),
  CONSTRAINT `FK_game_stadium` FOREIGN KEY (`stadium_name`) REFERENCES `team` (`stadium_name`),
  CONSTRAINT `FK_game_team` FOREIGN KEY (`hteam_name`) REFERENCES `team_player_contract` (`team_name`),
  CONSTRAINT `FK_game_team_2` FOREIGN KEY (`ateam_name`) REFERENCES `team_player_contract` (`team_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.game:~0 rows (대략적) 내보내기
DELETE FROM `game`;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` (`game_no`, `hteam_name`, `stadium_name`, `ateam_name`, `game_date`) VALUES
	(1, '롯데', '서울볼링장', '두산', '2019-12-02');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;

-- 테이블 bowling.game_player 구조 내보내기
CREATE TABLE IF NOT EXISTS `game_player` (
  `game_no` int(11) NOT NULL,
  `player_no` int(11) NOT NULL,
  `frame` int(11) NOT NULL,
  `try` int(11) NOT NULL,
  `pin` int(11) NOT NULL,
  KEY `FK_game_player_game` (`game_no`),
  KEY `FK_game_player_player` (`player_no`),
  CONSTRAINT `FK_game_player_game` FOREIGN KEY (`game_no`) REFERENCES `game` (`game_no`),
  CONSTRAINT `FK_game_player_player` FOREIGN KEY (`player_no`) REFERENCES `team_player_contract` (`player_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.game_player:~0 rows (대략적) 내보내기
DELETE FROM `game_player`;
/*!40000 ALTER TABLE `game_player` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_player` ENABLE KEYS */;

-- 테이블 bowling.game_refree 구조 내보내기
CREATE TABLE IF NOT EXISTS `game_refree` (
  `game_no` int(11) NOT NULL,
  `referee_no` int(11) NOT NULL,
  KEY `FK_gamerefree_game` (`game_no`),
  KEY `FK_gamerefree_referee` (`referee_no`),
  CONSTRAINT `FK_gamerefree_game` FOREIGN KEY (`game_no`) REFERENCES `game` (`game_no`),
  CONSTRAINT `FK_gamerefree_referee` FOREIGN KEY (`referee_no`) REFERENCES `referee` (`referee_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.game_refree:~0 rows (대략적) 내보내기
DELETE FROM `game_refree`;
/*!40000 ALTER TABLE `game_refree` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_refree` ENABLE KEYS */;

-- 테이블 bowling.game_result 구조 내보내기
CREATE TABLE IF NOT EXISTS `game_result` (
  `game_no` int(11) NOT NULL,
  `hteam_name` varchar(50) NOT NULL,
  `hteam_score` int(11) NOT NULL,
  `hteam_result` enum('win','lose','draw') NOT NULL,
  `ateam_result` enum('win','lose','draw') NOT NULL,
  `ateam_score` int(11) NOT NULL,
  `ateam_name` varchar(50) NOT NULL,
  KEY `FK_gameresult_game_2` (`hteam_name`),
  KEY `FK_gameresult_game_3` (`ateam_name`),
  KEY `FK_gameresult_game` (`game_no`),
  CONSTRAINT `FK_gameresult_game` FOREIGN KEY (`game_no`) REFERENCES `game_player` (`game_no`),
  CONSTRAINT `FK_gameresult_game_2` FOREIGN KEY (`hteam_name`) REFERENCES `game` (`hteam_name`),
  CONSTRAINT `FK_gameresult_game_3` FOREIGN KEY (`ateam_name`) REFERENCES `game` (`ateam_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.game_result:~0 rows (대략적) 내보내기
DELETE FROM `game_result`;
/*!40000 ALTER TABLE `game_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_result` ENABLE KEYS */;

-- 테이블 bowling.grap_type 구조 내보내기
CREATE TABLE IF NOT EXISTS `grap_type` (
  `grab` int(11) NOT NULL,
  PRIMARY KEY (`grab`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.grap_type:~0 rows (대략적) 내보내기
DELETE FROM `grap_type`;
/*!40000 ALTER TABLE `grap_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `grap_type` ENABLE KEYS */;

-- 테이블 bowling.img 구조 내보내기
CREATE TABLE IF NOT EXISTS `img` (
  `player_no` int(11) NOT NULL,
  `img_name` varchar(50) NOT NULL,
  `extenstion` varchar(50) NOT NULL,
  `content_type` varchar(50) NOT NULL,
  `size` bigint(20) NOT NULL,
  `origin_name` varchar(50) NOT NULL,
  PRIMARY KEY (`player_no`),
  CONSTRAINT `FK_img_player` FOREIGN KEY (`player_no`) REFERENCES `player` (`player_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.img:~0 rows (대략적) 내보내기
DELETE FROM `img`;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
/*!40000 ALTER TABLE `img` ENABLE KEYS */;

-- 테이블 bowling.manager 구조 내보내기
CREATE TABLE IF NOT EXISTS `manager` (
  `manager_no` int(11) NOT NULL,
  `manager_name` varchar(50) NOT NULL,
  `manager_age` int(11) NOT NULL,
  PRIMARY KEY (`manager_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.manager:~0 rows (대략적) 내보내기
DELETE FROM `manager`;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;

-- 테이블 bowling.manager_team 구조 내보내기
CREATE TABLE IF NOT EXISTS `manager_team` (
  `manager_no` int(11) NOT NULL,
  `team_name` varchar(50) NOT NULL,
  KEY `FK_managerteam_manager` (`manager_no`),
  KEY `FK_managerteam_team` (`team_name`),
  CONSTRAINT `FK_managerteam_manager` FOREIGN KEY (`manager_no`) REFERENCES `manager` (`manager_no`),
  CONSTRAINT `FK_managerteam_team` FOREIGN KEY (`team_name`) REFERENCES `team` (`team_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.manager_team:~0 rows (대략적) 내보내기
DELETE FROM `manager_team`;
/*!40000 ALTER TABLE `manager_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager_team` ENABLE KEYS */;

-- 테이블 bowling.news 구조 내보내기
CREATE TABLE IF NOT EXISTS `news` (
  `news_no` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(50) NOT NULL,
  `news_title` varchar(50) NOT NULL,
  `news_content` varchar(50) NOT NULL,
  PRIMARY KEY (`news_no`),
  KEY `FK_news_admin` (`admin_id`),
  CONSTRAINT `FK_news_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.news:~0 rows (대략적) 내보내기
DELETE FROM `news`;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- 테이블 bowling.player 구조 내보내기
CREATE TABLE IF NOT EXISTS `player` (
  `player_no` int(11) NOT NULL,
  `player_name` varchar(50) NOT NULL,
  `player_contry` varchar(50) NOT NULL,
  `player_age` int(11) NOT NULL,
  `player_gender` enum('M','F') NOT NULL,
  `player_hand` enum('L','R') NOT NULL,
  PRIMARY KEY (`player_no`),
  KEY `FK_player_country` (`player_contry`),
  CONSTRAINT `FK_player_country` FOREIGN KEY (`player_contry`) REFERENCES `country` (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.player:~2 rows (대략적) 내보내기
DELETE FROM `player`;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` (`player_no`, `player_name`, `player_contry`, `player_age`, `player_gender`, `player_hand`) VALUES
	(1, '장찬호스', '나이지리아', 53, 'F', 'L'),
	(2, '이정연', '대한민국', 43, 'F', 'L');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;

-- 테이블 bowling.player_ball 구조 내보내기
CREATE TABLE IF NOT EXISTS `player_ball` (
  `player_no` int(11) NOT NULL,
  `pound` int(11) NOT NULL,
  KEY `FK_playerball_player` (`player_no`),
  KEY `FK_playerball_ball` (`pound`),
  CONSTRAINT `FK_playerball_ball` FOREIGN KEY (`pound`) REFERENCES `ball` (`pound`),
  CONSTRAINT `FK_playerball_player` FOREIGN KEY (`player_no`) REFERENCES `player` (`player_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.player_ball:~0 rows (대략적) 내보내기
DELETE FROM `player_ball`;
/*!40000 ALTER TABLE `player_ball` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_ball` ENABLE KEYS */;

-- 테이블 bowling.player_grab 구조 내보내기
CREATE TABLE IF NOT EXISTS `player_grab` (
  `player_no` int(11) NOT NULL,
  `grab` int(11) NOT NULL,
  KEY `FK_playergrab_player` (`player_no`),
  KEY `FK_playergrab_graptype` (`grab`),
  CONSTRAINT `FK_playergrab_graptype` FOREIGN KEY (`grab`) REFERENCES `grap_type` (`grab`),
  CONSTRAINT `FK_playergrab_player` FOREIGN KEY (`player_no`) REFERENCES `player` (`player_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.player_grab:~0 rows (대략적) 내보내기
DELETE FROM `player_grab`;
/*!40000 ALTER TABLE `player_grab` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_grab` ENABLE KEYS */;

-- 테이블 bowling.referee 구조 내보내기
CREATE TABLE IF NOT EXISTS `referee` (
  `referee_no` int(11) NOT NULL,
  `referee_contry` varchar(50) NOT NULL,
  `referee_name` varchar(50) NOT NULL,
  `referee_age` int(11) NOT NULL,
  `refree_gender` enum('M','F') NOT NULL,
  PRIMARY KEY (`referee_no`),
  KEY `FK_referee_country` (`referee_contry`),
  CONSTRAINT `FK_referee_country` FOREIGN KEY (`referee_contry`) REFERENCES `country` (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.referee:~0 rows (대략적) 내보내기
DELETE FROM `referee`;
/*!40000 ALTER TABLE `referee` DISABLE KEYS */;
/*!40000 ALTER TABLE `referee` ENABLE KEYS */;

-- 테이블 bowling.stadium 구조 내보내기
CREATE TABLE IF NOT EXISTS `stadium` (
  `stadium_name` varchar(50) NOT NULL,
  `stadium_location` varchar(50) NOT NULL,
  PRIMARY KEY (`stadium_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.stadium:~2 rows (대략적) 내보내기
DELETE FROM `stadium`;
/*!40000 ALTER TABLE `stadium` DISABLE KEYS */;
INSERT INTO `stadium` (`stadium_name`, `stadium_location`) VALUES
	('서울볼링장', '서울'),
	('아프리카볼링장', '나이지리아');
/*!40000 ALTER TABLE `stadium` ENABLE KEYS */;

-- 테이블 bowling.team 구조 내보내기
CREATE TABLE IF NOT EXISTS `team` (
  `team_name` varchar(50) NOT NULL,
  `stadium_name` varchar(50) NOT NULL,
  `to_date` date NOT NULL,
  PRIMARY KEY (`team_name`),
  KEY `FK_team_stadium` (`stadium_name`),
  CONSTRAINT `FK_team_stadium` FOREIGN KEY (`stadium_name`) REFERENCES `stadium` (`stadium_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.team:~2 rows (대략적) 내보내기
DELETE FROM `team`;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` (`team_name`, `stadium_name`, `to_date`) VALUES
	('두산', '서울볼링장', '2019-12-02'),
	('롯데', '아프리카볼링장', '2019-12-02');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;

-- 테이블 bowling.team_manager 구조 내보내기
CREATE TABLE IF NOT EXISTS `team_manager` (
  `manager_no` int(11) NOT NULL,
  `team_name` varchar(50) NOT NULL,
  `manager_name` varchar(50) NOT NULL,
  `manager_age` int(11) NOT NULL,
  KEY `FK_teammanager_manager` (`manager_no`),
  KEY `FK_teammanager_team` (`team_name`),
  CONSTRAINT `FK_teammanager_manager` FOREIGN KEY (`manager_no`) REFERENCES `manager` (`manager_no`),
  CONSTRAINT `FK_teammanager_team` FOREIGN KEY (`team_name`) REFERENCES `team` (`team_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.team_manager:~0 rows (대략적) 내보내기
DELETE FROM `team_manager`;
/*!40000 ALTER TABLE `team_manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_manager` ENABLE KEYS */;

-- 테이블 bowling.team_player_contract 구조 내보내기
CREATE TABLE IF NOT EXISTS `team_player_contract` (
  `team_name` varchar(50) NOT NULL,
  `player_no` int(11) NOT NULL,
  `contract_start` date NOT NULL,
  `contract_end` date NOT NULL,
  `salary` int(11) NOT NULL,
  `transferfee` int(11) NOT NULL,
  KEY `FK_teamplayercontract_team` (`team_name`),
  KEY `FK_teamplayercontract_player` (`player_no`),
  CONSTRAINT `FK_teamplayercontract_player` FOREIGN KEY (`player_no`) REFERENCES `player` (`player_no`),
  CONSTRAINT `FK_teamplayercontract_team` FOREIGN KEY (`team_name`) REFERENCES `team` (`team_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 bowling.team_player_contract:~2 rows (대략적) 내보내기
DELETE FROM `team_player_contract`;
/*!40000 ALTER TABLE `team_player_contract` DISABLE KEYS */;
INSERT INTO `team_player_contract` (`team_name`, `player_no`, `contract_start`, `contract_end`, `salary`, `transferfee`) VALUES
	('롯데', 1, '2019-12-02', '2019-12-02', 100, 1000),
	('두산', 2, '2019-12-02', '2019-12-02', 244, 30000);
/*!40000 ALTER TABLE `team_player_contract` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
