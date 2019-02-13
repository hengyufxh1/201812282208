package com.itstar.day08.server.impl;

import com.itstar.day08.server.MyInterface;
import org.apache.hadoop.ipc.ProtocolSignature;
import java.io.IOException;

/**
 * 接口实现
 * @author DXW
 */
public class MyInterfaceImpl implements MyInterface {

    public String HelloWorld(String name) {
        return "Hello World！！"+name;
    }
    // 返回版本号
    public long getProtocolVersion(String s, long l) throws IOException {
        System.out.println("版本号："+MyInterface.versionID);
        return MyInterface.versionID;
    }

    // 返回签名信息
    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        System.out.println("版本号："+MyInterface.versionID);
        return new ProtocolSignature(versionID,null);
    }
}
