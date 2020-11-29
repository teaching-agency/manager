/*
Navicat MySQL Data Transfer

Source Server         : zeya_aliyun
Source Server Version : 50732
Source Host           : 120.26.161.223:3306
Source Database       : manager

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-11-29 17:34:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `COMPANY_ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `COMPANY_NAME` varchar(50) NOT NULL COMMENT '公司姓名',
  `ADDRESS` varchar(50) NOT NULL COMMENT '公司地址',
  `LEGAL_PERSION_NAME` varchar(40) NOT NULL COMMENT '法人姓名',
  `COMPANY_PHONE` varchar(50) NOT NULL COMMENT '公司固定号码',
  `LAND_LINE` varchar(50) DEFAULT NULL COMMENT '座机',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '加盟时间',
  `DEAD_LINE` varchar(50) DEFAULT NULL COMMENT '期限',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `END_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  `STATUS` varchar(20) DEFAULT NULL COMMENT '状态（0：已签约；1未签约；2：未联系；3有意向；4无意向）',
  `BILL_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '每月结账时间',
  `JOIN_COUNT` varchar(50) DEFAULT NULL COMMENT '加盟次数（月按0.几算）',
  `TOKEN` varchar(255) DEFAULT NULL COMMENT 'token令牌',
  `COMPANY_PASS` varchar(50) NOT NULL COMMENT '密码',
  `COMPANY_USER_ID_CARD` varchar(50) NOT NULL COMMENT '法人身份证号',
  PRIMARY KEY (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('38', 'abc', '江苏省苏州市', '王明智', '15152773477', null, null, null, null, null, null, null, null, null, '123456', '321084199602241519');

-- ----------------------------
-- Table structure for cost
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `COST_ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '费用id',
  `USER_ID` int(20) DEFAULT NULL COMMENT '用户id（存在用户id必要存在课程id）',
  `COMPANY_ID` int(20) DEFAULT NULL COMMENT '公司id',
  `COURSE_ID` int(20) DEFAULT NULL COMMENT '课程表id',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `STATUS` varchar(10) DEFAULT '0' COMMENT '状态（0：正在进行；1中途违约；2：合同到期）',
  `PAY_MONEY` varchar(255) DEFAULT NULL COMMENT '缴费金额',
  `ACTUAL_PAY` varchar(255) DEFAULT NULL COMMENT '实际缴费',
  `PAY_IMG` varchar(255) DEFAULT NULL COMMENT '缴费单据截图',
  `END_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '终止时间',
  `BREACH_MONEY` varchar(255) DEFAULT NULL COMMENT '违约金',
  PRIMARY KEY (`COST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost
-- ----------------------------

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `FEEDBACK_ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '反馈id',
  `CONTENT` varchar(255) NOT NULL COMMENT '反馈内容',
  `USER_ID` int(20) DEFAULT NULL COMMENT '用户id',
  `COMPANY_ID` int(20) DEFAULT NULL COMMENT '公司id',
  `STATUS` varchar(15) DEFAULT '0' COMMENT '状态（0：未查看；1：已阅读；2：已解决；3：未解决）',
  `IMG` varchar(255) DEFAULT NULL COMMENT '图片',
  `CREATE_TIME` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `END_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修复时间',
  `SOLVE_CONTENT` varchar(255) DEFAULT NULL COMMENT '解决办法',
  PRIMARY KEY (`FEEDBACK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `MENU_ID` int(10) NOT NULL AUTO_INCREMENT,
  `MENU_NAME` varchar(50) NOT NULL COMMENT '菜单名称',
  `URL` varchar(255) NOT NULL COMMENT '跳转地址',
  `PARENT_ID` int(20) DEFAULT NULL COMMENT '父级id',
  `DEL_FLAG` varchar(20) DEFAULT NULL COMMENT '是否启用',
  `ICON` varchar(255) DEFAULT NULL COMMENT '图标',
  `CREAT_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id\r\n',
  `NAME` varchar(255) NOT NULL COMMENT '用户名',
  `ADDRESS` varchar(255) NOT NULL COMMENT '地址',
  `ID_CODE` varchar(255) NOT NULL COMMENT '身份证号码',
  `PHONE` varchar(255) NOT NULL COMMENT '手机号',
  `GENDER` varchar(255) DEFAULT 'M' COMMENT '性别（F:女；M:男）',
  `USER_CODE` varchar(255) DEFAULT NULL COMMENT '用户编号',
  `CHILDERN_NAME` varchar(255) NOT NULL COMMENT '孩子姓名',
  `ADJUNCT_PHONE` varchar(255) DEFAULT NULL COMMENT '附属号码',
  `STATUS` varchar(10) NOT NULL DEFAULT '0' COMMENT '状态（0：活；1死）',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `DEAD_LINE` varchar(255) DEFAULT NULL COMMENT '期限（单位：月/年[默认月]）',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `END_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '终止合同时间',
  `JOIN_COUNT` int(50) DEFAULT NULL COMMENT '加盟次数（一学期：1；寒/暑假:0.5）',
  `COMPANY_ID` int(20) NOT NULL COMMENT '公司id',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
