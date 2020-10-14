package test.jvm;

/**
 * @Author chenxiangge
 * @Date 2020/8/21
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=============helloGC");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
