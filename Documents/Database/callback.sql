/*
Navicat MySQL Data Transfer

Source Server         : main
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : callback

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2016-05-25 00:37:48
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `button`
-- ----------------------------
DROP TABLE IF EXISTS `button`;
CREATE TABLE `button` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `color` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `domen` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of button
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'demo@localhost', '$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C', 'ADMIN');
INSERT INTO `user` VALUES ('2', 'fff@jj', '$2a$10$C2NcmG7NQ59Bm.A4Blm7p.DmiTb3Cxk8TPSCRYWb1YSDPaH4xdeoG', 'USER');
INSERT INTO `user` VALUES ('3', 'a@a', '$2a$10$Ix1OHJtb.HKGPQFBoN.5KexuV5TqzvKsvpU.GJZZPwsAUok6hvmMi', 'USER');
INSERT INTO `user` VALUES ('4', 'aa@a', '$2a$10$iGP4RlO8vbY.BVwlYLeqYOESR5rRs6KYT5hpOnkq0AcQ4pGTI.AFa', 'USER');
