package com.example.webchat.server;

import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//对服务进行选举
public class OnLineServerNode {

    @Autowired

    ZookeeperServer zkCli;

    String GetNode(){
        try {
            return zkCli.SelectNode();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return null;
    }

}

