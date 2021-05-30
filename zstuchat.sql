/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : zstuchat

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2021-05-26 23:45:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  `reply_id` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `commentwj` (`uid`) USING BTREE,
  CONSTRAINT `commentwj` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '一楼说的对', '2021-04-03 09:38:44', '2', '1', null);
INSERT INTO `comment` VALUES ('3', '二楼说的没错赞一个', '2021-04-03 09:42:00', '2', '2', null);
INSERT INTO `comment` VALUES ('4', '你们说的都对', '2021-04-03 18:13:18', '4', '1', null);
INSERT INTO `comment` VALUES ('28', '罗小黑你什么时候更新', '2021-05-25 22:50:17', '16', '35', null);
INSERT INTO `comment` VALUES ('29', '头柱谦虚了', '2021-05-25 22:51:07', '14', '36', null);

-- ----------------------------
-- Table structure for `dynamic`
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `uid` int DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  KEY `wj` (`uid`) USING BTREE,
  CONSTRAINT `wj` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES ('1', '读书翻页时感觉朋友很多，等到细品一个段落时朋友突然变少，等到细读一句话时朋友已经寥寥无几，等到我想用着重符号标出几个重点字词时却发现没有了。', '2021-05-17 11:05:39', '1');
INSERT INTO `dynamic` VALUES ('2', '再来一条', '2021-05-17 11:05:39', '3');
INSERT INTO `dynamic` VALUES ('3', '多发几条', '2021-05-17 11:05:39', '4');
INSERT INTO `dynamic` VALUES ('4', '666666', '2021-05-17 11:05:39', '5');
INSERT INTO `dynamic` VALUES ('5', '再来一条', '2021-05-17 11:05:39', '2');
INSERT INTO `dynamic` VALUES ('6', '再来一条', '2021-05-17 11:05:39', '6');
INSERT INTO `dynamic` VALUES ('7', '122', '2021-05-17 11:05:39', '1');
INSERT INTO `dynamic` VALUES ('8', '哈哈哈', '2021-05-17 11:05:39', '4');
INSERT INTO `dynamic` VALUES ('9', '你好', '2021-05-17 11:05:39', '3');
INSERT INTO `dynamic` VALUES ('14', '有时候拖拖拉拉的原因真的不是因为「懒」，而是「这破事儿我实在他妈的不想做」。', '2021-05-17 11:05:39', '2');
INSERT INTO `dynamic` VALUES ('15', '语言的真正作用与其说是表达我们的需求，不如说是掩饰我们的需求', '2021-05-17 11:05:39', '4');
INSERT INTO `dynamic` VALUES ('17', '读书翻页时感觉朋友很多，等到细品一个段落时朋友突然变少，等到细读一句话时朋友已经寥寥无几，等到我想用着重符号标出几个重点字词时却发现没有了。', '2021-05-17 11:05:39', '6');
INSERT INTO `dynamic` VALUES ('18', '“你我皆为星辰之子，每一个细胞都书写着整个宇宙的历史，当你凝视自己，也望见了宇宙的轮廓。”', '2021-05-17 11:05:39', '7');
INSERT INTO `dynamic` VALUES ('22', '如果结果并非所愿，那就在尘埃落定前奋力一搏。', '2021-05-17 11:05:39', '2');
INSERT INTO `dynamic` VALUES ('28', '妙啊真是妙蛙种子吃着妙脆角进了米奇妙妙屋妙到家了', '2021-05-17 11:05:39', '5');
INSERT INTO `dynamic` VALUES ('29', '我又回来了，你们好啊', '2021-05-17 11:05:39', '1');
INSERT INTO `dynamic` VALUES ('30', '啦啦啦', '2021-05-17 11:05:39', '7');
INSERT INTO `dynamic` VALUES ('31', '哈哈哈', '2021-05-17 11:05:39', '6');
INSERT INTO `dynamic` VALUES ('32', '666', '2021-05-17 11:05:39', '5');
INSERT INTO `dynamic` VALUES ('33', '11111', '2021-05-17 11:05:39', '1');
INSERT INTO `dynamic` VALUES ('34', '111', '2021-05-25 04:23:32', '1');
INSERT INTO `dynamic` VALUES ('35', '喵喵喵', '2021-05-25 22:49:24', '15');
INSERT INTO `dynamic` VALUES ('36', '笑死，根本不会呼吸', '2021-05-25 22:50:03', '16');

-- ----------------------------
-- Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid1` int NOT NULL,
  `uid2` int NOT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('1', '1', '4', '2021-05-25 04:49:41');
INSERT INTO `friend` VALUES ('4', '1', '1', '2021-05-25 14:17:49');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid1` int NOT NULL,
  `uid2` int NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '1', '4', '666', '2021-05-25 16:28:27');
INSERT INTO `message` VALUES ('2', '1', '1', '你真帅', '2021-05-25 16:29:43');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `avatar` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'http://localhost:8081/default_avatar.jpg' COMMENT '头像',
  `status` int DEFAULT '0' COMMENT '登录状态',
  `email` varchar(50) DEFAULT NULL,
  `signature` varchar(50) DEFAULT '',
  `sex` varchar(10) DEFAULT '',
  `birthday` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'wqm', '123', 'http://localhost:8081/avatar/lxh.jfif', '0', '2694448465@qq.com', 'just do it', '1', '2021-05-02T16:00:00.000Z');
INSERT INTO `user` VALUES ('2', 'qqq', '123', 'http://localhost:8081/bx1.png', '0', null, '', '', null);
INSERT INTO `user` VALUES ('3', 'qqqq', '123', 'http://localhost:8081/bx1.png', '0', null, '', '', null);
INSERT INTO `user` VALUES ('4', 'zzf', '123', 'http://localhost:8081/default_avatar.jpg', '0', null, '', '', null);
INSERT INTO `user` VALUES ('5', 'lll', '123', 'http://localhost:8081/default_avatar.jpg', '0', null, '', '', null);
INSERT INTO `user` VALUES ('6', 'test1', '123', 'http://localhost:8081/default_avatar.jpg', '0', null, '', '', null);
INSERT INTO `user` VALUES ('7', 'test2', '123', 'http://localhost:8081/avatar/1603250241278892e5b55170b2aad76ea9cb1a4c42551.jpg', '0', null, '', '', null);
INSERT INTO `user` VALUES ('8', '王前明', '104231', 'http://localhost:8081/avatar/16203527895041620352789458.png', '0', null, '', '', null);
INSERT INTO `user` VALUES ('14', '楚子航', '123', 'http://localhost:8081/avatar/1603249719512e7ce86382fa47c58d7f89334538b235a.jpg', '0', null, '', '', null);
INSERT INTO `user` VALUES ('15', '罗小黑', '123', 'http://localhost:8081/avatar/lxh.jfif', '0', null, '', '', null);
INSERT INTO `user` VALUES ('16', '炭治郎', '123', 'http://localhost:8081/avatar/tzl.jpeg', '0', null, '', '', null);
