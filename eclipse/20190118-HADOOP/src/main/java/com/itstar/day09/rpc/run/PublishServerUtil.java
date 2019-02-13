package com.itstar.day09.rpc.run;

import com.itstar.day09.rpc.protocol.ClientNamenodeProtocol;
import com.itstar.day09.rpc.service.MyNameNode;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

/**
 * 1.启动hdfs集群
 * 2.操作
 */
public class PublishServerUtil {

    public static void main(String [] args ) throws IOException {
        // 1、构建rpc框架
        RPC.Builder builder = new RPC.Builder(new Configuration());

        // 2、绑定地址
        builder.setBindAddress("localhost");
        // 3、绑定端口号
        builder.setPort(7777);

        // 4、绑定遵循的协议
        builder.setProtocol(ClientNamenodeProtocol.class);

        // 5、调用协议的实现类（启动 namenode）
        builder.setInstance(new MyNameNode());

        // 6、创建服务 跑起来
//        builder.build().start();

        RPC.Server server = builder.build();
        server.start();
    }
}
