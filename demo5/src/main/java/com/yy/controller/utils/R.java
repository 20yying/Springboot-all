package com.yy.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class R {
    private Boolean flag;
    private Object Date;
    private String msg;
    public static R ok(Object date){
        return new R(true,date,null);
    }
    public static R ok(Object date,String msg){
        return new R(true,date,msg);
    }


    public static R error(Object date,String msg){
        return new R(false,date,msg);
    }
    public static R error(Boolean flag,String msg){
        return new R(flag,null,msg);
    }
    public static R error(Boolean flag,Object date){
        return new R(flag,date,null);
    }
    public static R error(Boolean flag,Object date,String msg){
        return new R(flag,date,msg);
    }
}
