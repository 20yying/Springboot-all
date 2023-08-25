package com.yy.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data

public class Student {
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    @TableLogic(value = "0", delval = "1")
    private Integer deleted;

}
