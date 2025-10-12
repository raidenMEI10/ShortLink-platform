package com.nageoffer.shortlink.admin.test;

public class UserTableShardingTest {
    public static final String SQL = "CREATE TABLE `t_link_%d` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `domain` varchar(128) DEFAULT NULL COMMENT '域名',\n" +
            "  `short_uri` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,\n" +
            "  `full_short_url` varchar(128) DEFAULT NULL COMMENT '完整短链接',\n" +
            "  `origin_url` varchar(1024) DEFAULT NULL COMMENT '完成原始链接',\n" +
            "  `click_number` int(11) DEFAULT '0' COMMENT '点击量',\n" +
            "  `gid` varchar(32) DEFAULT NULL COMMENT '分组标识',\n" +
            "  `enable_status` tinyint(1) DEFAULT NULL COMMENT '是否启用标识，0是启用，1是未启用',\n" +
            "  `create_type` tinyint(1) DEFAULT NULL COMMENT '创建类型：0为接口创建，1为控制台创建',\n" +
            "  `valid_date_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型，0为永久有效，1为自定义',\n" +
            "  `valid_date` datetime DEFAULT NULL COMMENT '有效期',\n" +
            "  `describe` varchar(1024) DEFAULT NULL COMMENT '描述',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT '创建时间',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT '更新时间',\n" +
            "  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `t_link_id_uindex` (`id`),\n" +
            "  UNIQUE KEY `idx_unique_for_short-url` (`full_short_url`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1976953217686675459 DEFAULT CHARSET=utf8mb4 COMMENT='短链接链接表'";
    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n", i);
        }
    }
}
