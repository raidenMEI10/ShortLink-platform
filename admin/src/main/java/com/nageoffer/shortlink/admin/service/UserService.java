package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.UserDO;
import com.nageoffer.shortlink.admin.dto.req.UserLoginReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户接口
 */
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserRespDTO getUserByUsername(String username);

    /*
    * 判断用户名是否存在
     */
    Boolean hasUsername(String username);

    /**
     *  用户注册
     * @param requestParam
     */
    void registor(UserRegisterReqDTO requestParam);

    /**
     * 根据用户名修改用户
     * @param requestParam
     */
    void updateUser(@RequestBody UserUpdateReqDTO requestParam);

    /**
     * 用户登录
     * @param requestParam
     * @return 返回token
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam) ;

    /**
     * 检查用户是否已登录(token是否有效)
     * @param token
     * @return
     */
    Boolean checkLogin(String username,String token);

    /**
     * 退出登录
     * @param username
     * @param token
     */
    void logout(String username, String token);
}
