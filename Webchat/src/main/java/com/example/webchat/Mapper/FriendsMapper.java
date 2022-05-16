package com.example.webchat.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webchat.Entity.FriendEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FriendsMapper extends BaseMapper<FriendEntity> {
}
