package com.nageoffer.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 短连接跳转实体类
 */
@Data
@Builder
@TableName("t_link_goto")
@AllArgsConstructor
@NoArgsConstructor
public class ShortLinkGotoDO {

    private Long id;

    private String gid;

    private String fullShortUrl;
}
