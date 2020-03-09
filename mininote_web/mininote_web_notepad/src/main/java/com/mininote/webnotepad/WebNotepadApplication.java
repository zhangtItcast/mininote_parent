package com.mininote.webnotepad;

import entity.FeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author 张某
 * @DATE 2020/2/29
 * @parent mininote_parent
 * @description com.mininote.webnotepad
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.mininote.notepad.feign")
public class WebNotepadApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebNotepadApplication.class, args);
    }

    /**
     * feign 調用拦截
     * @return
     */
    @Bean
    public FeignInterceptor getFeignInterceptor() {
        return new FeignInterceptor();
    }
}

