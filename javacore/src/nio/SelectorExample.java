package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * 简单的echo server
 */
public class SelectorExample {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(233));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        SocketChannel acceptedChannel = serverSocketChannel.accept();
                        acceptedChannel.configureBlocking(false);
                        acceptedChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println(acceptedChannel.getLocalAddress().toString());
                    } else if (key.isReadable()) {
                        ByteBuffer readBuffer = ByteBuffer.allocate(8);
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        while (clientChannel.read(readBuffer) > 0) {
                            System.out.println(new String(readBuffer.array(), StandardCharsets.UTF_8));
                        }
                    } else if (key.isWritable()) {
//                        ByteBuffer writeBuffer = ByteBuffer.allocate(128);
//                        writeBuffer.put("Hi, I'm NIO Server".getBytes(StandardCharsets.UTF_8));
//                        writeBuffer.flip();
//                        ((SocketChannel) key.channel()).write(writeBuffer);
//                        System.out.println("write to client.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
