package com.nageoffer.shortlink.admin.controller;

import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.common.convention.result.Results;
import com.nageoffer.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.nageoffer.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.nageoffer.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.nageoffer.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短连接分组控制层
 */
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    /**
     * 新增短连接分组
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/group")
    public Result<Void> saveGroup(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    /**
     * 查询用户短连接分组集合
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

    /**
     * 更新短连接分组名
     * @param requestParam
     * @return
     */
    @PutMapping("/api/short-link/admin/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam) {
        groupService.updateGroup(requestParam);
        return Results.success();

    }

    /**
     * 删除短连接分组名
     * @param gid
     * @return
     */
    @DeleteMapping("/api/short-link/admin/v1/group")
    public Result<Void> updateGroup(@RequestParam String gid ) {
        groupService.deleteGroup(gid);
        return Results.success();

    }

    /**
     * 短连接分组排序
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/group/sort")
    public Result<Void> updateGroup(@RequestBody List<ShortLinkGroupSortReqDTO> requestParam ) {
        groupService.sortGroup(requestParam);
        return Results.success();

    }
}
