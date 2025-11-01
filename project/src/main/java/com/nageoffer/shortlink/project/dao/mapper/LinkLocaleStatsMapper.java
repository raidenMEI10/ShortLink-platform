package com.nageoffer.shortlink.project.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nageoffer.shortlink.project.dao.entity.LinkLocaleStatsDO;
import com.nageoffer.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.nageoffer.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 根据短链接获取指定日期内基础监控数据
     */
    @Select("SELECT " +
            "    province, " +
            "    SUM(cnt) AS cnt " +
            "FROM " +
            "    t_link_locale_stats " +
            "WHERE " +
            "    full_short_url = #{param.fullShortUrl} " +
            "    AND gid = #{param.gid} " +
            "    AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    full_short_url, gid, province;")
    List<LinkLocaleStatsDO> listLocaleByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内地区监控数据
     */
    @Select("SELECT " +
            "    province, " +
            "    SUM(cnt) AS cnt " +
            "FROM " +
            "    t_link_locale_stats " +
            "WHERE " +
            "    gid = #{param.gid} " +
            "    AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    gid, province;")
    List<LinkLocaleStatsDO> listLocaleByGroup(@Param("param") ShortLinkGroupStatsReqDTO requestParam);
}
