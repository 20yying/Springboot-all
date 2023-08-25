package com.yy.dao;

import com.yy.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper

public interface UsersDao {
    @Select("select * from users where id = #{id}")
    public Users getById(Integer id);

}
