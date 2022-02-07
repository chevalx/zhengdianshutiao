package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class SocketChannelExample {
    public static void main(String[] args) {
        // 创建
        SocketChannel channel = null;
        try {
            channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("192.168.10.35", 233));

            while (!channel.finishConnect()) {
                System.out.println("connecting...");
            }
            // read from a channel
//        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
//        int bytesRead = channel.read(byteBuffer);

            // write into a channel
            String newData = "New String to write to file..." + System.currentTimeMillis();
            ByteBuffer writeBuffer = ByteBuffer.allocate(48);
            writeBuffer.clear();
            writeBuffer.put(newData.getBytes(StandardCharsets.UTF_8));
            writeBuffer.flip();
            while (writeBuffer.hasRemaining()) {
                channel.write(writeBuffer);
            }
            // 关闭
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
