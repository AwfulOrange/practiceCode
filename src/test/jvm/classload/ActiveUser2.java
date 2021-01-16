package test.jvm.classload;

import java.util.Random;

/**
 * @Author chenxiangge
 * @Date 1/13/21
 *
 * 测试类类的主动使用：调用类的<clinit>()，即执行了类的初始化阶段
 * 1、创建类的事例
 */
public class ActiveUser2 {
    public static void main(String[] args) {
//        System.out.println(User.num1);
//        System.out.println(User.num2);
//        System.out.println(User.num3);
    }
}

/**
 *
 */

class User{
    static {
        System.out.println("User类的初始化");
    }

    //final类型的数据在准备阶段（加载）就已确定-不会涉及类的初始化
    public static final int num1 =2;
    //类的初始化
    public static int num2 =2;
    //类的初始化
    public static int num3 =new Random().nextInt(10);
}