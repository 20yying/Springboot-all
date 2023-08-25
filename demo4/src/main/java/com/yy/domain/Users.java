package com.yy.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("users")
public class Users {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String username;

    @TableField(value = "birthday",select = false)
    private Date birthday;
    private Integer age;
    private String sex;

    private String address;

//    @TableLogic(value = "0", delval = "1")
    private Integer isDelete;

    @TableField(exist = false)
    private Integer hh;
    @Version
    private Integer version;

}
