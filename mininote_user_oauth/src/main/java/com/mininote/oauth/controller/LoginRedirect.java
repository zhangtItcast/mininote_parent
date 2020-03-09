package com.mininote.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 张某
 * @description com.mininote.oauth.controller
 * @date 2020-2-27
 */
@Controller
@RequestMapping("oauth")
public class LoginRedirect {

    @RequestMapping("login")
    public String login(@RequestParam(value = "FROM",required = false) String from, Model model) {
        //返回跳转的请求地址
        model.addAttribute("from", from);
        return "login";
    }
}
