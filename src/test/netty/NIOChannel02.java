package test.netty;

import java.io.File;
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
public class NIOChannel02 {


    /**
     * NIO的写数据操作的数据流向
     * @param args
     */
    public static void main(String[] args) {
        try {
            //创建输入流->放入channel
            File file = new File("/usr/local/test/test.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            //获取对应的channel（类型）
            //虽然显示是FileChannel 但是实际是FileChannelImpl
            FileChannel channel = fileInputStream.getChannel();

            //创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());


            //将通道数据(从文件中读取的数据)放入到buffer中
            channel.read(byteBuffer);

            //将字节转换成字符串
            System.out.println(new String(byteBuffer.array()));

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
