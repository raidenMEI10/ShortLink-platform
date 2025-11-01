package com.nageoffer.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nageoffer.shortlink.project.dao.entity.LinkOsStatsDO;
import com.nageoffer.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.nageoffer.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * 操作系统访问统计Mapper接口
 */
public interface LinkOsStatsMapper extends BaseMapper<LinkOsStatsDO> {
    /**
     * 记录地区访问统计数据
     * @param
     */
    @Insert("INSERT INTO\n" +
            "  t_link_os_stats (\n" +
            "    full_short_url,\n" +
            "    gid,\n" +
            "    date,\n" +
            "    cnt,\n" +
            "    os,\n" +
            "    update_time,"+
            "    create_time,\n" +
            "    del_flag\n" +
            "  )\n" +
            "VALUES(\n" +
            "    #{linkOsStats.fullShortUrl},\n" +
            "    #{linkOsStats.gid},\n" +
            "    #{linkOsStats.date},\n" +
            "    #{linkOsStats.cnt},\n" +
            "    #{linkOsStats.os},"+
            "    NOW(),\n" +
            "    NOW(),\n" +
            "    0 \n" +
            "  ) ON DUPLICATE KEY\n" +
            "UPDATE\n" +
            "  cnt = cnt + #{linkOsStats.cnt};")
    void shortLinkOsState(@Param("linkOsStats") LinkOsStatsDO linkOsStatsDO);

    /**
     * 根据短链接获取指定日期内操作系统监控数据
     */
    @Select("SELECT " +
            "    os, " +
            "    SUM(cnt) AS count " +
            "FROM " +
            "    t_link_os_stats " +
            "WHERE " +
            "    full_short_url = #{param.fullShortUrl} " +
            "    AND gid = #{param.gid} " +
            "    AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    full_short_url, gid, os;")
    List<HashMap<String, Object>> listOsStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内操作系统监控数据
     */
    @Select("SELECT " +
            "    os, " +
            "    SUM(cnt) AS count " +
            "FROM " +
            "    t_link_os_stats " +
            "WHERE " +
            "    gid = #{param.gid} " +
            "    AND date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    gid, os;")
    List<HashMap<String, Object>> listOsStatsByGroup(@Param("param") ShortLinkGroupStatsReqDTO requestParam);
}
