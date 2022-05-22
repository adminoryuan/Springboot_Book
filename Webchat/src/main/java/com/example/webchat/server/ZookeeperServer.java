package com.example.webchat.server;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class ZookeeperServer {
    final  String ZookServerAddr="0.0.0.0";
    final int port=2181;

    final String CurrNodeName="Node1";
    final String CurrNodeVal="127.0.0.1:9000";

    private ZooKeeper zooKeeper;

    public ZookeeperServer()  {
        Watcher watcher=new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.printf("链接成功");
            }
        };
        try {
            zooKeeper=new ZooKeeper(ZookServerAddr,port,watcher);
            // * 持久：PERSISTENT
            //             * 持久序列节点：PERSISTENT_SEQUENTIAL
            //             * 临时：EPHEMERAL
            //             * 临时序列节点：EPHEMERAL_SEQUENTIA

            zooKeeper.create("/ImServer/"+CurrNodeName,CurrNodeVal.getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        } catch (IOException e) {
            System.out.printf("链接失败");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    public String SelectNode() throws InterruptedException, KeeperException {
        Stat stat=new Stat();
        byte[] data = zooKeeper.getData("/ImServer", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        }, stat);


        List<String> children = zooKeeper.getChildren("/ImServer", true);


        //随机从中选中一个节点返回给客户端
        int i = new Random().nextInt(children.size());


        return new String(zooKeeper.getData("/ImServer/"+children.get(i),true,new Stat())) ;
    }
}
