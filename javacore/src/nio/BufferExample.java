package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class BufferExample {
    public static void main(String[] args) {
        try {
            RandomAccessFile aFile = new RandomAccessFile("resources/buffer_example.txt", "rw");
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = inChannel.read(buffer);
            System.out.println(buffer.remaining());
            System.out.println(buffer.position());
            buffer.flip();
            System.out.println(buffer.position());
            byte[] dst = new byte[32];
            buffer.get(dst);
            System.out.println(buffer.position());
            buffer.rewind();
            System.out.println(buffer.position());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
