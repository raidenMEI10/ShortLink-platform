package com.nageoffer.shortlink.admin.test;

public class UserTableShardingTest {
    public static final String SQL = "CREATE TABLE `t_group_%d` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `gid` varchar(32) DEFAULT NULL COMMENT '分组标识',\n" +
            "  `name` varchar(64) DEFAULT NULL COMMENT '分组名称',\n" +
            "  `username` varchar(256) DEFAULT NULL COMMENT '创建该分组的用户名',\n" +
            "  `create_time` datetime DEFAULT NULL,\n" +
            "  `update_time` datetime DEFAULT NULL,\n" +
            "  `del_flag` tinyint(1) DEFAULT NULL,\n" +
            "  `sort_order` int(3) DEFAULT NULL COMMENT '分组排序',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `t_group__index_username_gid` (`gid`,`username`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1975495261770215427 DEFAULT CHARSET=utf8mb4";
    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n", i);
        }
    }
}
