package com.mininote.notepad;

import entity.FeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 张某
 * @DATE 2020/2/27
 * @parent mininote_parent
 * @description com.mininote.notepad
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mininote.notepad.dao")
public class NotepadApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotepadApplication.class, args);
    }
}
