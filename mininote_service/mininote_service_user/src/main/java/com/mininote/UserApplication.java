package com.mininote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 张某
 * @DATE 2020/2/27
 * @parent mininote_parent
 * @description com.mininote.user
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mininote.user.dao")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
