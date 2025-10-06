package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.GroupDO;
import org.springframework.stereotype.Service;

/**
 * 短连接分组服务接口
 */

public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短连接分组名
     * @param groupName
     */
    void saveGroup(String groupName);
}
