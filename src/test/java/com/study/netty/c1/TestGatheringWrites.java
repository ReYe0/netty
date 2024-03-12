package com.study.netty.c1;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author XuYong
 */
public class TestGatheringWrites {
    public static void main(String[] args) {
        ByteBuffer b1 = StandardCharsets.UTF_8.encode("hello");
        ByteBuffer b2 = StandardCharsets.UTF_8.encode("world");
        ByteBuffer b3 = StandardCharsets.UTF_8.encode("你好");

        try(CloseableRandomAccessFile closeableFile = new CloseableRandomAccessFile("words.txt", "r");
            FileChannel channel = closeableFile.getChannel()){
            channel.write(new ByteBuffer[]{b1,b2,b3});
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
