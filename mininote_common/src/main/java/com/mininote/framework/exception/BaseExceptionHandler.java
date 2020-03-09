package com.mininote.framework.exception;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公共异常处理类
 * @author 张某
 * @description com.mininote.framework.exception
 */
@ControllerAdvice  //开启Spring AOP
public class BaseExceptionHandler {
    /***
     * 异常处理
     */
    //配置拦截的异常,Exception代表所有异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
