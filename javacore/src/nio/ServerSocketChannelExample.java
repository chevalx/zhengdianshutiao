package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ServerSocketChannelExample {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.socket().bind(new InetSocketAddress(9999));
            serverChannel.configureBlocking(false);
            while (true) {
                SocketChannel clientChannel = serverChannel.accept();
                if (clientChannel != null) {
                    ByteBuffer inBuffer = ByteBuffer.allocate(10);
                    int readBytes = clientChannel.read(inBuffer);
                    int totalBytes = readBytes;
                    while (readBytes > 0){
                        readBytes = clientChannel.read(inBuffer);
                        totalBytes += readBytes;
                    }
                    if (readBytes == -1) {
                        System.out.println("reach end of stream");
                    }
                    System.out.println(new String(inBuffer.array(), StandardCharsets.UTF_8));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
