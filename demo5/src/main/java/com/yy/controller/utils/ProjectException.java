package com.yy.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//springmvc的异常处理器
//@ControllerAdvice
@RestControllerAdvice
public class ProjectException {
    @ExceptionHandler
    public R doException(Exception ex){
        ex.printStackTrace();
        return R.error(false,"服务器故障，请稍后再试");
    }
}
