package com.mininote.user.feign;

import com.mininote.user.pojo.User;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张某
 * @DATE 2020/2/28
 */
@FeignClient(name = "user")
@RequestMapping("/user")
public interface UserFeign {
    /***
     * 根据ID查询User数据
     * @param username
     * @return
     */
    @GetMapping("/load/{username}")
    public Result<User> findById(@PathVariable String username);
}
