/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.11-MariaDB : Database - spare
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spare` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spare`;

/*Table structure for table `oauth_access_token` */

DROP TABLE IF EXISTS `oauth_access_token`;

CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob DEFAULT NULL,
  `authentication_id` varchar(256) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob DEFAULT NULL,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_access_token` */

/*Table structure for table `oauth_approvals` */

DROP TABLE IF EXISTS `oauth_approvals`;

CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NULL DEFAULT NULL,
  `lastModifiedAt` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_approvals` */

/*Table structure for table `oauth_client_details` */

DROP TABLE IF EXISTS `oauth_client_details`;

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_client_details` */

/*Table structure for table `oauth_client_token` */

DROP TABLE IF EXISTS `oauth_client_token`;

CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob DEFAULT NULL,
  `authentication_id` varchar(256) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_client_token` */

/*Table structure for table `oauth_code` */

DROP TABLE IF EXISTS `oauth_code`;

CREATE TABLE `oauth_code` (
  `CODE` varchar(256) DEFAULT NULL,
  `authentication` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_code` */

/*Table structure for table `oauth_refresh_token` */

DROP TABLE IF EXISTS `oauth_refresh_token`;

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob DEFAULT NULL,
  `authentication` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_refresh_token` */

/*Table structure for table `render_counter` */

DROP TABLE IF EXISTS `render_counter`;

CREATE TABLE `render_counter` (
  `id` int(15) NOT NULL AUTO_INCREMENT COMMENT '??????',
  `logo` varchar(64) NOT NULL COMMENT '??????',
  `count` varchar(10) NOT NULL COMMENT '??????',
  `name` varchar(15) NOT NULL COMMENT '??????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `render_counter` */

/*Table structure for table `v_cover` */

DROP TABLE IF EXISTS `v_cover`;

CREATE TABLE `v_cover` (
  `id` int(15) NOT NULL AUTO_INCREMENT COMMENT '??????',
  `name` varchar(50) NOT NULL COMMENT '?????????,
  `url` varchar(200) NOT NULL COMMENT '????????????',
  `title` varchar(80) NOT NULL COMMENT '??????',
  `animate` varchar(20) NOT NULL COMMENT '??????',
  `count` int(10) NOT NULL COMMENT '?????????',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '????????????',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '????????????',
  `deleted` int(1) DEFAULT 0 COMMENT '????????????',
  `version` int(11) DEFAULT 1 COMMENT '?????????,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `v_cover` */

/*Table structure for table `v_cover_gallery` */

DROP TABLE IF EXISTS `v_cover_gallery`;

CREATE TABLE `v_cover_gallery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????',
  `cover_id` bigint(20) NOT NULL COMMENT '??????',
  `gallery_id` bigint(20) NOT NULL COMMENT '??????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `v_cover_gallery` */

/*Table structure for table `v_gallery` */

DROP TABLE IF EXISTS `v_gallery`;

CREATE TABLE `v_gallery` (
  `id` int(15) NOT NULL AUTO_INCREMENT COMMENT '??????',
  `url` varchar(160) NOT NULL COMMENT '????????????',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '????????????',
  `update_time` datetime DEFAULT current_timestamp() COMMENT '????????????',
  `deleted` int(1) DEFAULT 0 COMMENT '????????????',
  `version` int(11) DEFAULT 1 COMMENT '?????????,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `v_gallery` */

/*Table structure for table `v_music` */

DROP TABLE IF EXISTS `v_music`;

CREATE TABLE `v_music` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '??????',
  `name` varchar(45) NOT NULL COMMENT '?????????,
  `artist` varchar(35) NOT NULL COMMENT '??????',
  `cover` varchar(80) NOT NULL COMMENT '????????????',
  `source` varchar(100) NOT NULL COMMENT '????????????',
  `url` varchar(64) NOT NULL COMMENT '?????????,
  `created` datetime DEFAULT current_timestamp(),
  `updated` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `v_music` */

/*Table structure for table `v_permission` */

DROP TABLE IF EXISTS `v_permission`;

CREATE TABLE `v_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prarent_id` bigint(20) DEFAULT NULL COMMENT '?????????,
  `name` varchar(64) NOT NULL COMMENT '?????????,
  `enable_name` varchar(64) NOT NULL COMMENT '???????????????,
  `url` varchar(255) NOT NULL COMMENT '????????????',
  `description` varchar(200) DEFAULT NULL COMMENT '??????',
  `created` datetime DEFAULT current_timestamp(),
  `updated` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `v_permission` */

/*Table structure for table `v_role` */

DROP TABLE IF EXISTS `v_role`;

CREATE TABLE `v_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '?????????,
  `NAME` varchar(64) NOT NULL COMMENT '?????????,
  `enable_name` varchar(64) NOT NULL COMMENT '???????????????,
  `url` varchar(255) NOT NULL COMMENT '????????????',
  `description` varchar(200) DEFAULT NULL COMMENT '??????',
  `created` datetime DEFAULT current_timestamp(),
  `updated` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `v_role` */

/*Table structure for table `v_role_permission` */

DROP TABLE IF EXISTS `v_role_permission`;

CREATE TABLE `v_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `v_role_permission` */

/*Table structure for table `v_user` */

DROP TABLE IF EXISTS `v_user`;

CREATE TABLE `v_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????',
  `username` varchar(50) NOT NULL COMMENT '?????????,
  `password` varchar(64) NOT NULL COMMENT '????????????',
  `client_id` varchar(64) NOT NULL,
  `phone` varchar(20) NOT NULL COMMENT '?????????,
  `email` varchar(50) DEFAULT NULL COMMENT '??????',
  `created` datetime DEFAULT current_timestamp(),
  `updated` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `v_user` */

/*Table structure for table `v_user_cover` */

DROP TABLE IF EXISTS `v_user_cover`;

CREATE TABLE `v_user_cover` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????',
  `user_id` bigint(20) NOT NULL COMMENT '??????',
  `cover_id` bigint(20) NOT NULL COMMENT '??????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `v_user_cover` */

/*Table structure for table `v_user_music` */

DROP TABLE IF EXISTS `v_user_music`;

CREATE TABLE `v_user_music` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????',
  `user_id` varchar(50) NOT NULL COMMENT '??????',
  `music_id` varchar(50) NOT NULL COMMENT '??????',
  `favorited` tinyint(1) DEFAULT 0 COMMENT '??????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `v_user_music` */

/*Table structure for table `v_user_role` */

DROP TABLE IF EXISTS `v_user_role`;

CREATE TABLE `v_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `v_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
