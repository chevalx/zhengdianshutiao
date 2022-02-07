package com.jenkov.nioserver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by jjenkov on 16-10-2015.
 */
public class Socket {

    public long socketId;

    public SocketChannel  socketChannel = null;
    public IMessageReader messageReader = null;
    public MessageWriter  messageWriter = null;

    public boolean endOfStreamReached = false;

    public Socket() {
    }

    public Socket(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    /**
     * 从channel读取数据到传入的buffer，只读取byteBuffer大小的数据
     * 例如如果buffer大小为1024字节，发送端发送了1070个字节，则本次只会读1024个字节，剩下的46个字节会在下次select的时候读
     * @param byteBuffer
     * @return
     * @throws IOException
     */
    public int read(ByteBuffer byteBuffer) throws IOException {
        int bytesRead = this.socketChannel.read(byteBuffer);
        int totalBytesRead = bytesRead;

        while(bytesRead > 0){
            bytesRead = this.socketChannel.read(byteBuffer);
            totalBytesRead += bytesRead;
        }
        if(bytesRead == -1){
            this.endOfStreamReached = true;
        }

        return totalBytesRead;
    }

    public int write(ByteBuffer byteBuffer) throws IOException{
        int bytesWritten      = this.socketChannel.write(byteBuffer);
        int totalBytesWritten = bytesWritten;

        while(bytesWritten > 0 && byteBuffer.hasRemaining()){
            bytesWritten = this.socketChannel.write(byteBuffer);
            totalBytesWritten += bytesWritten;
        }

        return totalBytesWritten;
    }


}
