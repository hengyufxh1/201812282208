package com.itstar.day08.server;

import com.itstar.day08.server.impl.MyInterfaceImpl;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

import java.io.IOException;

/**
 * RPCServer通讯服务
 * @author dxw
 */
public class MyRPCServer {
    // 创建 服务通讯
    public static void main(String[]args) throws IOException {
        // step 1 利用Hadoop RPC 框架 实现RPC通信
        RPC.Builder builder = new RPC.Builder(new Configuration());

        // step 2 定义server参数
        builder.setBindAddress("localhost");
        builder.setPort(7788);

        //step 3部署程序
        // 部署的接口
        builder.setProtocol(MyInterface.class);
        // 部署接口的实现类
        builder.setInstance(new MyInterfaceImpl());

        // step 4 开启Server
        Server server = builder.build();
        server.start();
    }
}
