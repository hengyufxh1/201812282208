package com.itstar.day06;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;


/**
 * @author dxw
 * 利用HDFS 创建文件
 */
class HDFSMkDir {

    public static void main(String[] args) throws IOException {
        // method2：指定用户访问
        System.setProperty("HADOOP_USER_NAME", "root");
        // step1 配置参数 指定namenode地址
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://11.11.11.131:9000");
        // step2 创建客户端m

        FileSystem client = FileSystem.get(conf);
        // step3 创建目录
        client.mkdirs(new Path("/test10005"));
        client.close();
        System.out.println("Successful");
    }
}
