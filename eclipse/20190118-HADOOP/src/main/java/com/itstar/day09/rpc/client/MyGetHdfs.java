package com.itstar.day09.rpc.client;

import com.itstar.day09.rpc.protocol.ClientNamenodeProtocol;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MyGetHdfs {

    public static void main(String [] args) throws IOException {
        // 1、拿到协议
        ClientNamenodeProtocol proxy =
                RPC.getProxy(
                        ClientNamenodeProtocol.class,
                        1L,
                        new InetSocketAddress("localhost",7777),
                        new Configuration());
        // 2、发送请求 （查看hdfs中/8888）
        String metaData = proxy.getMetaData("/8888");

        // 3、拿到相对的元数据信息
        System.out.println(metaData);
    }
}
