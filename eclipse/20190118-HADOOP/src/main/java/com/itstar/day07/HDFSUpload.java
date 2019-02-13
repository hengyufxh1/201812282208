package com.itstar.day07;


import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;

/**
 * HDFS上传文件
 * @author dxw
 */
public class HDFSUpload {

    public static void main(String[] args) throws IOException {
        // 模拟root用户
        System.setProperty("HADOOP_USER_NAME", "root");
        // 在windows配置环境变量可以不用写这里
//         System.setProperty("hadoop.home.dir", "D:\\java\\hadoop-2.7.3");

        // step1 建立客户端
        Configuration conf = new Configuration();
        // 使用IP地址 因为没有指定bigdata124 对应的IP
        conf.set("fs.defaultFS", "hdfs://11.11.11.131:9000");

        FileSystem client = FileSystem.get(conf);

        // step2 创建本地数据 hdfs dfs -put copyFromLocal
        File file1 = new File("D:\\bigdata\\localhost_hadoop\\a.txt");
        FileInputStream input = new FileInputStream(file1);

        // step3 创建本地输出流指向HDFS
        OutputStream output = client.create(new Path("/test103/test3.txt"));
        // step 4 开始写入 HDFS
//        /**方法1**/
//        int len = 0;
//        // 因为 read 当读到文件末尾的时候 会返回-1
//        while((len=input.read())!=-1){
//            output.write(len);
//        }
//        output.flush();
//        input.close();
//        output.close();
        /**方法2 IOUTils**/
        IOUtils.copyBytes(input,output,1024);
        System.out.println("hdfs dfs upload OK~");
    }
}
