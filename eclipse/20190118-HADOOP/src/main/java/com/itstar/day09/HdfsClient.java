package com.itstar.day09;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

public class HdfsClient {
    FileSystem fs = null;


    public void init(){
        Configuration conf = new Configuration();
        // 设置的副本数（修改配置文件）
        conf.set("dfs.replication","2");
//        conf.set("dfs.");
    }


    public void hdfsLs() throws IOException {
//        RemoteIterator<LocatedFileStatus> iter = fs.listFiles(new Path("/"),new Path("/"));
//
//        while(iter.hasNext()){
//            LocatedFileStatus status = iter.next();
//            System.out.println("文件路径为："+status.getPath());
//            System.out.println("块大小为："+status.getBlockSize());
//            System.out.println("文件长度为："+status.getLen());
//            System.out.println("副本数量为："+status.getReplication());
//            System.out.println("快信息为："+ Arrays.toString(status.getBlockLocations()));
//
//
//            //分割线
//            System.out.println("=============================================");
//        }
    }


//    public void hdfs


    // 下载
    @Test
    public void  hdfsGet(){
        try{
            fs.copyToLocalFile(new Path("/test001/a.txt"),new Path("E:\\bigdata\\hadoop\\day06\\a.txt"));
        }catch (IOException e){

        }
    }
}
