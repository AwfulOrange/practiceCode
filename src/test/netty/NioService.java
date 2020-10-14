package test.netty;

import java.io.IOException;
import java.nio.IntBuffer;
import java.nio.channels.Channel;

/**
 * @Author chenxiangge
 * @Date 2020/7/21
 */
public class NioService {
    public static void main(String[] args) {

        //new buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
//        Channel channel = new Channel() {
//            @Override
//            public boolean isOpen() {
//                return false;
//            }
//
//            @Override
//            public void close() throws IOException {
//
//            }
//        }
        //put sth in buffer

//        buffer.put(1);
//        buffer.put(2);
//        buffer.put(3);
//        buffer.put(4);
//        buffer.put(5);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i);
        }

        //buffer读写切换（不切换则无法正常读）
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

    }
}
