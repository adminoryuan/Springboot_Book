package com.example.webchat.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class FriendEntity {

    int id;

    @TableField(value = "thenid")
    int ThenId;

    @TableField(value = "targetid")
    int TargetId;

}
