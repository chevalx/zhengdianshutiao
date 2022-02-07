package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class ScatterGatherExample {
    public static void main(String[] args) {
        int headerLength = 9;
        int bodyLength = 128;
        ByteBuffer headerBuffer = ByteBuffer.allocate(headerLength);
        ByteBuffer bodyBuffer = ByteBuffer.allocate(bodyLength);
        try {
            RandomAccessFile aFile = new RandomAccessFile("resources/scatter_gather_example.txt", "rw");
            FileChannel channel = aFile.getChannel();
            channel.read(new ByteBuffer[]{headerBuffer, bodyBuffer});
            String header = new String(headerBuffer.array());
            String body = new String(bodyBuffer.array());
            System.out.println("header = " + header);
            System.out.println("body = " + body.trim());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
