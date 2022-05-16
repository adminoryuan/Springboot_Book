package com.example.webchat.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webchat.Entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {


}
