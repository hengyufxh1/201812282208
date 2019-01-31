package com.itstar.day08.server;

import org.apache.hadoop.ipc.VersionedProtocol;

/**
 * 接口
 * @author dxw
 */
public interface MyInterface extends VersionedProtocol {
    public static long versionID=1001;
    public String HelloWorld(String name);
}
