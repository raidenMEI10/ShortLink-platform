package com.nageoffer.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nageoffer.shortlink.project.dao.entity.LinkOsStatsDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

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

}
