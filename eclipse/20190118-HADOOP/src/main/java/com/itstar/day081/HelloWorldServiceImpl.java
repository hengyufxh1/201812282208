package com.itstar.day081;
import java.io.IOException;
import org.apache.hadoop.ipc.ProtocolSignature;

public class HelloWorldServiceImpl implements HelloWorldService {

    public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
        return 1;
    }

    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion, int clientMethodsHash)
            throws IOException {
        try {
            return ProtocolSignature.getProtocolSignature(protocol, clientVersion);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String sayHello(String msg) {
        System.out.println(msg);
        return "hello" + msg;
    }
}
