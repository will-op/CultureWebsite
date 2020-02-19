/*
 Navicat Premium Data Transfer

 Source Server         : mssql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : culturewebsite

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 05/09/2019 17:56:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`adminid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('10001', '5393e07f94a25aaa373dbd3fa257bd3a', 'abcdefg');
INSERT INTO `admin` VALUES ('10002', 'cbcc3462c4ac5adc39383c6b6ee61a21', '580881');
INSERT INTO `admin` VALUES ('10003', '28819c8189fb574dd6717a7f0ebdced1', '7e5507');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `categoryid` bigint(20) NOT NULL AUTO_INCREMENT,
  `sortname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`categoryid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '国画');
INSERT INTO `category` VALUES (2, '油画');
INSERT INTO `category` VALUES (3, '水彩');
INSERT INTO `category` VALUES (4, '素描');
INSERT INTO `category` VALUES (8, '测试');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NULL DEFAULT NULL,
  `courseid` bigint(20) NULL DEFAULT NULL,
  `coursecomments` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answertime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`commentid`) USING BTREE,
  INDEX `FK_comment_userid`(`userid`) USING BTREE,
  INDEX `FK_comment_course`(`courseid`) USING BTREE,
  CONSTRAINT `FK_comment_course` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_comment_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, NULL, 1, '好帅', '2019-06-01 08:05:51');
INSERT INTO `comment` VALUES (2, NULL, 1, '真帅', '2019-06-01 08:06:26');
INSERT INTO `comment` VALUES (3, NULL, 1, '好帅', '2019-06-02 12:45:44');
INSERT INTO `comment` VALUES (4, NULL, 1, '好帅', '2019-06-02 13:07:39');
INSERT INTO `comment` VALUES (5, NULL, 1, '那首啊', '2019-06-02 13:10:55');
INSERT INTO `comment` VALUES (6, NULL, 1, '1111', '2019-06-04 08:22:47');
INSERT INTO `comment` VALUES (7, NULL, 1, '好惨', '2019-06-07 10:22:22');
INSERT INTO `comment` VALUES (8, NULL, 1, 'json', '2019-06-22 23:14:54');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `courseid` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryid` bigint(20) NULL DEFAULT NULL,
  `teacherid` bigint(20) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `totalnum` bigint(20) NULL DEFAULT NULL,
  `joined` bigint(255) NULL DEFAULT NULL,
  `price` int(10) NULL DEFAULT NULL,
  `courseintro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `abstracts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `firstdate` date NULL DEFAULT NULL,
  `amenddate` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `amendby` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`courseid`) USING BTREE,
  INDEX `teacherid`(`teacherid`) USING BTREE,
  INDEX `FK_course_admin`(`amendby`) USING BTREE,
  INDEX `FK_course_category`(`categoryid`) USING BTREE,
  CONSTRAINT `FK_course_admin` FOREIGN KEY (`amendby`) REFERENCES `admin` (`adminid`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_course_category` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_course_teacher` FOREIGN KEY (`teacherid`) REFERENCES `teacher` (`teacherid`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 1, 20160303555, '国画课', '国画', 120, 54, 1500, '好课', '国画', '2019-07-25', NULL, NULL);
INSERT INTO `course` VALUES (2, 1, 20160505555, '国画课2', '国画1', 120, 50, 1500, '好课', '国画', '2019-07-26', NULL, NULL);
INSERT INTO `course` VALUES (3, 2, 20160606888, '油画课', '油画', 120, 50, 1500, '好课', '油画', '2019-07-27', NULL, NULL);
INSERT INTO `course` VALUES (4, 2, 20160808888, '油画课2', '油画1', 120, 50, 1500, '好课', '油画', '2019-07-28', NULL, NULL);
INSERT INTO `course` VALUES (5, 3, 20161212666, '水彩课', '水彩', 120, 50, 1500, '好课', '水彩', '2019-07-29', NULL, NULL);
INSERT INTO `course` VALUES (6, 3, 20180808888, '水彩课2', '水彩1', 120, 50, 1500, '好课', '水彩', '2019-07-30', NULL, NULL);
INSERT INTO `course` VALUES (7, 4, 20161212666, '素描课', '素描', 120, 50, 1500, '好课', '素描', '2019-07-31', NULL, NULL);
INSERT INTO `course` VALUES (8, 4, 20160606888, '素描课1', '素描1', 120, 50, 1500, '好课', '素描', '2019-08-01', NULL, NULL);
INSERT INTO `course` VALUES (10, 1, 20160808888, '国画课3', '国画', 120, 120, 1500, '好课', 'haoaoahaohao', '2019-08-02', NULL, NULL);
INSERT INTO `course` VALUES (11, 1, 20160303555, '国画课6', '国画', 120, 3, 1500, '好课', 'haoaoahaohao', '2019-08-03', NULL, NULL);
INSERT INTO `course` VALUES (12, 2, 20160505555, '油画课233', '油画', 120, 50, 1500, '好课', 'haoaoahaohao', '2019-08-04', NULL, NULL);

-- ----------------------------
-- Table structure for courseofuser
-- ----------------------------
DROP TABLE IF EXISTS `courseofuser`;
CREATE TABLE `courseofuser`  (
  `courseofduserid` bigint(20) NOT NULL AUTO_INCREMENT,
  `courseid` bigint(20) NULL DEFAULT NULL,
  `courseperiodname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buydate` datetime(0) NULL DEFAULT NULL,
  `userid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`courseofduserid`) USING BTREE,
  INDEX `FK_courseofuser_course`(`courseid`) USING BTREE,
  INDEX `FK_courseoduser_user`(`userid`) USING BTREE,
  CONSTRAINT `FK_courseoduser_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_courseofuser_course` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseofuser
-- ----------------------------
INSERT INTO `courseofuser` VALUES (7, 2, '测试1', '2019-06-02 11:05:32', NULL);
INSERT INTO `courseofuser` VALUES (8, 2, '测试二', '2019-06-02 11:05:32', NULL);
INSERT INTO `courseofuser` VALUES (9, 2, '测试三', '2019-06-02 11:05:32', NULL);
INSERT INTO `courseofuser` VALUES (10, 1, '测试1', '2019-06-02 11:49:31', NULL);
INSERT INTO `courseofuser` VALUES (11, 1, '测试二', '2019-06-02 11:49:31', NULL);
INSERT INTO `courseofuser` VALUES (12, 1, '测试三', '2019-06-02 11:49:31', NULL);
INSERT INTO `courseofuser` VALUES (15, 11, '测试1', '2019-06-10 21:59:51', NULL);
INSERT INTO `courseofuser` VALUES (16, 11, '测试二', '2019-06-10 21:59:51', NULL);
INSERT INTO `courseofuser` VALUES (17, 11, '测试三', '2019-06-10 21:59:51', NULL);
INSERT INTO `courseofuser` VALUES (18, 1, '测试1', '2019-06-30 13:14:14', NULL);
INSERT INTO `courseofuser` VALUES (19, 1, '测试二', '2019-06-30 13:14:15', NULL);
INSERT INTO `courseofuser` VALUES (20, 1, '测试三', '2019-06-30 13:14:16', NULL);

-- ----------------------------
-- Table structure for courseperiod
-- ----------------------------
DROP TABLE IF EXISTS `courseperiod`;
CREATE TABLE `courseperiod`  (
  `courseperiodid` bigint(20) NOT NULL AUTO_INCREMENT,
  `courseperiodname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseid` bigint(20) NULL DEFAULT NULL,
  `begintime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`courseperiodid`) USING BTREE,
  INDEX `FK_courseperiod_course`(`courseid`) USING BTREE,
  CONSTRAINT `FK_courseperiod_course` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseperiod
-- ----------------------------
INSERT INTO `courseperiod` VALUES (1, '第一课时', 1, '2019-07-01 22:50:00');
INSERT INTO `courseperiod` VALUES (2, '第二课时', 2, '2019-06-29 22:50:00');
INSERT INTO `courseperiod` VALUES (3, '第三课时', 3, '2019-06-30 05:26:28');
INSERT INTO `courseperiod` VALUES (4, '随便第几', 3, '2019-07-02 10:26:28');
INSERT INTO `courseperiod` VALUES (5, '课时1', 2, '2019-07-07 20:54:08');
INSERT INTO `courseperiod` VALUES (6, '课时2', 1, '2019-07-18 20:54:29');
INSERT INTO `courseperiod` VALUES (7, '课时3', 3, '2019-07-23 20:54:40');
INSERT INTO `courseperiod` VALUES (8, '课时4', 2, '2019-07-26 20:55:11');
INSERT INTO `courseperiod` VALUES (9, '课时5', 3, '2019-07-31 20:55:19');
INSERT INTO `courseperiod` VALUES (10, '课时6', 2, '2019-07-18 20:56:01');

-- ----------------------------
-- Table structure for hotsearch
-- ----------------------------
DROP TABLE IF EXISTS `hotsearch`;
CREATE TABLE `hotsearch`  (
  `hotsearchid` bigint(20) NOT NULL AUTO_INCREMENT,
  `hotwords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `searchtimes` bigint(20) NULL DEFAULT NULL,
  `note` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`hotsearchid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hotsearch
-- ----------------------------
INSERT INTO `hotsearch` VALUES (1, '国画', 3, 2);
INSERT INTO `hotsearch` VALUES (2, '陈老师', 3, 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacherid` bigint(20) NOT NULL,
  `teachername` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacherintroduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telepone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amenddate` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `amendby` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacherid`) USING BTREE,
  INDEX `FK_teacher_admin`(`amendby`) USING BTREE,
  CONSTRAINT `FK_teacher_admin` FOREIGN KEY (`amendby`) REFERENCES `admin` (`adminid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (20160303555, '刘老师', '好好', NULL, NULL, NULL, NULL);
INSERT INTO `teacher` VALUES (20160505555, '郝老师', '好老师', NULL, NULL, NULL, NULL);
INSERT INTO `teacher` VALUES (20160606888, '陈老师', '好老师', NULL, NULL, NULL, NULL);
INSERT INTO `teacher` VALUES (20160808888, '林老师', '好好', NULL, NULL, NULL, NULL);
INSERT INTO `teacher` VALUES (20161212666, '黄老师', '好好', NULL, NULL, NULL, NULL);
INSERT INTO `teacher` VALUES (20180808888, '付老师', 'haohao', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `wxid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ifadmin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wxnickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userscore` int(255) NULL DEFAULT 0,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1666666 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1666666, 'oJp8353u2kg8rhPWb32b800LQG4Y', NULL, '去创', '男', 72);

-- ----------------------------
-- Table structure for usercollect
-- ----------------------------
DROP TABLE IF EXISTS `usercollect`;
CREATE TABLE `usercollect`  (
  `usercollectid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NULL DEFAULT NULL,
  `courseid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`usercollectid`) USING BTREE,
  INDEX `FK_usercollect_user`(`userid`) USING BTREE,
  INDEX `FK_usercollect_course`(`courseid`) USING BTREE,
  CONSTRAINT `FK_usercollect_course` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_usercollect_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usercollect
-- ----------------------------
INSERT INTO `usercollect` VALUES (1, NULL, NULL);
INSERT INTO `usercollect` VALUES (2, NULL, NULL);
INSERT INTO `usercollect` VALUES (3, NULL, NULL);
INSERT INTO `usercollect` VALUES (4, NULL, NULL);
INSERT INTO `usercollect` VALUES (5, NULL, NULL);
INSERT INTO `usercollect` VALUES (6, NULL, NULL);
INSERT INTO `usercollect` VALUES (7, NULL, NULL);
INSERT INTO `usercollect` VALUES (8, NULL, NULL);
INSERT INTO `usercollect` VALUES (9, NULL, NULL);
INSERT INTO `usercollect` VALUES (10, NULL, NULL);
INSERT INTO `usercollect` VALUES (11, NULL, NULL);
INSERT INTO `usercollect` VALUES (12, NULL, NULL);
INSERT INTO `usercollect` VALUES (13, NULL, NULL);
INSERT INTO `usercollect` VALUES (14, NULL, NULL);

-- ----------------------------
-- Table structure for usersignin
-- ----------------------------
DROP TABLE IF EXISTS `usersignin`;
CREATE TABLE `usersignin`  (
  `signid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL,
  `signdate` datetime(0) NULL,
  `continuedays` int(11) NOT NULL,
  `signaward` int(11) NULL DEFAULT NULL,
  `awardtype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finalaward` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`signid`) USING BTREE,
  INDEX `FK_usersignin_user`(`userid`) USING BTREE,
  CONSTRAINT `FK_usersignin_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usersignin
-- ----------------------------
INSERT INTO `usersignin` VALUES (1, 1666666, '2019-06-07 22:12:10', 1, 0, '签到', 1);
INSERT INTO `usersignin` VALUES (2, 1666666, '2019-06-08 22:12:11', 2, 1, '签到', 2);
INSERT INTO `usersignin` VALUES (3, 1666666, '2019-06-09 22:12:10', 3, 2, '签到', 3);
INSERT INTO `usersignin` VALUES (4, 1666666, '2019-06-10 22:12:10', 4, 3, '签到', 4);
INSERT INTO `usersignin` VALUES (5, 1666666, '2019-06-11 22:12:11', 5, 4, '签到', 5);
INSERT INTO `usersignin` VALUES (6, 1666666, '2019-06-12 22:12:11', 6, 5, '签到', 6);
INSERT INTO `usersignin` VALUES (7, 1666666, '2019-06-13 22:12:10', 7, 6, '签到', 7);
INSERT INTO `usersignin` VALUES (8, 1666666, '2019-06-14 22:12:10', 8, 6, '签到', 7);
INSERT INTO `usersignin` VALUES (9, 1666666, '2019-06-15 22:12:10', 9, 6, '签到', 7);
INSERT INTO `usersignin` VALUES (10, 1666666, '2019-06-16 22:12:10', 10, 6, '签到', 7);
INSERT INTO `usersignin` VALUES (11, 1666666, '2019-06-17 22:12:10', 11, 6, '签到', 7);
INSERT INTO `usersignin` VALUES (12, 1666666, '2019-06-18 22:12:11', 12, 6, '签到', 7);
INSERT INTO `usersignin` VALUES (15, 1666666, '2019-06-19 22:12:11', 13, 6, '签到', 7);

SET FOREIGN_KEY_CHECKS = 1;
