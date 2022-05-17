package com.example.webchat.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webchat.Entity.FriendEntity;
import com.example.webchat.Entity.UserEntity;
import com.example.webchat.Entity.UserFriendVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface FriendsMapper extends BaseMapper<FriendEntity> {
    /**
     * 获取当前用户的所有朋友
     * @param userid
     * @return
     */
    @Select("select B.id,B.Name,B.img,B.Email from chat_Friends as A inner join chat_User as B on B.id=A.targetid WHERE A.thenId=#{userid}")
    public List<UserFriendVo> GetAllFriend(int userid);

}
