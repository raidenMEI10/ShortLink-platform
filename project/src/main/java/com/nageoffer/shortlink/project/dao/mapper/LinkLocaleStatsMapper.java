package com.nageoffer.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nageoffer.shortlink.project.dao.entity.LinkLocaleStatsDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * 地区统计Mapper接口
 */
public interface LinkLocaleStatsMapper extends BaseMapper<LinkLocaleStatsDO> {

    /**
     * 记录地区访问统计数据
     * @param linkLocaleStatsDO
     */
    @Insert("INSERT INTO\n" +
            "  t_link_locale_stats (\n" +
            "    full_short_url,\n" +
            "    gid,\n" +
            "    date,\n" +
            "    cnt,\n" +
            "    create_time,\n" +
            "    update_time,\n" +
            "    del_flag,\n" +
            "    country,"+
            "    province,"+
            "    city,"+
            "    adcode"+
            "  )\n" +
            "VALUES(\n" +
            "    #{linkLocaleStats.fullShortUrl},\n" +
            "    #{linkLocaleStats.gid},\n" +
            "    #{linkLocaleStats.date},\n" +
            "    #{linkLocaleStats.cnt},\n" +
            "    NOW(),\n" +
            "    NOW(),\n" +
            "    0, \n" +
            "    #{linkLocaleStats.country},"+
            "    #{linkLocaleStats.province},"+
            "    #{linkLocaleStats.city},"+
            "    #{linkLocaleStats.adcode}"+
            "  ) ON DUPLICATE KEY\n" +
            "UPDATE\n" +
            "  cnt = cnt + #{linkLocaleStats.cnt};")
    void shortLinkLocaleState(@Param("linkLocaleStats") LinkLocaleStatsDO linkLocaleStatsDO);
}
