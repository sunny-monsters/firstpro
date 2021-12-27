/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : goods_sales

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 27/12/2021 15:28:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods_sub
-- ----------------------------
DROP TABLE IF EXISTS `goods_sub`;
CREATE TABLE `goods_sub`  (
  `Sub` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单号',
  `Username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `Spate` date NOT NULL COMMENT '订购日期',
  `Address` varchar(80) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '地址',
  `Payment` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '支付方式',
  `Photo` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '联系电话',
  `Carry` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '运送方式',
  PRIMARY KEY (`Sub`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_sub
-- ----------------------------
INSERT INTO `goods_sub` VALUES ('20211212000044', '韩梅梅', '2018-05-26', '黑龙江哈尔滨', '支付宝支付', '1321885226', '申通快递');
INSERT INTO `goods_sub` VALUES ('20211212000412', '丽萨', '2021-12-28', '杭州', '支付宝支付', '1234567892', '申通快递');
INSERT INTO `goods_sub` VALUES ('20211213103551', '王五', '2021-12-13', '吉林省', '微信支付', '88888888', '申通快递');
INSERT INTO `goods_sub` VALUES ('20211213105601', '老铁', '2021-12-13', '广东省广州市', '支付宝支付', '1254288621', '申通快递');
INSERT INTO `goods_sub` VALUES ('20211213190141', '李丽', '2021-12-13', '吉林省', '微信支付', '88888888', '申通快递');
INSERT INTO `goods_sub` VALUES ('20211214104015', '张三', '2021-12-14', '辽宁省', '支付宝支付', '154270521', '申通快递');
INSERT INTO `goods_sub` VALUES ('20211215113343', '李四', '2021-12-15', '河北秦皇岛', '其他', '13015422000', '百世快递');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '1',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`, `username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', 'root');

SET FOREIGN_KEY_CHECKS = 1;
