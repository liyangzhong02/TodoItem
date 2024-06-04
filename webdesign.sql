/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : webdesign

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 02/06/2024 13:58:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for todo_item
-- ----------------------------
DROP TABLE IF EXISTS `todo_item`;
CREATE TABLE `todo_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  `completed` tinyint(1) NULL DEFAULT 0,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `priority` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_name`(`name`) USING BTREE,
  CONSTRAINT `todo_item_ibfk_1` FOREIGN KEY (`name`) REFERENCES `user` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of todo_item
-- ----------------------------
INSERT INTO `todo_item` VALUES (4, 'testtest', '', 0, 'test01', 1);
INSERT INTO `todo_item` VALUES (14, 'testLow', '', 0, 'admin', 3);
INSERT INTO `todo_item` VALUES (15, 'testHigh', '', 0, 'admin', 1);
INSERT INTO `todo_item` VALUES (16, 'testMid', '', 0, 'admin', 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `Unique`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123');
INSERT INTO `user` VALUES (2, 'test01', '123');
INSERT INTO `user` VALUES (3, 'xys', '123');

SET FOREIGN_KEY_CHECKS = 1;
