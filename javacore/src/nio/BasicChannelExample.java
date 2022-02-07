package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

/**
 * 基本示例
 * 使用FileChannel读取文件内容
 */
public class BasicChannelExample {
    public static void main(String[] args) {
        // 创建文件对象，只有RandomAccessFile才有getChannel方法
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("resources/basic_channel_example.txt", "rw");
            // 获得Channel
            FileChannel inChannel = raf.getChannel();
            // 分配Buffer，48个字节
            ByteBuffer buffer = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buffer);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
                bytesRead = inChannel.read(buffer);
            }
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
