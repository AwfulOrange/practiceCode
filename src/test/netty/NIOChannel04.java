package test.netty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * MappedByteBuffer，可让文件在内存（堆外内存）修改，操作系统不需要拷贝一次
 *
 * @Author chenxiangge
 * @Date 2020/7/21
 */
public class NIOChannel04 {


    /**
     * NIO的写数据操作的数据流向
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0,(byte)'G');
        mappedByteBuffer.put(1,(byte)'A');
        mappedByteBuffer.put(5,(byte)'A');//indexOutOfBoundException

        //channel是否需要关闭？
//        fileChannel.close();
        randomAccessFile.close();
    }
}
