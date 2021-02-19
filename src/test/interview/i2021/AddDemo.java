package test.interview.i2021;

/**
 * @Author chenxiangge
 * @Date 2/19/21
 */
public class AddDemo {
    public static void main(String[] args) {
        int i = 1;
        i++;
//        System.out.println("i=" + i);
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }
}
