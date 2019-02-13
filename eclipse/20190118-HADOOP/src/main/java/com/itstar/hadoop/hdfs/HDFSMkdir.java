package com.itstar.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;



public class HDFSMkdir {

    public static void main(String[] args) throws IOException {
        // method2 匿名
        System.setProperty("HADOOP_USER_NAME", "root");
        // step1 创建conf连接
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://11.11.11.121:9000");
        // step2 晃去文件目录
        FileSystem client = FileSystem.get(conf);
        // step3 鍒涘缓鐩綍
        client.mkdirs(new Path("/test102"));
        client.close();
        System.out.println("Successful");
    }
}
