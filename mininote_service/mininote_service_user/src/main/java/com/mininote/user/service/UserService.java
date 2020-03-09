package com.mininote.user.service;

import com.mininote.user.pojo.User;

/**
 * @author 张某
 * @DATE 2020/2/27
 */
public interface UserService {
    /**
     * 新增用户, 注册
     * @param user
     */
    void add(User user);

    /**
     * 查询用户
     * @param username
     * @return
     */
    User findByUsername(String username);

}
