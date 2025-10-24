package com.nageoffer.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nageoffer.shortlink.project.dao.entity.LinkAccessStatsDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * 短链接访问统计Mapper接口
 */
public interface LinkAccessStatsMapper extends BaseMapper<LinkAccessStatsDO> {

    /**
     * 记录基础访问监控数据
     * @param linkAccessStatsDO
     */
    @Insert("INSERT INTO\n" +
            "  t_link_access_stats (\n" +
            "    full_short_url,\n" +
            "    gid,\n" +
            "    date,\n" +
            "    pv,\n" +
            "    uv,\n" +
            "    uip,\n" +
            "    hour,\n" +
            "    weekday,\n" +
            "    create_time,\n" +
            "    update_time,\n" +
            "    del_flag\n" +
            "  )\n" +
            "VALUES(\n" +
            "    #{linkAccessStats.fullShortUrl},\n" +
            "    #{linkAccessStats.gid},\n" +
            "    #{linkAccessStats.date},\n" +
            "    #{linkAccessStats.pv},\n" +
            "    #{linkAccessStats.uv},\n" +
            "    #{linkAccessStats.uip},\n" +
            "    #{linkAccessStats.hour},\n" +
            "    #{linkAccessStats.weekday},\n" +
            "    NOW(),\n" +
            "    NOW(),\n" +
            "    0 \n" +
            "  ) ON DUPLICATE KEY\n" +
            "UPDATE\n" +
            "  pv = pv + #{linkAccessStats.pv},\n" +
            "  uv = uv + #{linkAccessStats.uv},\n" +
            "  uip = uip + #{linkAccessStats.uip};")
    void shortLinkStats(@Param("linkAccessStats") LinkAccessStatsDO linkAccessStatsDO);
}
