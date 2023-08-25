package com.yy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yy.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersDao extends BaseMapper<Users> {
}
