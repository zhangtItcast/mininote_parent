package com.mininote.oauth.service;

import com.mininote.oauth.util.AuthToken;

/*****
 * @Author: 张某
 * @Date: 2019/7/7 16:23
 * @Description: com.mininote.oauth.service
 ****/
public interface AuthService {

    /***
     * 授权认证方法
     */
    AuthToken login(String username, String password, String clientId, String clientSecret);
}
