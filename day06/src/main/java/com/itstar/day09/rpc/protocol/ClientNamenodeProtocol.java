package com.itstar.day09.rpc.protocol;

public interface ClientNamenodeProtocol {

    public static final long versionID =1L;
    // 拿到元数据信息 hdfs dfs -cat /8888
    public String getMetaData(String path);
}
