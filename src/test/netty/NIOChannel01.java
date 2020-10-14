package test.netty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author chenxiangge
 * @Date 2020/7/21
 */
public class NIOChannel01 {


    /**
     * NIO的写数据操作的数据流向
     * @param args
     */
    public static void main(String[] args) {
        try {
            String str = "hello";
            //创建输出流->放入channel
            FileOutputStream fileInputStream = new FileOutputStream("/usr/local/test/test.txt");
            //获取对应的channel（类型）
            //虽然显示是FileChannel 但是实际是FileChannelImpl
            FileChannel fileChannel = fileInputStream.getChannel();

            //创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //将字符串放入缓冲区
            byteBuffer.put(str.getBytes());
            //翻转缓冲区，准备做读操作
            byteBuffer.flip();

            //将缓冲区写入到channel
            fileChannel.write(byteBuffer);

            //关闭文件流
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
