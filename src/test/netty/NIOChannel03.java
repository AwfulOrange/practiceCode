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
public class NIOChannel03 {


    /**
     * NIO的写数据操作的数据流向
     * @param args
     */
    public static void main(String[] args) {
        try {
            //创建输入流->放入channel
            FileInputStream fileInputStream = new FileInputStream("1.txt");
            //获取对应的channel（类型）
            //虽然显示是FileChannel 但是实际是FileChannelImpl
            FileChannel channel = fileInputStream.getChannel();
            FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
            FileChannel outChannel = fileOutputStream.getChannel();


            //创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);


            //由于不确定数据大小，需要while循环读取数据
            while (true){

                //重要操作，清空byteBuffer中的各种标志位
                //若不执行此操作，数据会出问题
                //未clean position与limit相同 导致read 无法等于-1 复位
                byteBuffer.clear();

                //将通道数据(从文件中读取的数据)放入到buffer中
                int read = channel.read(byteBuffer);
                if(read== -1){
                    break;
                }

                //buffer 翻转转变进入读阶段
                byteBuffer.flip();
                //将buffer写入channel
                outChannel.write(byteBuffer);
            }

            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
