package com.itstar.day081;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * 客户端
 */
public class MyClient {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            HelloWorldService proxy = RPC.getProxy(
            		HelloWorldService.class, 
            		HelloWorldService.versionID, 
            		new InetSocketAddress("localhost",8888), 
            		conf);
            String result = proxy.sayHello("world");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}