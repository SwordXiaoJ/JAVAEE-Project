/*
 Navicat Premium Data Transfer

 Source Server         : JAVAEE
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 18/06/2020 16:24:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_homework
-- ----------------------------
DROP TABLE IF EXISTS `s_homework`;
CREATE TABLE `s_homework`  (
  `homework_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` timestamp(0) NOT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`homework_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55555555555555 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_homework
-- ----------------------------
INSERT INTO `s_homework` VALUES (1, '2', '4', '2020-03-10 14:28:15', '2020-03-10 14:28:15');
INSERT INTO `s_homework` VALUES (23, '33', '32', '2020-06-18 08:22:41', '2020-06-18 08:22:41');
INSERT INTO `s_homework` VALUES (123, 'JAVAEE', '提交大项目', '2020-06-18 01:55:52', '2020-06-18 01:55:52');
INSERT INTO `s_homework` VALUES (322, '啥的', '打算', '2020-06-17 14:50:42', '2020-06-17 14:50:42');
INSERT INTO `s_homework` VALUES (3223, '啥的', '打算', '2020-06-17 14:51:03', '2020-06-17 14:51:03');
INSERT INTO `s_homework` VALUES (42111, '11', '1', '2020-06-17 14:54:23', '2020-06-17 14:54:23');

-- ----------------------------
-- Table structure for s_student
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student`  (
  `student_id` bigint(0) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_student
-- ----------------------------
INSERT INTO `s_student` VALUES (1, 'XJ', '2020-03-10 16:27:44', '2020-03-10 16:27:44', '123');
INSERT INTO `s_student` VALUES (2, '22', '2020-06-16 06:17:59', '2020-06-16 06:17:59', NULL);
INSERT INTO `s_student` VALUES (23, 'XX', '2020-06-17 14:50:08', '2020-06-17 14:50:08', NULL);
INSERT INTO `s_student` VALUES (32, '32', '2020-06-18 08:22:46', '2020-06-18 08:22:46', NULL);
INSERT INTO `s_student` VALUES (33, '33', '2020-06-16 14:02:41', '2020-06-16 14:02:41', '33');
INSERT INTO `s_student` VALUES (123, '321321', '2020-06-16 06:14:35', '2020-06-16 06:14:35', NULL);
INSERT INTO `s_student` VALUES (4231, '53215', '2020-06-16 13:10:51', '2020-06-16 13:10:51', '5321');
INSERT INTO `s_student` VALUES (4324, '4zx', '2020-06-17 14:54:14', '2020-06-17 14:54:14', NULL);
INSERT INTO `s_student` VALUES (1763502, 'LEE', '2020-06-18 01:59:32', '2020-06-18 01:59:32', NULL);

-- ----------------------------
-- Table structure for s_student_homework
-- ----------------------------
DROP TABLE IF EXISTS `s_student_homework`;
CREATE TABLE `s_student_homework`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(0) NOT NULL,
  `homework_id` bigint(0) NOT NULL,
  `homework_title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `homework_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` timestamp(0) NOT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  `homework_review` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_student_homework
-- ----------------------------
INSERT INTO `s_student_homework` VALUES (2, 1, 2, '3', '4323', '2020-06-18 07:29:38', '2020-06-18 08:24:04', 'dsdds');

-- ----------------------------
-- Table structure for s_teacher
-- ----------------------------
DROP TABLE IF EXISTS `s_teacher`;
CREATE TABLE `s_teacher`  (
  `teacher_id` bigint(0) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_teacher
-- ----------------------------
INSERT INTO `s_teacher` VALUES (1, '1', '2020-06-17 00:35:18', '2020-06-17 00:35:18', '1');
INSERT INTO `s_teacher` VALUES (2, '2', '2020-06-17 09:25:23', '2020-06-17 09:25:23', '2');

SET FOREIGN_KEY_CHECKS = 1;
