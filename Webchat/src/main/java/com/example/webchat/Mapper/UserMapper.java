package com.example.webchat.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webchat.Entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {


}
