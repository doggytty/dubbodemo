DROP TABLE IF EXISTS `tty_computer`;
CREATE TABLE IF NOT EXISTS `tty_computer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '进件ID',
  `alias` varchar(64) NOT NULL COMMENT '别名',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `os` VARCHAR(50) DEFAULT NULL COMMENT '电脑操作系统',
  `bios` varchar(64) DEFAULT NULL COMMENT 'bios类型',
  `cpu` VARCHAR(50) DEFAULT NULL COMMENT 'cpu',
  `memory` varchar(20) DEFAULT NULL COMMENT '内存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='电脑';

