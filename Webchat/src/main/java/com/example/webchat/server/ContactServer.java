package com.example.webchat.server;

import com.example.webchat.Mapper.FriendsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServer {

    @Autowired
    FriendsMapper mapper;



}
