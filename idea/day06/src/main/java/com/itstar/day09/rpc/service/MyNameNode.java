package com.itstar.day09.rpc.service;


import com.itstar.day09.rpc.protocol.ClientNamenodeProtocol;

/**
 * 元数据信息
 * @author dxw
 * @version 1.0 ,2019年1月24日 22:19:13
 */
public class MyNameNode implements ClientNamenodeProtocol {


    // 当访问到了 namenode时，namenode返回此信息，存储了块和存在与那台机器
    public String getMetaData(String path) {
        return path+": 3 -{BLK_1,BLK_2,BLK_3}...";
    }
}
