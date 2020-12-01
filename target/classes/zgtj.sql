/*
 Navicat Premium Data Transfer

 Source Server         : Local-Master
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 192.168.100.110:3306
 Source Schema         : zgtj

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 05/07/2019 08:19:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hk_account_log
-- ----------------------------
DROP TABLE IF EXISTS `hk_account_log`;
CREATE TABLE `hk_account_log`  (
  `ID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户账户操作日志主键',
  `LOG_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志名称(login,register,logout)',
  `ACCOUNT_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `SUCCEED` int(1) NULL DEFAULT NULL COMMENT '是否执行成功 (-1失败 1成功)',
  `MESSAGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体消息',
  `IP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录ip',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录注册登出记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hk_account_log
-- ----------------------------
INSERT INTO `hk_account_log` VALUES (1, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-02 16:58:14');
INSERT INTO `hk_account_log` VALUES (2, 'Logout', NULL, 1, '登出成功', '0:0:0:0:0:0:0:1', '2019-07-02 16:58:28');
INSERT INTO `hk_account_log` VALUES (3, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-02 17:00:05');
INSERT INTO `hk_account_log` VALUES (4, 'Logout', 'lshengh626', 1, '登出成功', '0:0:0:0:0:0:0:1', '2019-07-02 17:00:53');
INSERT INTO `hk_account_log` VALUES (5, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-02 17:01:30');
INSERT INTO `hk_account_log` VALUES (6, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-03 08:26:17');
INSERT INTO `hk_account_log` VALUES (7, 'Logout', 'lshengh626', 1, '登出成功', '0:0:0:0:0:0:0:1', '2019-07-03 08:33:47');
INSERT INTO `hk_account_log` VALUES (8, 'Login', 'lshengh626', 1, '验证码不合法', '0:0:0:0:0:0:0:1', '2019-07-03 08:36:36');
INSERT INTO `hk_account_log` VALUES (9, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-03 08:36:41');
INSERT INTO `hk_account_log` VALUES (10, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-03 13:38:18');
INSERT INTO `hk_account_log` VALUES (11, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-03 14:33:06');
INSERT INTO `hk_account_log` VALUES (12, 'Logout', 'lshengh626', 1, '登出成功', '0:0:0:0:0:0:0:1', '2019-07-03 14:59:20');
INSERT INTO `hk_account_log` VALUES (13, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-03 14:59:24');
INSERT INTO `hk_account_log` VALUES (14, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-04 08:18:24');
INSERT INTO `hk_account_log` VALUES (15, 'Logout', 'lshengh626', 1, '登出成功', '0:0:0:0:0:0:0:1', '2019-07-04 08:44:12');
INSERT INTO `hk_account_log` VALUES (16, 'Login', 'lshengh626', 1, '验证码不合法', '0:0:0:0:0:0:0:1', '2019-07-04 08:54:55');
INSERT INTO `hk_account_log` VALUES (17, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-04 08:55:02');
INSERT INTO `hk_account_log` VALUES (18, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-04 08:58:48');
INSERT INTO `hk_account_log` VALUES (19, 'Logout', 'lshengh626', 1, '登出成功', '0:0:0:0:0:0:0:1', '2019-07-04 09:36:38');
INSERT INTO `hk_account_log` VALUES (20, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-04 09:37:27');
INSERT INTO `hk_account_log` VALUES (21, 'Logout', 'lshengh626', 1, '登出成功', '0:0:0:0:0:0:0:1', '2019-07-04 09:37:35');
INSERT INTO `hk_account_log` VALUES (22, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-04 09:38:08');
INSERT INTO `hk_account_log` VALUES (23, 'Logout', 'lshengh626', 1, '登出成功', '0:0:0:0:0:0:0:1', '2019-07-04 10:32:23');
INSERT INTO `hk_account_log` VALUES (24, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-04 10:32:29');
INSERT INTO `hk_account_log` VALUES (25, 'Logout', 'lshengh626', 1, '登出成功', '0:0:0:0:0:0:0:1', '2019-07-04 10:40:48');
INSERT INTO `hk_account_log` VALUES (26, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-04 10:41:06');
INSERT INTO `hk_account_log` VALUES (27, 'Login', 'lshengh626', 1, '登录成功', '0:0:0:0:0:0:0:1', '2019-07-04 13:18:23');

-- ----------------------------
-- Table structure for hk_engineering
-- ----------------------------
DROP TABLE IF EXISTS `hk_engineering`;
CREATE TABLE `hk_engineering`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `PID` int(11) NOT NULL COMMENT '父ID',
  `PROJECT_ID` int(11) NOT NULL COMMENT '项目ID',
  `LEVEL` int(1) NOT NULL COMMENT '结构层级',
  `TASK_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `DURATION_DATE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工期',
  `START_DATE` date NOT NULL COMMENT '开始时间',
  `END_DATE` date NOT NULL COMMENT '结束时间',
  `PRE_TASK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前置任务',
  `RESOURCE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1306 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hk_engineering
-- ----------------------------
INSERT INTO `hk_engineering` VALUES (1045, 0, 1, 1, '金钻广场总进度计划', '494.0d', '2019-05-10', '2020-10-12', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1046, 1045, 1, 2, '基础施工', '93.0d', '2019-05-10', '2019-08-10', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1047, 1046, 1, 3, '东侧塔吊施工', '16.0d', '2019-05-30', '2019-06-14', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1048, 1047, 1, 4, '东侧塔吊基础土方开挖', '5.0d', '2019-05-30', '2019-06-03', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1049, 1047, 1, 4, '垫层浇筑', '2.0d', '2019-06-04', '2019-06-05', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1050, 1047, 1, 4, '钢筋施工', '1.0d', '2019-06-06', '2019-06-06', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1051, 1047, 1, 4, '塔吊定位及防雷接地', '1.0d', '2019-06-06', '2019-06-06', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1052, 1047, 1, 4, '模板安装', '1.0d', '2019-06-07', '2019-06-07', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1053, 1047, 1, 4, '浇筑混凝土', '1.0d', '2019-06-08', '2019-06-08', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1054, 1047, 1, 4, '塔吊安装', '2.0d', '2019-06-13', '2019-06-14', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1055, 1046, 1, 3, '7、6区施工', '67.0d', '2019-05-10', '2019-07-15', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1056, 1055, 1, 4, '7区土方开挖', '7.0d', '2019-05-10', '2019-05-16', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1057, 1055, 1, 4, '垫层浇筑', '2.0d', '2019-05-16', '2019-05-17', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1058, 1055, 1, 4, '砖胎膜施工', '5.0d', '2019-05-18', '2019-05-22', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1059, 1055, 1, 4, '承台回填土', '2.0d', '2019-05-22', '2019-05-23', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1060, 1055, 1, 4, '防水施工', '3.0d', '2019-05-27', '2019-05-29', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1061, 1055, 1, 4, '保护层施工', '1.0d', '2019-05-30', '2019-05-30', NULL, NULL, '2019-07-04 14:57:34');
INSERT INTO `hk_engineering` VALUES (1062, 1055, 1, 4, '筏板施工', '10.0d', '2019-05-31', '2019-06-09', NULL, NULL, '2019-07-04 14:57:35');
INSERT INTO `hk_engineering` VALUES (1063, 1055, 1, 4, '水平支撑拆除', '2.0d', '2019-07-04', '2019-07-05', NULL, NULL, '2019-07-04 14:57:35');
INSERT INTO `hk_engineering` VALUES (1064, 1055, 1, 4, '负一层结构施工', '10.0d', '2019-07-06', '2019-07-15', NULL, NULL, '2019-07-04 14:57:35');
INSERT INTO `hk_engineering` VALUES (1065, 1055, 1, 4, '6区土方开挖', '4.0d', '2019-05-22', '2019-05-25', NULL, NULL, '2019-07-04 14:57:35');
INSERT INTO `hk_engineering` VALUES (1066, 1055, 1, 4, '垫层浇筑', '2.0d', '2019-05-25', '2019-05-26', NULL, NULL, '2019-07-04 14:57:35');
INSERT INTO `hk_engineering` VALUES (1067, 1055, 1, 4, '砖胎膜施工及回填土', '3.0d', '2019-05-27', '2019-05-29', NULL, NULL, '2019-07-04 14:57:35');
INSERT INTO `hk_engineering` VALUES (1068, 1055, 1, 4, '防水施工', '2.0d', '2019-05-30', '2019-05-31', NULL, NULL, '2019-07-04 14:57:35');
INSERT INTO `hk_engineering` VALUES (1069, 1055, 1, 4, '保护层施工', '1.0d', '2019-06-01', '2019-06-01', NULL, NULL, '2019-07-04 14:57:36');
INSERT INTO `hk_engineering` VALUES (1070, 1055, 1, 4, '筏板施工', '10.0d', '2019-06-02', '2019-06-11', NULL, NULL, '2019-07-04 14:57:36');
INSERT INTO `hk_engineering` VALUES (1071, 1055, 1, 4, '水平支撑拆除', '2.0d', '2019-07-04', '2019-07-05', NULL, NULL, '2019-07-04 14:57:36');
INSERT INTO `hk_engineering` VALUES (1072, 1055, 1, 4, '负一层结构施工', '10.0d', '2019-07-06', '2019-07-15', NULL, NULL, '2019-07-04 14:57:36');
INSERT INTO `hk_engineering` VALUES (1073, 1046, 1, 3, '1、2区', '65.0d', '2019-05-16', '2019-07-19', NULL, NULL, '2019-07-04 14:57:36');
INSERT INTO `hk_engineering` VALUES (1074, 1073, 1, 4, '1区土方开挖', '9.0d', '2019-05-16', '2019-05-24', NULL, NULL, '2019-07-04 14:57:36');
INSERT INTO `hk_engineering` VALUES (1075, 1073, 1, 4, '垫层浇筑', '2.0d', '2019-05-25', '2019-05-26', NULL, NULL, '2019-07-04 14:57:36');
INSERT INTO `hk_engineering` VALUES (1076, 1073, 1, 4, '砖胎膜施工', '4.0d', '2019-05-27', '2019-05-30', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1077, 1073, 1, 4, '承台加固回填土', '2.0d', '2019-05-31', '2019-06-01', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1078, 1073, 1, 4, '防水施工', '2.0d', '2019-06-02', '2019-06-03', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1079, 1073, 1, 4, '保护层施工', '1.0d', '2019-06-04', '2019-06-04', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1080, 1073, 1, 4, '筏板施工', '15.0d', '2019-06-05', '2019-06-19', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1081, 1073, 1, 4, '水平支撑拆除', '3.0d', '2019-07-01', '2019-07-03', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1082, 1073, 1, 4, '负一层结构施工', '15.0d', '2019-07-04', '2019-07-18', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1083, 1073, 1, 4, '2区土方开挖', '5.0d', '2019-05-25', '2019-05-29', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1084, 1073, 1, 4, '垫层浇筑', '3.0d', '2019-05-29', '2019-05-31', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1085, 1073, 1, 4, '承台加固回填土', '3.0d', '2019-05-31', '2019-06-02', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1086, 1073, 1, 4, '防水施工', '2.0d', '2019-06-03', '2019-06-04', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1087, 1073, 1, 4, '保护层施工', '1.0d', '2019-06-05', '2019-06-05', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1088, 1073, 1, 4, '筏板施工', '15.0d', '2019-06-06', '2019-06-20', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1089, 1073, 1, 4, '水平支撑拆除', '4.0d', '2019-07-01', '2019-07-04', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1090, 1073, 1, 4, '负一层结构施工', '15.0d', '2019-07-05', '2019-07-19', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1091, 1046, 1, 3, '8、9区施工', '53.0d', '2019-05-28', '2019-07-19', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1092, 1091, 1, 4, '8区土方开挖', '5.0d', '2019-05-28', '2019-06-01', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1093, 1091, 1, 4, '垫层浇筑', '3.0d', '2019-06-01', '2019-06-03', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1094, 1091, 1, 4, '承台加固回填土', '4.0d', '2019-06-03', '2019-06-06', NULL, NULL, '2019-07-04 14:57:37');
INSERT INTO `hk_engineering` VALUES (1095, 1091, 1, 4, '防水施工', '2.0d', '2019-06-07', '2019-06-08', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1096, 1091, 1, 4, '保护层施工', '1.0d', '2019-06-09', '2019-06-09', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1097, 1091, 1, 4, '筏板施工', '15.0d', '2019-06-10', '2019-06-24', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1098, 1091, 1, 4, '水平支撑拆除', '3.0d', '2019-07-07', '2019-07-09', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1099, 1091, 1, 4, '负一层结构施工', '10.0d', '2019-07-10', '2019-07-19', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1100, 1091, 1, 4, '9区土方开挖', '5.0d', '2019-05-30', '2019-06-03', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1101, 1091, 1, 4, '垫层浇筑', '3.0d', '2019-06-03', '2019-06-05', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1102, 1091, 1, 4, '承台加固回填土', '4.0d', '2019-06-05', '2019-06-08', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1103, 1091, 1, 4, '防水施工', '2.0d', '2019-06-09', '2019-06-10', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1104, 1091, 1, 4, '保护层施工', '1.0d', '2019-06-11', '2019-06-11', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1105, 1091, 1, 4, '筏板施工', '15.0d', '2019-06-12', '2019-06-26', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1106, 1091, 1, 4, '水平支撑拆除', '3.0d', '2019-07-07', '2019-07-09', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1107, 1091, 1, 4, '负一层结构施工', '10.0d', '2019-07-10', '2019-07-19', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1108, 1046, 1, 3, '11区、10区', '76.0d', '2019-05-27', '2019-08-10', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1109, 1108, 1, 4, '11区土方开挖', '8.0d', '2019-05-27', '2019-06-03', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1110, 1108, 1, 4, '垫层浇筑', '3.0d', '2019-06-03', '2019-06-05', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1111, 1108, 1, 4, '承台加固回填土', '4.0d', '2019-06-05', '2019-06-08', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1112, 1108, 1, 4, '防水施工', '3.0d', '2019-06-09', '2019-06-11', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1113, 1108, 1, 4, '保护层施工', '1.0d', '2019-06-12', '2019-06-12', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1114, 1108, 1, 4, '筏板施工', '15.0d', '2019-06-13', '2019-06-27', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1115, 1108, 1, 4, '水平支撑拆除', '4.0d', '2019-07-07', '2019-07-10', NULL, NULL, '2019-07-04 14:57:38');
INSERT INTO `hk_engineering` VALUES (1116, 1108, 1, 4, '负一层结构施工', '12.0d', '2019-07-29', '2019-08-09', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1117, 1108, 1, 4, '10区土方开挖', '5.0d', '2019-06-02', '2019-06-06', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1118, 1108, 1, 4, '垫层浇筑', '2.0d', '2019-06-06', '2019-06-07', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1119, 1108, 1, 4, '承台加固回填土', '4.0d', '2019-06-07', '2019-06-10', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1120, 1108, 1, 4, '防水施工', '3.0d', '2019-06-11', '2019-06-13', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1121, 1108, 1, 4, '保护层施工', '1.0d', '2019-06-14', '2019-06-14', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1122, 1108, 1, 4, '筏板施工', '15.0d', '2019-06-15', '2019-06-29', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1123, 1108, 1, 4, '水平支撑拆除', '4.0d', '2019-07-07', '2019-07-10', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1124, 1108, 1, 4, '负一层结构施工', '12.0d', '2019-07-30', '2019-08-10', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1125, 1046, 1, 3, '3区、4区、5区', '48.0d', '2019-06-21', '2019-08-07', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1126, 1125, 1, 4, '3区、4区土方开挖', '3.0d', '2019-06-21', '2019-06-23', NULL, NULL, '2019-07-04 14:57:39');
INSERT INTO `hk_engineering` VALUES (1127, 1125, 1, 4, '垫层浇筑', '2.0d', '2019-06-23', '2019-06-24', NULL, NULL, '2019-07-04 14:57:40');
INSERT INTO `hk_engineering` VALUES (1128, 1125, 1, 4, '防水施工', '3.0d', '2019-06-25', '2019-06-27', NULL, NULL, '2019-07-04 14:57:40');
INSERT INTO `hk_engineering` VALUES (1129, 1125, 1, 4, '保护层施工', '1.0d', '2019-06-28', '2019-06-28', NULL, NULL, '2019-07-04 14:57:40');
INSERT INTO `hk_engineering` VALUES (1130, 1125, 1, 4, '筏板施工', '15.0d', '2019-06-29', '2019-07-13', NULL, NULL, '2019-07-04 14:57:40');
INSERT INTO `hk_engineering` VALUES (1131, 1125, 1, 4, '水平支撑拆除', '3.0d', '2019-07-24', '2019-07-26', NULL, NULL, '2019-07-04 14:57:40');
INSERT INTO `hk_engineering` VALUES (1132, 1125, 1, 4, '负一层结构施工', '12.0d', '2019-07-27', '2019-08-07', NULL, NULL, '2019-07-04 14:57:40');
INSERT INTO `hk_engineering` VALUES (1133, 1125, 1, 4, '5区土方开挖', '3.0d', '2019-06-24', '2019-06-26', NULL, NULL, '2019-07-04 14:57:40');
INSERT INTO `hk_engineering` VALUES (1134, 1125, 1, 4, '垫层浇筑', '2.0d', '2019-06-26', '2019-06-27', NULL, NULL, '2019-07-04 14:57:40');
INSERT INTO `hk_engineering` VALUES (1135, 1125, 1, 4, '防水施工', '3.0d', '2019-06-28', '2019-06-30', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1136, 1125, 1, 4, '保护层施工', '1.0d', '2019-07-01', '2019-07-01', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1137, 1125, 1, 4, '筏板施工', '15.0d', '2019-07-02', '2019-07-16', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1138, 1125, 1, 4, '水平支撑拆除', '3.0d', '2019-07-24', '2019-07-26', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1139, 1125, 1, 4, '负一层结构施工', '12.0d', '2019-07-27', '2019-08-07', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1140, 1045, 1, 2, '主体施工', '125.0d', '2019-07-16', '2019-11-17', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1141, 1140, 1, 3, '1#商业', '99.0d', '2019-08-11', '2019-11-17', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1142, 1141, 1, 4, '首层结构', '21.0d', '2019-08-11', '2019-08-31', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1143, 1142, 1, 5, '首层柱钢筋绑扎', '2.0d', '2019-08-11', '2019-08-12', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1144, 1142, 1, 5, '支撑架搭设', '5.0d', '2019-08-13', '2019-08-17', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1145, 1142, 1, 5, 'PC梁板吊装', '8.0d', '2019-08-18', '2019-08-25', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1146, 1142, 1, 5, '板钢筋绑扎', '4.0d', '2019-08-26', '2019-08-29', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1147, 1142, 1, 5, '混凝土浇筑', '2.0d', '2019-08-30', '2019-08-31', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1148, 1141, 1, 4, '二层结构', '19.0d', '2019-09-01', '2019-09-19', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1149, 1148, 1, 5, '支撑架搭设', '5.0d', '2019-09-01', '2019-09-05', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1150, 1148, 1, 5, 'PC梁板吊装', '8.0d', '2019-09-06', '2019-09-13', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1151, 1148, 1, 5, '板钢筋绑扎', '4.0d', '2019-09-14', '2019-09-17', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1152, 1148, 1, 5, '混凝土浇筑', '2.0d', '2019-09-18', '2019-09-19', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1153, 1141, 1, 4, '三层结构', '19.0d', '2019-09-20', '2019-10-08', NULL, NULL, '2019-07-04 14:57:41');
INSERT INTO `hk_engineering` VALUES (1154, 1153, 1, 5, '支撑架搭设', '5.0d', '2019-09-20', '2019-09-24', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1155, 1153, 1, 5, 'PC梁板吊装', '8.0d', '2019-09-25', '2019-10-02', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1156, 1153, 1, 5, '板钢筋绑扎', '4.0d', '2019-10-03', '2019-10-06', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1157, 1153, 1, 5, '混凝土浇筑', '2.0d', '2019-10-07', '2019-10-08', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1158, 1141, 1, 4, '四层结构', '21.0d', '2019-10-09', '2019-10-29', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1159, 1158, 1, 5, '支撑架搭设', '8.0d', '2019-10-09', '2019-10-16', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1160, 1158, 1, 5, 'PC梁板吊装', '8.0d', '2019-10-17', '2019-10-24', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1161, 1158, 1, 5, '板钢筋绑扎', '3.0d', '2019-10-25', '2019-10-27', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1162, 1158, 1, 5, '混凝土浇筑', '2.0d', '2019-10-28', '2019-10-29', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1163, 1141, 1, 4, '五层结构', '19.0d', '2019-10-30', '2019-11-17', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1164, 1163, 1, 5, '支撑架搭设', '5.0d', '2019-10-30', '2019-11-03', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1165, 1163, 1, 5, 'PC梁板吊装', '8.0d', '2019-11-04', '2019-11-11', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1166, 1163, 1, 5, '板钢筋绑扎', '4.0d', '2019-11-12', '2019-11-15', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1167, 1163, 1, 5, '混凝土浇筑', '2.0d', '2019-11-16', '2019-11-17', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1168, 1140, 1, 3, '2#商业', '44.0d', '2019-08-08', '2019-09-20', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1169, 1168, 1, 4, '首层', '9.0d', '2019-08-08', '2019-08-16', NULL, NULL, '2019-07-04 14:57:42');
INSERT INTO `hk_engineering` VALUES (1170, 1168, 1, 4, '二层', '9.0d', '2019-08-17', '2019-08-25', NULL, NULL, '2019-07-04 14:57:43');
INSERT INTO `hk_engineering` VALUES (1171, 1168, 1, 4, '三层', '9.0d', '2019-08-26', '2019-09-03', NULL, NULL, '2019-07-04 14:57:43');
INSERT INTO `hk_engineering` VALUES (1172, 1168, 1, 4, '四层', '8.0d', '2019-09-04', '2019-09-11', NULL, NULL, '2019-07-04 14:57:43');
INSERT INTO `hk_engineering` VALUES (1173, 1168, 1, 4, '五层', '9.0d', '2019-09-12', '2019-09-20', NULL, NULL, '2019-07-04 14:57:43');
INSERT INTO `hk_engineering` VALUES (1174, 1140, 1, 3, '3#商业', '63.0d', '2019-07-20', '2019-09-20', NULL, NULL, '2019-07-04 14:57:43');
INSERT INTO `hk_engineering` VALUES (1175, 1174, 1, 4, '首层', '13.0d', '2019-07-20', '2019-08-01', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1176, 1174, 1, 4, '二层', '13.0d', '2019-08-02', '2019-08-14', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1177, 1174, 1, 4, '三层', '13.0d', '2019-08-15', '2019-08-27', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1178, 1174, 1, 4, '四层', '11.0d', '2019-08-28', '2019-09-07', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1179, 1174, 1, 4, '五层', '13.0d', '2019-09-08', '2019-09-20', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1180, 1140, 1, 3, '4#商业', '44.0d', '2019-08-08', '2019-09-20', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1181, 1180, 1, 4, '首层', '15.0d', '2019-08-08', '2019-08-22', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1182, 1180, 1, 4, '二层', '15.0d', '2019-08-23', '2019-09-06', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1183, 1180, 1, 4, '3层', '14.0d', '2019-09-07', '2019-09-20', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1184, 1140, 1, 3, '5#商业', '45.0d', '2019-08-08', '2019-09-21', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1185, 1184, 1, 4, '首层', '15.0d', '2019-08-08', '2019-08-22', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1186, 1184, 1, 4, '二层', '15.0d', '2019-08-23', '2019-09-06', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1187, 1184, 1, 4, '3层', '15.0d', '2019-09-07', '2019-09-21', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1188, 1140, 1, 3, '6#商业', '45.0d', '2019-08-08', '2019-09-21', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1189, 1188, 1, 4, '首层', '15.0d', '2019-08-08', '2019-08-22', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1190, 1188, 1, 4, '二层', '15.0d', '2019-08-23', '2019-09-06', NULL, NULL, '2019-07-04 14:57:44');
INSERT INTO `hk_engineering` VALUES (1191, 1188, 1, 4, '3层', '15.0d', '2019-09-07', '2019-09-21', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1192, 1140, 1, 3, '7#商业', '36.0d', '2019-08-08', '2019-09-12', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1193, 1192, 1, 4, '首层', '12.0d', '2019-08-08', '2019-08-19', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1194, 1192, 1, 4, '二层', '12.0d', '2019-08-20', '2019-08-31', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1195, 1192, 1, 4, '3层', '12.0d', '2019-09-01', '2019-09-12', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1196, 1140, 1, 3, '8#楼', '24.0d', '2019-07-16', '2019-08-08', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1197, 1196, 1, 4, '首层', '8.0d', '2019-07-16', '2019-07-23', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1198, 1196, 1, 4, '二层', '8.0d', '2019-07-24', '2019-07-31', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1199, 1196, 1, 4, '三层', '8.0d', '2019-08-01', '2019-08-08', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1200, 1140, 1, 3, '9#商业', '45.0d', '2019-08-08', '2019-09-21', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1201, 1200, 1, 4, '首层', '15.0d', '2019-08-08', '2019-08-22', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1202, 1200, 1, 4, '二层', '15.0d', '2019-08-23', '2019-09-06', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1203, 1200, 1, 4, '3层', '15.0d', '2019-09-07', '2019-09-21', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1204, 1140, 1, 3, '10#配电房', '15.0d', '2019-07-20', '2019-08-03', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1205, 1204, 1, 4, '首层', '15.0d', '2019-07-20', '2019-08-03', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1206, 1140, 1, 3, '12#连廊', '45.0d', '2019-08-09', '2019-09-22', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1207, 1206, 1, 4, '首层', '15.0d', '2019-08-09', '2019-08-23', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1208, 1206, 1, 4, '二层', '15.0d', '2019-08-24', '2019-09-07', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1209, 1206, 1, 4, '3层', '15.0d', '2019-09-08', '2019-09-22', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1210, 1045, 1, 2, '塔吊拆除', '10.0d', '2019-11-18', '2019-11-27', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1211, 1045, 1, 2, '二次结构施工', '111.0d', '2019-08-04', '2019-11-22', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1212, 1211, 1, 3, '1#商业1-5层', '30.0d', '2019-10-24', '2019-11-22', NULL, NULL, '2019-07-04 14:57:45');
INSERT INTO `hk_engineering` VALUES (1213, 1211, 1, 3, '2#商业1-5层', '20.0d', '2019-09-12', '2019-10-01', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1214, 1211, 1, 3, '3#商业1-5层', '20.0d', '2019-09-16', '2019-10-05', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1215, 1211, 1, 3, '4#商业1-3层', '10.0d', '2019-09-21', '2019-09-30', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1216, 1211, 1, 3, '5#商业1-3层', '10.0d', '2019-09-22', '2019-10-01', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1217, 1211, 1, 3, '6#商业1-3层', '10.0d', '2019-09-22', '2019-10-01', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1218, 1211, 1, 3, '7#商业1-3层', '10.0d', '2019-09-13', '2019-09-22', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1219, 1211, 1, 3, '8#商业1-3层', '10.0d', '2019-08-09', '2019-08-18', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1220, 1211, 1, 3, '9#商业1-3层', '10.0d', '2019-09-22', '2019-10-01', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1221, 1211, 1, 3, '10#配电房1层', '5.0d', '2019-08-04', '2019-08-08', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1222, 1211, 1, 3, '11#地下室', '52.0d', '2019-08-05', '2019-09-25', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1223, 1045, 1, 2, '结构验收（2-9#楼）', '5.0d', '2019-10-06', '2019-10-10', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1224, 1045, 1, 2, '结构验收（1#楼）', '5.0d', '2019-11-23', '2019-11-27', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1225, 1045, 1, 2, '粗装修施工', '143.0d', '2019-08-19', '2020-01-08', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1226, 1225, 1, 3, '墙面粉刷', '131.0d', '2019-08-19', '2019-12-27', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1227, 1226, 1, 4, '1#商业', '30.0d', '2019-11-28', '2019-12-27', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1228, 1226, 1, 4, '2#商业', '20.0d', '2019-10-11', '2019-10-30', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1229, 1226, 1, 4, '3#商业', '20.0d', '2019-10-11', '2019-10-30', NULL, NULL, '2019-07-04 14:57:47');
INSERT INTO `hk_engineering` VALUES (1230, 1226, 1, 4, '4#商业', '10.0d', '2019-10-11', '2019-10-20', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1231, 1226, 1, 4, '5#商业', '10.0d', '2019-10-21', '2019-10-30', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1232, 1226, 1, 4, '6#商业', '10.0d', '2019-10-31', '2019-11-09', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1233, 1226, 1, 4, '7#商业', '10.0d', '2019-11-10', '2019-11-19', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1234, 1226, 1, 4, '8#商业', '10.0d', '2019-08-19', '2019-08-28', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1235, 1226, 1, 4, '9#商业', '10.0d', '2019-11-20', '2019-11-29', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1236, 1226, 1, 4, '10#配电房', '5.0d', '2019-10-31', '2019-11-04', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1237, 1226, 1, 4, '11#地下室', '30.0d', '2019-10-11', '2019-11-09', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1238, 1225, 1, 3, '地面施工', '126.0d', '2019-08-29', '2020-01-01', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1239, 1238, 1, 4, '1#商业', '15.0d', '2019-12-18', '2020-01-01', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1240, 1238, 1, 4, '2#商业', '10.0d', '2019-10-31', '2019-11-09', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1241, 1238, 1, 4, '3#商业', '10.0d', '2019-10-31', '2019-11-09', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1242, 1238, 1, 4, '4#商业', '5.0d', '2019-10-21', '2019-10-25', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1243, 1238, 1, 4, '5#商业', '5.0d', '2019-10-31', '2019-11-04', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1244, 1238, 1, 4, '6#商业', '5.0d', '2019-11-10', '2019-11-14', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1245, 1238, 1, 4, '7#商业', '5.0d', '2019-11-20', '2019-11-24', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1246, 1238, 1, 4, '8#商业', '5.0d', '2019-08-29', '2019-09-02', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1247, 1238, 1, 4, '9#商业', '5.0d', '2019-11-30', '2019-12-04', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1248, 1238, 1, 4, '10#配电房', '3.0d', '2019-11-05', '2019-11-07', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1249, 1238, 1, 4, '11#地下室', '30.0d', '2019-11-10', '2019-12-09', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1250, 1225, 1, 3, '顶棚施工', '128.0d', '2019-09-03', '2020-01-08', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1251, 1250, 1, 4, '1#商业', '5.0d', '2020-01-02', '2020-01-06', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1252, 1250, 1, 4, '2#商业', '5.0d', '2019-11-10', '2019-11-14', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1253, 1250, 1, 4, '3#商业', '5.0d', '2019-11-10', '2019-11-14', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1254, 1250, 1, 4, '4#商业', '3.0d', '2019-10-26', '2019-10-28', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1255, 1250, 1, 4, '5#商业', '3.0d', '2019-11-05', '2019-11-07', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1256, 1250, 1, 4, '6#商业', '3.0d', '2019-11-15', '2019-11-17', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1257, 1250, 1, 4, '7#商业', '3.0d', '2019-11-25', '2019-11-27', NULL, NULL, '2019-07-04 14:57:49');
INSERT INTO `hk_engineering` VALUES (1258, 1250, 1, 4, '8#商业', '3.0d', '2019-09-03', '2019-09-05', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1259, 1250, 1, 4, '9#商业', '3.0d', '2019-12-05', '2019-12-07', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1260, 1250, 1, 4, '10#配电房', '2.0d', '2019-11-08', '2019-11-09', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1261, 1250, 1, 4, '11#地下室', '30.0d', '2019-12-10', '2020-01-08', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1262, 1045, 1, 2, '屋面施工', '126.0d', '2019-08-29', '2020-01-01', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1263, 1262, 1, 3, '1#商业', '20.0d', '2019-12-13', '2020-01-01', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1264, 1262, 1, 3, '2#商业', '20.0d', '2019-10-31', '2019-11-19', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1265, 1262, 1, 3, '3#商业', '20.0d', '2019-10-31', '2019-11-19', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1266, 1262, 1, 3, '4#商业', '10.0d', '2019-10-21', '2019-10-30', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1267, 1262, 1, 3, '5#商业', '10.0d', '2019-10-31', '2019-11-09', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1268, 1262, 1, 3, '6#商业', '10.0d', '2019-11-10', '2019-11-19', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1269, 1262, 1, 3, '7#商业', '10.0d', '2019-11-20', '2019-11-29', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1270, 1262, 1, 3, '8#商业', '10.0d', '2019-08-29', '2019-09-07', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1271, 1262, 1, 3, '9#商业', '10.0d', '2019-11-30', '2019-12-09', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1272, 1262, 1, 3, '10#配电房', '10.0d', '2019-11-05', '2019-11-14', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1273, 1045, 1, 2, '外墙施工', '131.0d', '2019-08-19', '2019-12-27', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1274, 1273, 1, 3, '1#商业', '30.0d', '2019-11-28', '2019-12-27', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1275, 1273, 1, 3, '2#商业', '30.0d', '2019-10-11', '2019-11-09', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1276, 1273, 1, 3, '3#商业', '30.0d', '2019-10-11', '2019-11-09', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1277, 1273, 1, 3, '4#商业', '15.0d', '2019-10-11', '2019-10-25', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1278, 1273, 1, 3, '5#商业', '15.0d', '2019-10-26', '2019-11-09', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1279, 1273, 1, 3, '6#商业', '15.0d', '2019-11-10', '2019-11-24', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1280, 1273, 1, 3, '7#商业', '15.0d', '2019-11-25', '2019-12-09', NULL, NULL, '2019-07-04 14:57:50');
INSERT INTO `hk_engineering` VALUES (1281, 1273, 1, 3, '8#商业', '10.0d', '2019-08-19', '2019-08-28', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1282, 1273, 1, 3, '9#商业', '15.0d', '2019-12-10', '2019-12-24', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1283, 1273, 1, 3, '10#配电房', '10.0d', '2019-11-10', '2019-11-19', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1284, 1045, 1, 2, '脚手架拆除', '20.0d', '2019-12-28', '2020-01-16', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1285, 1045, 1, 2, '室内精装修施工', '317.0d', '2019-08-27', '2020-07-08', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1286, 1285, 1, 3, '1#商业', '60.0d', '2020-03-01', '2020-04-29', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1287, 1285, 1, 3, '2#商业', '50.0d', '2020-04-30', '2020-06-18', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1288, 1285, 1, 3, '3#商业', '50.0d', '2020-03-01', '2020-04-19', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1289, 1285, 1, 3, '4#商业', '40.0d', '2020-04-20', '2020-05-29', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1290, 1285, 1, 3, '5#商业', '40.0d', '2020-05-30', '2020-07-08', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1291, 1285, 1, 3, '6#商业', '40.0d', '2020-03-01', '2020-04-09', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1292, 1285, 1, 3, '7#商业', '40.0d', '2020-04-10', '2020-05-19', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1293, 1285, 1, 3, '8#商业', '35.0d', '2019-08-27', '2019-09-30', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1294, 1285, 1, 3, '9#商业', '40.0d', '2020-05-20', '2020-06-28', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1295, 1045, 1, 2, '室内电梯安装调试', '70.0d', '2019-10-21', '2019-12-29', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1296, 1045, 1, 2, '室外电梯拆除', '10.0d', '2019-12-30', '2020-01-08', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1297, 1045, 1, 2, '室外工程施工', '333.0d', '2019-08-08', '2020-07-05', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1298, 1297, 1, 3, '车库顶板防水施工', '20.0d', '2019-08-08', '2019-08-27', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1299, 1297, 1, 3, '车库顶板防水保护层施工', '10.0d', '2019-08-28', '2019-09-06', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1300, 1297, 1, 3, '车库顶板回填土', '25.0d', '2020-03-25', '2020-04-18', NULL, NULL, '2019-07-04 14:57:51');
INSERT INTO `hk_engineering` VALUES (1301, 1297, 1, 3, '室外管网施工', '25.0d', '2020-04-19', '2020-05-13', NULL, NULL, '2019-07-04 14:57:52');
INSERT INTO `hk_engineering` VALUES (1302, 1297, 1, 3, '室外道路施工', '25.0d', '2020-05-14', '2020-06-07', NULL, NULL, '2019-07-04 14:57:52');
INSERT INTO `hk_engineering` VALUES (1303, 1297, 1, 3, '室外园林绿化施工', '28.0d', '2020-06-08', '2020-07-05', NULL, NULL, '2019-07-04 14:57:52');
INSERT INTO `hk_engineering` VALUES (1304, 1045, 1, 2, '竣工验收', '11.0d', '2020-07-06', '2020-07-20', NULL, NULL, '2019-07-04 14:57:52');
INSERT INTO `hk_engineering` VALUES (1305, 1045, 1, 2, '竣工备案', '60.0d', '2020-07-21', '2020-10-12', NULL, NULL, '2019-07-04 14:57:52');

-- ----------------------------
-- Table structure for hk_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `hk_operation_log`;
CREATE TABLE `hk_operation_log`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户操作日志主键',
  `LOGIN_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `CLASS_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `METHOD_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法名称',
  `SUCCEED` tinyint(4) NULL DEFAULT NULL COMMENT '是否执行成功(0失败1成功)',
  `IP` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MESSAGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体消息备注',
  `BROWSER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OS` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_MOBILE` tinyint(1) NULL DEFAULT NULL,
  `PARAMS` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `REQUEST_URI` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'REQUEST_URI',
  `METHOD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方式',
  `TIME` bigint(200) NULL DEFAULT NULL COMMENT '执行时间',
  `CREATE_TIME` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hk_operation_log
-- ----------------------------
INSERT INTO `hk_operation_log` VALUES (1, NULL, 'com.hk.zgtj.platform.controller.upms.LoginController', 'logout', 1, '0:0:0:0:0:0:0:1', '用户登出', 'Chrome', 'Windows 10 or Windows Server 2016', 2, NULL, '/logout', 'GET', 482, '2019-07-02 16:38:11');
INSERT INTO `hk_operation_log` VALUES (2, NULL, 'com.hk.zgtj.platform.controller.upms.LoginController', 'loginForm', 1, '0:0:0:0:0:0:0:1', '用户登录认证', 'Chrome', 'Windows 10 or Windows Server 2016', 2, ' request: org.apache.shiro.web.servlet.ShiroHttpServletRequest@533f3852', '/loginForm', 'POST', 5, '2019-07-02 16:40:03');
INSERT INTO `hk_operation_log` VALUES (3, NULL, 'com.hk.zgtj.platform.controller.upms.LoginController', 'loginForm', 1, '0:0:0:0:0:0:0:1', '用户登录认证', 'Chrome', 'Windows 10 or Windows Server 2016', 2, ' request: org.apache.shiro.web.servlet.ShiroHttpServletRequest@a223e43', '/loginForm', 'POST', 163, '2019-07-02 16:40:08');
INSERT INTO `hk_operation_log` VALUES (4, 'lshengh626', 'com.hk.zgtj.platform.controller.upms.LoginController', 'logout', 1, '0:0:0:0:0:0:0:1', '用户登出', 'Chrome', 'Windows 10 or Windows Server 2016', 2, NULL, '/logout', 'GET', 618, '2019-07-02 16:46:24');
INSERT INTO `hk_operation_log` VALUES (5, NULL, 'com.hk.zgtj.platform.controller.upms.LoginController', 'loginForm', 1, '0:0:0:0:0:0:0:1', '用户登录认证', 'Chrome', 'Windows 10 or Windows Server 2016', 2, 'password=%5B123456%5D&randomStr=%5B8CAB6E96-57A7-4C02-AC3C-0AF2F285A448%5D&kaptcha=%5B4296%5D&username=%5Blshengh626%5D', '/loginForm', 'POST', 196, '2019-07-02 16:46:33');

-- ----------------------------
-- Table structure for hk_permission
-- ----------------------------
DROP TABLE IF EXISTS `hk_permission`;
CREATE TABLE `hk_permission`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(11) NULL DEFAULT NULL,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SORT` int(11) NULL DEFAULT NULL,
  `URL` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PERM_CODE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ICON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 211 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hk_permission
-- ----------------------------
INSERT INTO `hk_permission` VALUES (1, -1, '系统管理', 'M', 5, '', NULL, 'fa fa-user-o');
INSERT INTO `hk_permission` VALUES (2, 1, '用户管理', 'M', 1, 'upms/user', '', 'fa fa-bullseye');
INSERT INTO `hk_permission` VALUES (3, 1, '角色管理', 'M', 2, 'upms/role', '', 'fa fa-bullseye');
INSERT INTO `hk_permission` VALUES (4, 1, '菜单管理', 'M', 3, 'upms/menu', '', 'fa fa-bullseye');
INSERT INTO `hk_permission` VALUES (5, 1, '权限管理', 'M', 4, 'upms/permission', '', 'fa fa-bullseye');
INSERT INTO `hk_permission` VALUES (7, 2, '添加', 'P', 1, '', 'sys:user:add', '');
INSERT INTO `hk_permission` VALUES (8, 2, '删除', 'P', 2, '', 'sys:user:delete', '');
INSERT INTO `hk_permission` VALUES (9, 2, '修改', 'P', 3, '', 'sys:user:update', '');
INSERT INTO `hk_permission` VALUES (10, 2, '查看', 'P', 4, '', 'sys:user:view', '');
INSERT INTO `hk_permission` VALUES (15, 4, '修改', 'P', 2, '', 'sys:perm:update', '');
INSERT INTO `hk_permission` VALUES (16, 4, '添加', 'P', 1, '', 'sys:perm:add', '');
INSERT INTO `hk_permission` VALUES (17, 4, '删除', 'P', 3, '', 'sys:perm:delete', '');
INSERT INTO `hk_permission` VALUES (18, 4, '查看', 'P', 4, '', 'sys:perm:menu:view', '');
INSERT INTO `hk_permission` VALUES (19, 5, '添加', 'P', 1, '', 'sys:perm:add', '');
INSERT INTO `hk_permission` VALUES (20, 5, '修改', 'P', 2, '', 'sys:perm:update', '');
INSERT INTO `hk_permission` VALUES (21, 5, '删除', 'P', 3, '', 'sys:perm:delete', '');
INSERT INTO `hk_permission` VALUES (22, 5, '查看', 'P', 4, '', 'sys:perm:view', '');
INSERT INTO `hk_permission` VALUES (24, 3, '添加', 'P', 1, '', 'sys:role:add', '');
INSERT INTO `hk_permission` VALUES (25, 3, '修改', 'P', 2, '', 'sys:role:update', '');
INSERT INTO `hk_permission` VALUES (26, 3, '删除', 'P', 3, '', 'sys:role:delete', '');
INSERT INTO `hk_permission` VALUES (32, 3, '查看', 'P', 4, '', 'sys:role:view', '');
INSERT INTO `hk_permission` VALUES (175, 174, '添加', 'P', 1, NULL, 'sys:organ:add', NULL);
INSERT INTO `hk_permission` VALUES (176, 174, '修改', 'P', 2, NULL, 'sys:organ:update', NULL);
INSERT INTO `hk_permission` VALUES (177, 174, '删除', 'P', 3, NULL, 'sys:organ:delete', NULL);
INSERT INTO `hk_permission` VALUES (178, 174, '查看', 'P', 4, NULL, 'sys:organ:view', NULL);
INSERT INTO `hk_permission` VALUES (179, -1, '项目管理', 'M', 1, NULL, NULL, 'fa fa-tablet');
INSERT INTO `hk_permission` VALUES (180, 179, '项目信息', 'M', 1, 'project/project', NULL, 'fa fa-bullseye');
INSERT INTO `hk_permission` VALUES (181, 180, '添加', 'P', 1, NULL, 'project:project:add', NULL);
INSERT INTO `hk_permission` VALUES (182, 180, '修改', 'P', 2, NULL, 'project:project:update', NULL);
INSERT INTO `hk_permission` VALUES (183, 180, '删除', 'P', 3, NULL, 'project:project:delete', NULL);
INSERT INTO `hk_permission` VALUES (184, 180, '查看', 'P', 4, NULL, 'project:project:view', NULL);
INSERT INTO `hk_permission` VALUES (186, 185, '添加', 'P', 1, NULL, 'project:vehicle:add', NULL);
INSERT INTO `hk_permission` VALUES (187, 185, '修改', 'P', 2, NULL, 'project:vehicle:update', NULL);
INSERT INTO `hk_permission` VALUES (188, 185, '删除', 'P', 3, NULL, 'project:vehicle:delete', NULL);
INSERT INTO `hk_permission` VALUES (189, 185, '导入', 'P', 4, NULL, 'project:vehicle:import', NULL);
INSERT INTO `hk_permission` VALUES (190, 185, '导出', 'P', 5, NULL, 'project:vehicle:export', NULL);
INSERT INTO `hk_permission` VALUES (191, 185, '地图', 'P', 6, NULL, 'project:vehicle:map', NULL);
INSERT INTO `hk_permission` VALUES (192, 185, '查看', 'P', 7, NULL, 'project:vehicle:view', NULL);
INSERT INTO `hk_permission` VALUES (195, 194, '添加', 'P', 1, NULL, 'project:oilBox:add', NULL);
INSERT INTO `hk_permission` VALUES (196, 194, '修改', 'P', 2, NULL, 'project:oilBox:update', NULL);
INSERT INTO `hk_permission` VALUES (197, 194, '删除', 'P', 3, NULL, 'project:oilBox:delete', NULL);
INSERT INTO `hk_permission` VALUES (198, 194, '查看', 'P', 4, NULL, 'project:oilBox:view', NULL);
INSERT INTO `hk_permission` VALUES (200, 199, '查看', 'P', 1, NULL, 'project:setting:view', NULL);
INSERT INTO `hk_permission` VALUES (201, 199, '修改', 'P', 2, NULL, 'project:setting:update', NULL);
INSERT INTO `hk_permission` VALUES (202, 180, '百度', 'P', 5, NULL, 'project:project:map', NULL);
INSERT INTO `hk_permission` VALUES (203, 185, '数据', 'P', 8, NULL, 'project:vehicle:data', NULL);
INSERT INTO `hk_permission` VALUES (205, 204, '查看', 'P', 1, NULL, 'project:channel:view', NULL);
INSERT INTO `hk_permission` VALUES (206, 204, '修改', 'P', 2, NULL, 'project:channel:update', NULL);
INSERT INTO `hk_permission` VALUES (207, 180, '设置', 'P', 6, NULL, 'project:project:setting', NULL);
INSERT INTO `hk_permission` VALUES (208, -1, '任务管理', 'M', 6, NULL, NULL, 'fa fa-clock-o');
INSERT INTO `hk_permission` VALUES (209, 208, '定时任务', 'M', 1, 'quartz/scheduleJob', NULL, 'fa fa-bullseye');
INSERT INTO `hk_permission` VALUES (210, 179, '工程进度', 'M', 2, 'project/engineering', NULL, 'fa fa-bullseye');

-- ----------------------------
-- Table structure for hk_project
-- ----------------------------
DROP TABLE IF EXISTS `hk_project`;
CREATE TABLE `hk_project`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `PROJECT_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `PROJECT_ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目地址',
  `PERSON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目负责人',
  `PHONE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人手机号',
  `LNG` double NOT NULL COMMENT '经度',
  `LAT` double NOT NULL COMMENT '纬度',
  `DESCRIPTION` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hk_project
-- ----------------------------
INSERT INTO `hk_project` VALUES (1, '金钻广场', '江苏省苏州市昆山市', '梁声洪', '15810750108', 121, 31, '金钻广场', '2019-07-04 10:28:38');

-- ----------------------------
-- Table structure for hk_project_role
-- ----------------------------
DROP TABLE IF EXISTS `hk_project_role`;
CREATE TABLE `hk_project_role`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `PROJECT_ID` int(11) NOT NULL COMMENT '项目ID',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `p_unique`(`PROJECT_ID`, `ROLE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hk_project_role
-- ----------------------------
INSERT INTO `hk_project_role` VALUES (1, 1, 2);

-- ----------------------------
-- Table structure for hk_role
-- ----------------------------
DROP TABLE IF EXISTS `hk_role`;
CREATE TABLE `hk_role`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ROLE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `SORT` int(6) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hk_role
-- ----------------------------
INSERT INTO `hk_role` VALUES (2, '超级管理员', 'superadmin', '超级管理员', 1);

-- ----------------------------
-- Table structure for hk_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `hk_role_permission`;
CREATE TABLE `hk_role_permission`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(11) NOT NULL,
  `PERMISSION_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2671 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hk_role_permission
-- ----------------------------
INSERT INTO `hk_role_permission` VALUES (2619, 2, 175);
INSERT INTO `hk_role_permission` VALUES (2620, 2, 179);
INSERT INTO `hk_role_permission` VALUES (2621, 2, 180);
INSERT INTO `hk_role_permission` VALUES (2622, 2, 181);
INSERT INTO `hk_role_permission` VALUES (2623, 2, 182);
INSERT INTO `hk_role_permission` VALUES (2624, 2, 183);
INSERT INTO `hk_role_permission` VALUES (2625, 2, 184);
INSERT INTO `hk_role_permission` VALUES (2626, 2, 202);
INSERT INTO `hk_role_permission` VALUES (2627, 2, 207);
INSERT INTO `hk_role_permission` VALUES (2628, 2, 210);
INSERT INTO `hk_role_permission` VALUES (2629, 2, 186);
INSERT INTO `hk_role_permission` VALUES (2630, 2, 195);
INSERT INTO `hk_role_permission` VALUES (2631, 2, 200);
INSERT INTO `hk_role_permission` VALUES (2632, 2, 205);
INSERT INTO `hk_role_permission` VALUES (2633, 2, 196);
INSERT INTO `hk_role_permission` VALUES (2634, 2, 187);
INSERT INTO `hk_role_permission` VALUES (2635, 2, 201);
INSERT INTO `hk_role_permission` VALUES (2636, 2, 206);
INSERT INTO `hk_role_permission` VALUES (2637, 2, 176);
INSERT INTO `hk_role_permission` VALUES (2638, 2, 188);
INSERT INTO `hk_role_permission` VALUES (2639, 2, 197);
INSERT INTO `hk_role_permission` VALUES (2640, 2, 177);
INSERT INTO `hk_role_permission` VALUES (2641, 2, 198);
INSERT INTO `hk_role_permission` VALUES (2642, 2, 189);
INSERT INTO `hk_role_permission` VALUES (2643, 2, 178);
INSERT INTO `hk_role_permission` VALUES (2644, 2, 1);
INSERT INTO `hk_role_permission` VALUES (2645, 2, 2);
INSERT INTO `hk_role_permission` VALUES (2646, 2, 7);
INSERT INTO `hk_role_permission` VALUES (2647, 2, 8);
INSERT INTO `hk_role_permission` VALUES (2648, 2, 9);
INSERT INTO `hk_role_permission` VALUES (2649, 2, 10);
INSERT INTO `hk_role_permission` VALUES (2650, 2, 3);
INSERT INTO `hk_role_permission` VALUES (2651, 2, 24);
INSERT INTO `hk_role_permission` VALUES (2652, 2, 25);
INSERT INTO `hk_role_permission` VALUES (2653, 2, 26);
INSERT INTO `hk_role_permission` VALUES (2654, 2, 32);
INSERT INTO `hk_role_permission` VALUES (2655, 2, 4);
INSERT INTO `hk_role_permission` VALUES (2656, 2, 16);
INSERT INTO `hk_role_permission` VALUES (2657, 2, 15);
INSERT INTO `hk_role_permission` VALUES (2658, 2, 17);
INSERT INTO `hk_role_permission` VALUES (2659, 2, 18);
INSERT INTO `hk_role_permission` VALUES (2660, 2, 5);
INSERT INTO `hk_role_permission` VALUES (2661, 2, 19);
INSERT INTO `hk_role_permission` VALUES (2662, 2, 20);
INSERT INTO `hk_role_permission` VALUES (2663, 2, 21);
INSERT INTO `hk_role_permission` VALUES (2664, 2, 22);
INSERT INTO `hk_role_permission` VALUES (2665, 2, 190);
INSERT INTO `hk_role_permission` VALUES (2666, 2, 208);
INSERT INTO `hk_role_permission` VALUES (2667, 2, 209);
INSERT INTO `hk_role_permission` VALUES (2668, 2, 191);
INSERT INTO `hk_role_permission` VALUES (2669, 2, 192);
INSERT INTO `hk_role_permission` VALUES (2670, 2, 203);

-- ----------------------------
-- Table structure for hk_schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `hk_schedule_job`;
CREATE TABLE `hk_schedule_job`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bean_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `method_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '状态 1.启动 2.暂停',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hk_user
-- ----------------------------
DROP TABLE IF EXISTS `hk_user`;
CREATE TABLE `hk_user`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NICKNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SALT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PHONE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HEAD` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DESCRIPTION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `LOCKED` int(1) NULL DEFAULT 1,
  `CREATE_DATE` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hk_user
-- ----------------------------
INSERT INTO `hk_user` VALUES (1, 'lshengh626', '梁声洪', 'c720a414afd2fa981229e81499cfc4b3cdfcd458', '51b7cec0d2c840d7b6c21d050f8de957', '312650221@qq.com', '15810750108', NULL, '超级管理员', 1, '2015-10-12 08:25:45');
INSERT INTO `hk_user` VALUES (2, 'zs', '张栓', '844637e292c0884e901e69a96fc23a54f89ea43f', '63cb6b1fc30a11ec', '892977909@qq.com', '18235140516', NULL, '超级管理员', 1, '2015-10-12 08:25:48');

-- ----------------------------
-- Table structure for hk_user_role
-- ----------------------------
DROP TABLE IF EXISTS `hk_user_role`;
CREATE TABLE `hk_user_role`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hk_user_role
-- ----------------------------
INSERT INTO `hk_user_role` VALUES (1, 1, 2);
INSERT INTO `hk_user_role` VALUES (2, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
