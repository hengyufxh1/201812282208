package com.itstar.day07;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;

/**
 * HDFS下载文件
 * @author dxw
 */
public class HDFSDownload {

    public static void main(String[] args) throws IOException {

        System.setProperty("HADOOP_USER_NAME", "root");
        // step1 建立客户端
        Configuration conf = new Configuration();
        // 使用IP地址 因为没有指定bigdata121 对应的IP
        conf.set("fs.defaultFS", "hdfs://11.11.11.131:9000");
        FileSystem client = FileSystem.get(conf);
        // step2 创建数据输入流 指向HDFS 从HDFS读取数据 hdfs dfs -get copyToLocal
        InputStream input = client.open(new Path("/test/out1/part-r-00000"));
        // step 3 创建本地输出流
        OutputStream output = new FileOutputStream("E:\\localhost_201811230927_IDEAMyTest\\project\\test\\out\\a.txt");
        // step 4 开始写入本地
        /**IOUtils**/
        IOUtils.copyBytes(input,output,1024);





    }
}
