package com.example.webchat;

import com.example.webchat.server.ZookeeperServer;
import org.apache.zookeeper.KeeperException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class zkTest {
    @Autowired
    ZookeeperServer server;

    @Test
    void Test() throws InterruptedException, KeeperException {
        String Node = server.SelectNode();
        System.out.println(Node);
    }
}
