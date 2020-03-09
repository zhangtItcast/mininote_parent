package com.mininote.user.controller;

import com.alibaba.fastjson.JSON;
import com.mininote.user.pojo.User;
import com.mininote.user.service.UserService;
import entity.BCrypt;
import entity.JwtUtil;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 张某
 * @DATE 2020/2/27
 * @parent mininote_parent
 * @description com.mininote.user.controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        userService.add(user);
        return new Result(true, StatusCode.OK, "成功注册用户");
    }
    /***
     * 根据用户名查询User数据
     * @param username
     * @return
     */
    @GetMapping({"/{username}","/load/{username}"})
    public Result<User> findById(@PathVariable String username){
        //调用UserService实现根据主键查询User
        User user = userService.findByUsername(username);
        return new Result<User>(true,StatusCode.OK,"查询成功",user);
    }
    /**
     * 用户登入
     * @return
     */
    @RequestMapping("/login")
    public Result<User> login(String username, String password, HttpServletResponse response) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return new Result<User>(false, StatusCode.ERROR, "用户不存在");
        } else {
            //checkpw(明文，密文)  返回对比结果
            if (BCrypt.checkpw(password, user.getPassword())) {
                //封装令牌信息
                Map<String, Object> map = new HashMap<>();
                map.put("role", "USER");
                map.put("flag", true);
                map.put("user", user);
                //生成令牌
                String token = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(map), null);
                //1、设置到响应头中
                response.setHeader("Authorization", token);
                //2、保存在cookie中
                Cookie cookie = new Cookie("Authorization", token);
                //设置cookie生效范围
                cookie.setPath("/");
                response.addCookie(cookie);
                return new Result<User>(true, StatusCode.OK, "登录成功！", user);
            } else {
                return new Result<User>(false, StatusCode.ERROR, "密码不正确！");
            }
        }
    }
}
