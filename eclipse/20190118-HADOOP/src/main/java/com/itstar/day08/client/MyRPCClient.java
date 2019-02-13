package com.itstar.day08.client;

import com.itstar.day08.server.MyInterface;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * 调用RPC通讯客户端
 * @author dxw
 */
public class MyRPCClient {
    public static void main(String [] args) throws IOException {
        // 使用 RPC框架 调用Server
        MyInterface proxy =  RPC.getProxy(
                MyInterface.class,
                MyInterface.versionID,
                new InetSocketAddress("localhost",7788),
                new Configuration());
        String result = proxy.HelloWorld("我调用了RPC通讯");
        
        System.out.println(result);
    }
}