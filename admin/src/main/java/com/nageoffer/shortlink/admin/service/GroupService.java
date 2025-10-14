package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.GroupDO;
import com.nageoffer.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.nageoffer.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * 短连接分组服务接口
 */

public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短连接分组名
     * @param groupName
     */
    void saveGroup(String groupName);

    /**
     * 新增短连接分组名
     * @param username 用户名
     * @param groupName 分组名
     */
    void saveGroup(String groupName, String username);

    /**
     * 查询用户短连接分组集合
     * @return
     */
    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * 修改短连接分组
     * @param requestParam
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * 删除短连接分组
     * @param gid
     */
    void deleteGroup(String gid);

    /**
     * 分组排序
     * @param requestParam
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
