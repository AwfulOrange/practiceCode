package test;

/**
 * @Author chenxiangge
 * @Date 3/30/21
 */
public class Singleton4 {
    public static Singleton4 s;

    static {
        s = new Singleton4();
        System.out.println("创建A");
    }

    public static void main(String[] args) {

    }
}
