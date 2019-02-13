package com.itstar.day081;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

/**
 * 服务器端
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            Server server = new RPC.Builder(conf)
                    //设置协议
                    .setProtocol(HelloWorldService.class)
                    //设置实现类
                    .setInstance(new HelloWorldServiceImpl())
                    //绑定地址
                    .setBindAddress("localhost")
                    //设置处理器个数
                    .setNumHandlers(2)
                    //设置端口号
                    .setPort(8888).build();
            //build完之后，启动服务器
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
