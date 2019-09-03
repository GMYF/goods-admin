DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `TYPE` varchar(255) NOT NULL COMMENT '类型：1表示系统信息，2表示日志内容信息',
  `SYSTEM` varchar(255) DEFAULT NULL COMMENT '系统类型-位数，当type=1时候启用',
  `HOST` varchar(255) DEFAULT NULL COMMENT 'ip，当type=1时候启用',
  `DB_CONNECT` varchar(255) DEFAULT NULL COMMENT '连接目标数据库结果，当type=1时候启用',
  `LOCATION` varchar(255) DEFAULT NULL,
  `LOG_LEVEL` varchar(255) DEFAULT NULL,
  `MESSAGE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;